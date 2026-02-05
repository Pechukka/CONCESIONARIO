DROP DATABASE IF EXISTS car_dealership;
CREATE DATABASE IF NOT EXISTS car_dealership
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
USE car_dealership;

-- =========================
-- 1) Organización
-- =========================
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS repair_material;
DROP TABLE IF EXISTS mechanic_specialty;
DROP TABLE IF EXISTS repair;
DROP TABLE IF EXISTS repair_status;
DROP TABLE IF EXISTS sale;
DROP TABLE IF EXISTS proposal;
DROP TABLE IF EXISTS proposal_status;
DROP TABLE IF EXISTS payment_method;
DROP TABLE IF EXISTS client_vehicle_interest;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS vehicle_image;
DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS vehicle_category;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS material_type;
DROP TABLE IF EXISTS manager;
DROP TABLE IF EXISTS head_mechanic;
DROP TABLE IF EXISTS mechanic;
DROP TABLE IF EXISTS sales_employee;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS dealership;

SET FOREIGN_KEY_CHECKS = 1;

-- =========================
-- CREATE TABLE
-- =========================
CREATE TABLE dealership (
  id_dealership INT NOT NULL AUTO_INCREMENT,
  name          VARCHAR(120) NOT NULL,
  address       VARCHAR(200) NOT NULL,
  city          VARCHAR(80)  NOT NULL,
  province      VARCHAR(80)  NOT NULL,
  country       VARCHAR(80)  NOT NULL,
  PRIMARY KEY (id_dealership)
);

-- =========================
-- 2) Usuarios (base + subtipos)
-- =========================
CREATE TABLE worker (
  id_worker     INT NOT NULL AUTO_INCREMENT,
  id_dealership INT NOT NULL,
  email         VARCHAR(255) NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  full_name     VARCHAR(160) NOT NULL,
  phone_number  VARCHAR(30),
  entry_date    DATE NOT NULL DEFAULT (CURRENT_DATE),
  active        TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_worker),
  UNIQUE KEY ux_worker_email (email),
  KEY ix_worker_dealership (id_dealership),
  CONSTRAINT fk_worker_dealership
    FOREIGN KEY (id_dealership) REFERENCES dealership(id_dealership)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Subtipos (PK = FK a worker)
