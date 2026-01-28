package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import com.tradetune.app.domain.model.Sale; // Descomentar cuando exista

public class ItemSoldVehicleController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Label lblModel;
    @FXML private Label lblClientName;
    @FXML private Label lblSaleDate;
    @FXML private Label lblPrice;
    @FXML private Button btnViewDetails;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configuración inicial si fuera necesaria.
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setSaleData(Sale sale)'
    // Este método recibirá el objeto de venta (que debe contener vehículo y cliente).
    // 1. Rellenar lblModel con sale.getVehicle().getModel().
    // 2. Rellenar lblClientName con "Cliente: " + sale.getClient().getFullName().
    // 3. Rellenar lblSaleDate con "Fecha de venta: " + sale.getSaleDate().toString().
    // 4. Rellenar lblPrice con el precio final de venta sale.getFinalPrice().

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnViewDetails(Runnable action)'
    // Permite al controlador padre definir qué pasa cuando se pulsa "Ver Detalles" (ej: abrir ficha de venta).
    // btnViewDetails.setOnAction(event -> action.run());
}