CREATE TABLE sales_employee (
  id_worker INT NOT NULL,
  PRIMARY KEY (id_worker),
  CONSTRAINT fk_sales_worker
    FOREIGN KEY (id_worker) REFERENCES worker(id_worker)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE mechanic (
  id_worker INT NOT NULL,
  PRIMARY KEY (id_worker),
  CONSTRAINT fk_mechanic_worker
    FOREIGN KEY (id_worker) REFERENCES worker(id_worker)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE head_mechanic (
  id_worker INT NOT NULL,
  PRIMARY KEY (id_worker),
  CONSTRAINT fk_head_mechanic_worker
	FOREIGN KEY (id_worker) REFERENCES mechanic(id_worker)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE manager (
  id_worker INT NOT NULL,
  PRIMARY KEY (id_worker),
  CONSTRAINT fk_manager_worker
    FOREIGN KEY (id_worker) REFERENCES worker(id_worker)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

-- =========================
-- 3) Vehículos
-- =========================
CREATE TABLE vehicle_category (
  id_category SMALLINT NOT NULL,
  name        VARCHAR(30) NOT NULL,
  PRIMARY KEY (id_category),
  UNIQUE KEY ux_vehicle_category_name (name)
);
INSERT INTO vehicle_category (id_category, name) VALUES
(1, 'CAR'),(2, 'MOTORCYCLE'),(3, 'MOPED');

CREATE TABLE vehicle_status (
  id_vehicle_status SMALLINT NOT NULL,
  name              VARCHAR(30) NOT NULL,
  PRIMARY KEY (id_vehicle_status),
  UNIQUE KEY ux_vehicle_status_name (name)
);
INSERT INTO vehicle_status (id_vehicle_status, name) VALUES
(1, 'IN_STOCK'), (2, 'SOLD'), (3, 'IN_REPAIR');

CREATE TABLE vehicle (
  id_vehicle     INT NOT NULL AUTO_INCREMENT,
  id_dealership  INT NOT NULL,
  id_category    SMALLINT NOT NULL,
  id_vehicle_status SMALLINT NOT NULL DEFAULT 1,
  vin            CHAR(17) NOT NULL,
  license_plate  VARCHAR(20),
  brand          VARCHAR(80) NOT NULL,
  model          VARCHAR(80) NOT NULL,
  year           SMALLINT NOT NULL,
  km             INT NOT NULL,
  fuel           VARCHAR(30) NOT NULL,
  base_price     DECIMAL(12,2) NOT NULL,
  arrival_date   DATE NOT NULL,
  PRIMARY KEY (id_vehicle),
  UNIQUE KEY ux_vehicle_vin (vin),
  UNIQUE KEY ux_vehicle_plate (license_plate),
  KEY ix_vehicle_dealership_arrival (id_dealership, arrival_date),
  KEY ix_vehicle_category (id_category),
  KEY ix_vehicle_status (id_vehicle_status),
  KEY ix_vehicle_dealership_status_arrival (id_dealership, id_vehicle_status, arrival_date),
  CONSTRAINT fk_vehicle_dealership
    FOREIGN KEY (id_dealership) REFERENCES dealership(id_dealership)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_vehicle_category
    FOREIGN KEY (id_category) REFERENCES vehicle_category(id_category)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_vehicle_status
    FOREIGN KEY (id_vehicle_status) REFERENCES vehicle_status(id_vehicle_status)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT chk_vehicle_year CHECK (year BETWEEN 1900 AND 2200),
  CONSTRAINT chk_vehicle_km CHECK (km >= 0),
  CONSTRAINT chk_vehicle_price CHECK (base_price >= 0),
  CONSTRAINT chk_vehicle_vin_length CHECK (CHAR_LENGTH(vin) = 17)
);

CREATE TABLE vehicle_image (
  id_image   INT NOT NULL AUTO_INCREMENT,
  id_vehicle INT NOT NULL,
  url        VARCHAR(500) NOT NULL,
  PRIMARY KEY (id_image),
  KEY ix_vehicle_image_vehicle (id_vehicle),
  CONSTRAINT fk_vehicle_image_vehicle
    FOREIGN KEY (id_vehicle) REFERENCES vehicle(id_vehicle)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- =========================
-- 4) Clientes + interés
-- =========================
CREATE TABLE client (
  id_client  INT NOT NULL AUTO_INCREMENT,
  dni_nif    VARCHAR(20) NOT NULL,
  full_name  VARCHAR(160) NOT NULL,
  email      VARCHAR(255),
  phone_number      VARCHAR(30),
  birthdate  DATE,
  address    VARCHAR(220),
  PRIMARY KEY (id_client),
  UNIQUE KEY ux_client_dni (dni_nif)
);

CREATE TABLE client_vehicle_interest (
  id_interest   INT NOT NULL AUTO_INCREMENT,
  id_client     INT NOT NULL,
  id_vehicle    INT NOT NULL,
  interest_date DATE NOT NULL DEFAULT (CURRENT_DATE),
  approx_budget DECIMAL(12,2) NULL,
  notes         TEXT NULL,
  PRIMARY KEY (id_interest),
  UNIQUE KEY ux_interest_client_vehicle (id_client, id_vehicle),
  KEY ix_interest_vehicle (id_vehicle),
  CONSTRAINT fk_interest_client
    FOREIGN KEY (id_client) REFERENCES client(id_client)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_interest_vehicle
    FOREIGN KEY (id_vehicle) REFERENCES vehicle(id_vehicle)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT chk_interest_budget CHECK (approx_budget IS NULL OR approx_budget >= 0)
);

-- =========================
-- 5) Ofertas / ventas
-- =========================
CREATE TABLE payment_method (
  id_payment_method SMALLINT ,
  name              VARCHAR(40) NOT NULL,
  PRIMARY KEY (id_payment_method),
  UNIQUE KEY ux_payment_method_name (name)
);
INSERT INTO payment_method (id_payment_method, name) VALUES
(1, 'CASH'),(2, 'CARD'),(3, 'TRANSFER'),(4, 'FINANCING');

CREATE TABLE proposal_status (
  id_proposal_status SMALLINT NOT NULL,
  name            VARCHAR(40) NOT NULL,
  PRIMARY KEY (id_proposal_status),
  UNIQUE KEY ux_proposal_status_name (name)
);
INSERT INTO proposal_status (id_proposal_status, name) VALUES
(1,'ACTIVE'),(2,'ACCEPTED'),(3,'REJECTED');

CREATE TABLE proposal (
  id_proposal            INT NOT NULL AUTO_INCREMENT,
  id_client           INT NOT NULL,
  id_vehicle          INT NOT NULL,
  id_sales_employee   INT NOT NULL,
  id_payment_method   SMALLINT NOT NULL,
  id_proposal_status     SMALLINT NOT NULL,
  proposal_date          DATE NOT NULL DEFAULT (CURRENT_DATE),
  validity_date       DATE NOT NULL,
  base_price_snapshot DECIMAL(12,2) NOT NULL,
  discount_amount     DECIMAL(12,2) NOT NULL DEFAULT 0,
  final_price         DECIMAL(12,2) NOT NULL,
  details             TEXT NULL,
  PRIMARY KEY (id_proposal),
  KEY ix_proposal_sales (id_sales_employee),
  KEY ix_proposal_vehicle_status (id_vehicle, id_proposal_status),
  CONSTRAINT fk_proposal_client
    FOREIGN KEY (id_client) REFERENCES client(id_client)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_proposal_vehicle
    FOREIGN KEY (id_vehicle) REFERENCES vehicle(id_vehicle)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_proposal_sales_employee
    FOREIGN KEY (id_sales_employee) REFERENCES sales_employee(id_worker)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_proposal_payment_method
    FOREIGN KEY (id_payment_method) REFERENCES payment_method(id_payment_method)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_proposal_status
    FOREIGN KEY (id_proposal_status) REFERENCES proposal_status(id_proposal_status)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT chk_proposal_prices CHECK (
    base_price_snapshot >= 0 AND discount_amount >= 0 AND final_price >= 0),
  CONSTRAINT chk_proposal_discount CHECK (
	discount_amount <= base_price_snapshot),
  CONSTRAINT chk_proposal_validity CHECK (
	validity_date > proposal_date)
);

CREATE TABLE sale (
  id_sale              INT NOT NULL AUTO_INCREMENT,
  id_proposal             INT NOT NULL,
  id_vehicle           INT NOT NULL,
  sale_ts              DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  final_price_snapshot DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (id_sale),
  UNIQUE KEY ux_sale_proposal (id_proposal),
  UNIQUE KEY ux_sale_vehicle (id_vehicle),
  CONSTRAINT fk_sale_proposal
    FOREIGN KEY (id_proposal) REFERENCES proposal(id_proposal)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_sale_vehicle
    FOREIGN KEY (id_vehicle) REFERENCES vehicle(id_vehicle)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT chk_sale_price CHECK (final_price_snapshot >= 0)
);

-- =========================
-- 6) Taller (reparaciones + especialidades + materiales)
-- =========================
CREATE TABLE repair_status (
  id_repair_status SMALLINT NOT NULL,
  name             VARCHAR(40) NOT NULL,
  PRIMARY KEY (id_repair_status),
  UNIQUE KEY ux_repair_status_name (name)
);
INSERT INTO repair_status (id_repair_status, name) VALUES
(1,'PENDING'),(2,'ASSIGNED'),(3,'IN_PROGRESS'),(4,'FINISHED'),(5,'CANCELLED');

CREATE TABLE repair (
  id_repair                INT NOT NULL AUTO_INCREMENT,
  id_dealership            INT NOT NULL,
  id_vehicle               INT NOT NULL,
  id_client                INT NULL,
  created_by_head_mechanic INT NOT NULL,
  assigned_mechanic        INT NULL,
  id_repair_status         SMALLINT NOT NULL,
  creation_ts              DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  start_ts                 DATETIME NULL,
  end_ts                   DATETIME NULL,
  estimated_time_hours     DECIMAL(6,2) NOT NULL,
  estimated_cost           DECIMAL(12,2) NOT NULL,
  final_cost               DECIMAL(12,2) NULL,
  work_type                VARCHAR(120) NOT NULL,
  notes                    TEXT NULL,
  PRIMARY KEY (id_repair),
  KEY ix_repair_vehicle_ts (id_vehicle, creation_ts),
  KEY ix_repair_assigned_status (assigned_mechanic, id_repair_status, creation_ts),
  CONSTRAINT fk_repair_dealership
	FOREIGN KEY (id_dealership) REFERENCES dealership(id_dealership)
	ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_repair_vehicle
    FOREIGN KEY (id_vehicle) REFERENCES vehicle(id_vehicle)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_repair_client
    FOREIGN KEY (id_client) REFERENCES client(id_client)
    ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT fk_repair_created_by
    FOREIGN KEY (created_by_head_mechanic) REFERENCES head_mechanic(id_worker)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_repair_assigned_mechanic
    FOREIGN KEY (assigned_mechanic) REFERENCES mechanic(id_worker)
    ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT fk_repair_status
    FOREIGN KEY (id_repair_status) REFERENCES repair_status(id_repair_status)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT chk_repair_numbers CHECK (
    estimated_time_hours >= 0 AND estimated_cost >= 0
    AND (final_cost IS NULL OR final_cost >= 0)
  ),
  CONSTRAINT chk_repair_ts CHECK (
	(start_ts IS NULL OR start_ts >= creation_ts) AND
	(end_ts IS NULL OR start_ts IS NULL OR end_ts >= start_ts))
);

CREATE TABLE mechanic_specialty (
  id_mechanic INT NOT NULL,
  id_category SMALLINT NOT NULL,
  PRIMARY KEY (id_mechanic, id_category),
  KEY ix_specialty_category (id_category),
  CONSTRAINT fk_specialty_mechanic
    FOREIGN KEY (id_mechanic) REFERENCES mechanic(id_worker)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_specialty_category
    FOREIGN KEY (id_category) REFERENCES vehicle_category(id_category)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE material_type (
  id_material_type SMALLINT NOT NULL,
  name             VARCHAR(40) NOT NULL,
  PRIMARY KEY (id_material_type),
  UNIQUE KEY ux_material_type_name (name)
);

CREATE TABLE material (
  id_material      INT NOT NULL AUTO_INCREMENT,
  id_material_type SMALLINT NOT NULL,
  name             VARCHAR(160) NOT NULL,
  price_ref        DECIMAL(12,2) NOT NULL,
  active           TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_material),
  KEY ix_material_type (id_material_type),
  CONSTRAINT fk_material_type
    FOREIGN KEY (id_material_type) REFERENCES material_type(id_material_type)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT chk_material_price CHECK (price_ref >= 0)
);

CREATE TABLE repair_material (
  id_repair          INT NOT NULL,
  id_material        INT NOT NULL,
  quantity           INT NOT NULL,
  unit_price_applied DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (id_repair, id_material),
  KEY ix_rm_material (id_material),
  CONSTRAINT fk_rm_repair
    FOREIGN KEY (id_repair) REFERENCES repair(id_repair)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_rm_material
    FOREIGN KEY (id_material) REFERENCES material(id_material)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT chk_rm_qty CHECK (quantity > 0),
  CONSTRAINT chk_rm_price CHECK (unit_price_applied >= 0)
);


-- TRIGGERS
-- ============================================================
-- DROP old triggers (if exist)
-- ============================================================
DROP TRIGGER IF EXISTS trg_head_mechanic_unique_active;
DROP TRIGGER IF EXISTS trg_worker_activate_head_mechanic;
DROP TRIGGER IF EXISTS trg_repair_validate_mechanic_specialty;
DROP TRIGGER IF EXISTS trg_repair_validate_mechanic_specialty_upd;

-- ============================================================================
-- TRIGGER: trg_head_mechanic_unique_active
-- Tabla: head_mechanic
-- Evento: BEFORE INSERT
-- Objetivo: Garantizar que exista como máximo un Head Mechanic activo por
--           concesionario (según worker.active = 1).
-- ============================================================================
DELIMITER //
CREATE TRIGGER trg_head_mechanic_unique_active
BEFORE INSERT ON head_mechanic
FOR EACH ROW
BEGIN
    DECLARE active_count INT;
    DECLARE dealership_id INT;
    
    -- Obtener concesionario del trabajador
    SELECT id_dealership INTO dealership_id
    FROM worker
    WHERE id_worker = NEW.id_worker;
    
    -- Contar head mechanics activos en ese concesionario
    SELECT COUNT(*) INTO active_count
    FROM head_mechanic hm
    JOIN worker w ON hm.id_worker = w.id_worker
    WHERE w.id_dealership = dealership_id
      AND w.active = 1;
    
    IF active_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ya existe un head_mechanic activo en este concesionario';
    END IF;
END//

-- ============================================================================
-- TRIGGER: trg_worker_activate_head_mechanic
-- Tabla: worker
-- Evento: BEFORE UPDATE
-- Objetivo: Al activar un worker (active: 0 -> 1), impedir la activación si el
--           worker es Head Mechanic y ya existe otro Head Mechanic activo en el
--           mismo concesionario.
-- ============================================================================
CREATE TRIGGER trg_worker_activate_head_mechanic
BEFORE UPDATE ON worker
FOR EACH ROW
BEGIN
    DECLARE is_head_mechanic TINYINT;
    DECLARE active_count INT;
    
    -- Solo validar si se está activando
    IF OLD.active = 0 AND NEW.active = 1 THEN
        -- Verificar si es head mechanic
        SELECT COUNT(*) INTO is_head_mechanic
        FROM head_mechanic
        WHERE id_worker = NEW.id_worker;
        
        IF is_head_mechanic > 0 THEN
            -- Contar otros head mechanics activos en el mismo concesionario
            SELECT COUNT(*) INTO active_count
            FROM head_mechanic hm
            JOIN worker w ON hm.id_worker = w.id_worker
            WHERE w.id_dealership = NEW.id_dealership
              AND w.active = 1
              AND w.id_worker != NEW.id_worker;
            
            IF active_count > 0 THEN
                SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Ya existe un head_mechanic activo en este concesionario';
            END IF;
        END IF;
    END IF;
END//
DELIMITER ;

-- ============================================================================
-- TRIGGER: trg_repair_validate_mechanic_specialty
-- Tabla: repair
-- Evento: BEFORE INSERT
-- Objetivo: Si se asigna un mecánico (repair.assigned_mechanic), validar que
--           dicho mecánico tenga la especialidad requerida para la categoría
--           del vehículo asociado a la reparación (vehicle.id_category).
--           Si no la tiene, abortar la operación con un error controlado.
-- Notas:    - Si assigned_mechanic es NULL, no se valida nada.
--           - Si el vehículo no existe o no tiene categoría, el trigger
--             también aborta (evita asignaciones incoherentes).
-- ============================================================================
DELIMITER //

DELIMITER //
CREATE TRIGGER trg_repair_validate_mechanic_specialty
BEFORE INSERT ON repair
FOR EACH ROW
BEGIN
    DECLARE vehicle_cat SMALLINT;
    
    IF NEW.assigned_mechanic IS NOT NULL THEN
        SELECT v.id_category INTO vehicle_cat
        FROM vehicle v
        WHERE v.id_vehicle = NEW.id_vehicle;
        
        IF NOT EXISTS (
            SELECT 1 FROM mechanic_specialty
            WHERE id_mechanic = NEW.assigned_mechanic
              AND id_category = vehicle_cat
        ) THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Mechanic lacks required specialty for vehicle category';
        END IF;
    END IF;
END//

-- ============================================================================
-- TRIGGER: trg_repair_validate_mechanic_specialty_upd
-- Tabla: repair
-- Evento: BEFORE UPDATE
-- Objetivo: En una actualización, validar la especialidad del mecánico SOLO
--           cuando cambie la asignación (assigned_mechanic) o cuando se cambie
--           el vehículo (id_vehicle) con mecánico asignado.
--           Si no cumple, abortar con un error controlado.
-- Notas:    - Maneja correctamente NULL (comparación segura).
--           - Si assigned_mechanic queda NULL, no se valida.
--           - Si el vehículo no existe o no tiene categoría, aborta.
-- ============================================================================
CREATE TRIGGER trg_repair_validate_mechanic_specialty_upd
BEFORE UPDATE ON repair
FOR EACH ROW
BEGIN
    DECLARE vehicle_cat SMALLINT;
    
    -- Solo validar si cambió assigned_mechanic o id_vehicle
    IF (NEW.assigned_mechanic != OLD.assigned_mechanic 
        OR NEW.assigned_mechanic IS NOT NULL AND OLD.assigned_mechanic IS NULL
        OR NEW.id_vehicle != OLD.id_vehicle)
       AND NEW.assigned_mechanic IS NOT NULL THEN
        
        SELECT v.id_category INTO vehicle_cat
        FROM vehicle v
        WHERE v.id_vehicle = NEW.id_vehicle;
        
        IF NOT EXISTS (
            SELECT 1 FROM mechanic_specialty
            WHERE id_mechanic = NEW.assigned_mechanic
              AND id_category = vehicle_cat
        ) THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Mechanic lacks required specialty for vehicle category';
        END IF;
    END IF;
END//
DELIMITER ;


-- SEED
-- ============================================================
-- Trade&Tune - Seed data (verosímil / sintético)
-- Compatible con db_trade_tune.sql
-- Ejecuta DESPUÉS de crear el esquema.
-- ============================================================

-- =========================
-- 1) Concesionarios
-- =========================
INSERT INTO dealership (name, address, city, province, country) VALUES
    ('Trade & Tune Málaga',  'Av. de Velázquez 284',        'Málaga',  'Málaga',  'España'),
    ('Trade & Tune Sevilla', 'Calle Luis Montoto 120',     'Sevilla', 'Sevilla', 'España');

-- =========================
-- 2) Trabajadores + roles
-- =========================
INSERT INTO worker
(id_dealership, email, password_hash, full_name, phone_number, entry_date, active)
VALUES
    ( 1, 'laura.garcia@trade-tune.es',   '$2b$10$malaga.manager.hash.demo',  'Laura García Ramos',     '+34 600 123 456', '2022-03-01', 1),
    ( 1, 'daniel.ruiz@trade-tune.es',    '$2b$10$malaga.sales1.hash.demo',   'Daniel Ruiz Ortega',     '+34 611 222 333', '2023-01-15', 1),
    ( 1, 'marta.lopez@trade-tune.es',    '$2b$10$malaga.sales2.hash.demo',   'Marta López Navarro',    '+34 612 444 555', '2023-06-12', 1),
    ( 1, 'ivan.moreno@trade-tune.es',    '$2b$10$malaga.mech1.hash.demo',    'Iván Moreno Gil',        '+34 613 666 777', '2021-09-20', 1),
    ( 1, 'paula.suarez@trade-tune.es',   '$2b$10$malaga.mech2.hash.demo',    'Paula Suárez Castro',    '+34 614 888 999', '2024-02-05', 1),
    ( 1, 'carlos.perez@trade-tune.es',   '$2b$10$malaga.head.hash.demo',     'Carlos Pérez Molina',    '+34 615 101 202', '2020-11-10', 1),

    (2, 'ana.martin@trade-tune.es',     '$2b$10$sevilla.manager.hash.demo', 'Ana Martín Jiménez',     '+34 620 303 404', '2022-05-03', 1),
    ( 2, 'javier.romero@trade-tune.es',  '$2b$10$sevilla.sales.hash.demo',   'Javier Romero León',     '+34 621 505 606', '2023-10-01', 1),
    ( 2, 'lucas.vargas@trade-tune.es',   '$2b$10$sevilla.mech1.hash.demo',   'Lucas Vargas Herrera',   '+34 622 707 808', '2021-07-19', 1),
    (2, 'sara.nieto@trade-tune.es',     '$2b$10$sevilla.head.hash.demo',    'Sara Nieto Fuentes',     '+34 623 909 010', '2020-04-08', 1);

INSERT INTO manager (id_worker) VALUES (1),(7);
INSERT INTO sales_employee (id_worker) VALUES (2),(3),(8);
INSERT INTO mechanic (id_worker) VALUES (4),(5),(6),(9),(10);
INSERT INTO head_mechanic (id_worker) VALUES (6),(10);

-- Especialidades (para cumplir triggers de repair)
INSERT INTO mechanic_specialty (id_mechanic, id_category) VALUES
    (4, 1),          -- Iván: coches
    (5, 2),          -- Paula: motos
    (6, 1), (6, 2),  -- Carlos (jefe): coches y motos
    (9, 1),          -- Lucas: coches
    (10,1), (10,3);  -- Sara (jefa): coches y ciclomotores

-- =========================
-- 3) Materiales
-- =========================
INSERT INTO material_type (id_material_type, name) VALUES
    (1,'FLUID'),(2,'FILTER'),(3,'BRAKES'),(4,'ELECTRICAL'),(5,'TIRES'),(6,'ENGINE');

INSERT INTO material (id_material_type, name, price_ref, active) VALUES
    ( 1, 'Aceite motor 5W-30 (1L)',                 9.50,  1),
    ( 2, 'Filtro de aceite',                        12.90, 1),
    (2, 'Filtro de aire',                          18.50, 1),
    (2, 'Filtro de habitáculo (polen)',            16.90, 1),
    ( 1, 'Líquido de frenos DOT 4 (1L)',            8.50,  1),
    ( 3, 'Pastillas freno delanteras (juego)',      65.00, 1),
    ( 3, 'Pastillas freno traseras (juego)',        55.00, 1),
    ( 6, 'Kit de embrague (conjunto)',              195.00,1),
    ( 6, 'Kit correa distribución (conjunto)',      210.00,1),
    (6, 'Bujías (juego 4 uds)',                    45.00, 1),
    (4, 'Batería 12V 60Ah',                        115.00,1),
    (5, 'Neumático 205/55 R16',                    89.00, 1),
    (6, 'Kit transmisión moto (cadena + piñones)', 145.00,1),
    (1, 'Refrigerante orgánico (1L)',              7.00,  1);

-- =========================
-- 4) Vehículos + imágenes
-- =========================
INSERT INTO vehicle
(id_dealership, id_category, id_vehicle_status, vin, license_plate, brand, model, year, km, fuel, base_price, arrival_date)
VALUES
    ( 1, 1, 3, 'VSSZZZ5FZJR000101', '5483LKG', 'SEAT',       'León 1.6 TDI',            2018,  98000, 'Diesel', 13900.00, '2025-11-20'),
    ( 1, 1, 2, 'WVWZZZAUZLW000202', '2197KPM', 'Volkswagen', 'Golf 1.5 TSI',            2020,  62000, 'Petrol', 18900.00, '2025-10-05'),
    ( 1, 1, 1, 'JTDBR32E0M0000303', '7731MJD', 'Toyota',     'Corolla 1.8 Hybrid',      2021,  41000, 'Hybrid', 22900.00, '2025-12-10'),
    ( 1, 1, 2, 'WBA8A31070K000404', '9016LZY', 'BMW',        '320d',                     2017, 115000, 'Diesel', 17900.00, '2025-09-15'),
    (1, 2, 3, 'JYARM061000050505', '3184JHG', 'Yamaha',     'MT-07',                    2022,  12000, 'Petrol',  6990.00, '2026-01-05'),
    (1, 1, 1, 'VF1RJA00465100606', '4328MPR', 'Renault',    'Clio TCe 90',              2019,  54000, 'Petrol', 12900.00, '2025-11-01'),
    ( 1, 3, 1, 'ZAPC2500000000707', '8061HLM', 'Piaggio',    'Zip 50',                   2020,   8000, 'Petrol',  1790.00, '2025-12-22'),

    ( 2, 1, 3, 'VF3L3HNS0KS000808', '1049LBC', 'Peugeot',    '308 1.2 PureTech',         2019,  73000, 'Petrol', 14900.00, '2025-10-28'),
    ( 2, 1, 1, '5YJ3E7EB0MF000909', '6675MHL', 'Tesla',      'Model 3',                  2021,  35000, 'Electric',29900.00, '2025-12-01'),
    (2, 2, 2, 'JKAEX4000LDA00110', '9042KRT', 'Kawasaki',   'Ninja 400',                2020,  18000, 'Petrol',  5390.00, '2025-11-18');

INSERT INTO vehicle_image (id_vehicle, url) VALUES
    ( 1, 'assets/vehicles/seat_leon_2018_1.jpg'),
    ( 1, 'assets/vehicles/seat_leon_2018_2.jpg'),
    ( 2, 'assets/vehicles/vw_golf_2020_1.jpg'),
    (  2, 'assets/vehicles/vw_golf_2020_2.jpg'),
    (  3, 'assets/vehicles/toyota_corolla_2021_1.jpg'),
    (  3, 'assets/vehicles/toyota_corolla_2021_2.jpg'),
    ( 4, 'assets/vehicles/bmw_320d_2017_1.jpg'),
    (  4, 'assets/vehicles/bmw_320d_2017_2.jpg'),
    ( 5, 'assets/vehicles/yamaha_mt07_2022_1.jpg'),
    (5, 'assets/vehicles/yamaha_mt07_2022_2.jpg'),
    ( 6, 'assets/vehicles/renault_clio_2019_1.jpg'),
    (6, 'assets/vehicles/renault_clio_2019_2.jpg'),
    (8, 'assets/vehicles/peugeot_308_2019_1.jpg'),
    (8, 'assets/vehicles/peugeot_308_2019_2.jpg'),
    (9, 'assets/vehicles/tesla_model3_2021_1.jpg'),
    (9, 'assets/vehicles/tesla_model3_2021_2.jpg'),
    (10, 'assets/vehicles/kawasaki_ninja400_2020_1.jpg'),
    (10, 'assets/vehicles/kawasaki_ninja400_2020_2.jpg');

-- =========================
-- 5) Clientes + interés
-- =========================
INSERT INTO client
(dni_nif, full_name, email, phone_number, birthdate, address)
VALUES
    ( '12345678Z', 'Sergio Martín Aguilar',      'sergio.martin@gmail.com',     '+34 640 111 222', '1992-04-17', 'C/ Héroe de Sostoa 112, Málaga'),
    (  '23456789D', 'María Sánchez Moreno',       'maria.sanchez@gmail.com',     '+34 640 222 333', '1989-09-02', 'C/ Larios 14, Málaga'),
    (  '34567890V', 'David López Castillo',       'david.lopez@gmail.com',       '+34 640 333 444', '1996-01-25', 'Av. Juan XXIII 45, Málaga'),
    (  '45678901G', 'Lucía Fernández Ruiz',       'lucia.fernandez@gmail.com',   '+34 640 444 555', '1994-12-11', 'C/ Pacífico 67, Málaga'),
    (  '56789012B', 'Raúl Ortega Torres',         'raul.ortega@gmail.com',       '+34 640 555 666', '1987-06-30', 'C/ Granada 8, Málaga'),
    ( '67890123B', 'Elena Navarro Díaz',         'elena.navarro@gmail.com',     '+34 640 666 777', '1990-03-08', 'C/ San Jacinto 20, Sevilla'),
    (  '78901234X', 'Adrián Molina Romero',       'adrian.molina@gmail.com',     '+34 640 777 888', '1998-10-19', 'Av. Andalucía 210, Málaga'),
    ( '89012345E', 'Carmen Jiménez Herrera',     'carmen.jimenez@gmail.com',    '+34 640 888 999', '1985-02-14', 'C/ Carretería 29, Málaga'),
    (  '90123456A', 'Pablo Vargas Núñez',         'pablo.vargas@gmail.com',      '+34 641 000 111', '1991-07-07', 'C/ Mármoles 5, Málaga'),
    ( '11223344B', 'Noelia Gil Rojas',           'noelia.gil@gmail.com',        '+34 641 111 222', '1999-05-21', 'C/ Alcazabilla 3, Málaga'),
    ( '22334455Y', 'Héctor León Campos',         'hector.leon@gmail.com',       '+34 641 222 333', '1993-08-09', 'C/ Nervión 12, Sevilla'),
    ('33445566R', 'Isabel Fuentes Blanco',      'isabel.fuentes@gmail.com',    '+34 641 333 444', '1988-11-27', 'Av. de la Palmera 38, Sevilla');

INSERT INTO client_vehicle_interest
(id_interest, id_client, id_vehicle, interest_date, approx_budget, notes)
VALUES
    (1,  1,  2, '2025-12-16', 18500.00, 'Busca financiación a 48 meses.'),
    (2,  2,  4, '2025-09-25', 17000.00, 'Prioriza mantenimiento al día y revisión de historial.'),
    (3,  3,  3, '2026-01-08', 21000.00, 'Interesado en híbrido para ciudad; pregunta por garantía.'),
    (4,  4,  6, '2026-01-30', 12500.00, 'Pago con tarjeta si se incluye cambio de neumáticos.'),
    (5,  5, 10, '2025-12-03',  5200.00, 'Compra rápida; solicita entrega antes de Navidad.'),
    (6,  6,  9, '2026-01-18', 30000.00, 'Valora tasación de su coche actual.'),
    (7,  7,  1, '2026-01-23', NULL,     'Quiere ver el estado del embrague y prueba en carretera.'),
    (8, 10,  3, '2026-01-22', 22000.00, 'Pregunta por seguro y consumo real.');

-- =========================
-- 6) Ofertas + ventas
-- =========================
INSERT INTO proposal
(id_client, id_vehicle, id_sales_employee, id_payment_method, id_proposal_status,
 proposal_date, validity_date, base_price_snapshot, discount_amount, final_price, details)
VALUES
    (1,  2, 2, 4, 2, '2025-12-18', '2026-01-08', 18900.00,  900.00, 18000.00, 'Incluye cambio de aceite antes de entrega.'),
    ( 2,  4, 3, 3, 2, '2025-10-01', '2025-10-21', 17900.00, 1400.00, 16500.00, 'Transferencia y entrega con ITV en vigor.'),
    (3,  3, 2, 2, 3, '2026-01-10', '2026-01-25', 22900.00, 2500.00, 20400.00, 'Cliente solicita descuento extra; no aceptado.'),
    (4,  6, 3, 2, 1, '2026-02-01', '2026-02-20', 12900.00,  500.00, 12400.00, 'Oferta activa pendiente de visita.'),
    (6,  9, 8, 3, 1, '2026-01-20', '2026-02-15', 29900.00,    0.00, 29900.00, 'Oferta activa: incluye gestión de transferencia.'),
    (5, 10, 8, 2, 2, '2025-12-05', '2025-12-25',  5390.00,  200.00,  5190.00, 'Entrega con revisión general y limpieza.');

INSERT INTO sale
(id_proposal, id_vehicle, sale_ts, final_price_snapshot)
VALUES
    ( 1,  2, '2025-12-22 12:15:00', 18000.00),
    ( 2,  4, '2025-10-05 10:30:00', 16500.00),
    (6, 10, '2025-12-10 18:40:00',  5190.00);

-- =========================
-- 7) Reparaciones + materiales usados
-- =========================
INSERT INTO repair
(id_dealership, id_vehicle, id_client, created_by_head_mechanic, assigned_mechanic,
 id_repair_status, creation_ts, start_ts, end_ts, estimated_time_hours, estimated_cost, final_cost,
 work_type, notes)
VALUES
    (1,  1, NULL, 6, 4, 3, '2026-01-25 09:30:00', '2026-01-26 10:00:00', NULL, 6.50, 420.00, NULL,
     'Cambio de embrague', 'Se detecta patinaje en 3ª y 4ª. Pendiente de prueba final.'),
    (1,  5, 5,    6, 5, 2, '2026-01-28 11:10:00', NULL, NULL, 1.50,  95.00, NULL,
     'Revisión 10.000 km + frenos traseros', 'Cliente solicita revisión completa; confirmar desgaste cadena.'),
    ( 1,  6, 8,    6, 4, 4, '2025-11-10 08:45:00', '2025-11-10 10:00:00', '2025-11-10 15:30:00', 2.50, 160.00, 155.00,
     'Cambio de aceite y filtros', 'Reparación finalizada. Avisar al cliente para recogida.'),
    ( 2,  8, NULL, 10,9, 2, '2026-01-15 16:20:00', NULL, NULL, 5.00, 380.00, NULL,
     'Sustitución correa distribución', 'Programar inicio cuando llegue kit de distribución.'),
    ( 1,  7, 9,    6, NULL, 1, '2026-02-02 09:00:00', NULL, NULL, 0.75, 50.00, NULL,
     'Diagnóstico eléctrico (arranque)', 'No arranca en frío; revisar batería y relé de arranque.');

INSERT INTO repair_material (id_repair, id_material, quantity, unit_price_applied) VALUES
-- Repair 1 (Seat León)
(1, 8, 1, 195.00),
(1, 1, 4,   9.50),
(1, 2, 1,  12.90),

-- Repair 2 (MT-07)
(2, 7, 1,  55.00),
(2, 5, 1,   8.50),

-- Repair 3 (Clio)
(3, 1, 4,   9.50),
(3, 2, 1,  12.90),
(3, 3, 1,  18.50),
(3, 4, 1,  16.90),

-- Repair 4 (308)
(4, 9, 1, 210.00),
(4,14, 2,   7.00),

-- Repair 5 (Zip 50)
(5,11, 1, 115.00);
