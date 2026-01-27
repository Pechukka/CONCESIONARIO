package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Vehicle; // Descomentar cuando exista

public class ItemVehicleController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private ImageView imgVehicle;
    @FXML private Label lblModel;
    @FXML private Label lblTechnicalInfo; // Para: "Diesel • 120.000 km • 2018"
    @FXML private Label lblLocation;
    @FXML private Label lblStockDays;
    @FXML private Label lblPrice;
    @FXML private Button btnViewDetails;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configuración inicial si fuera necesaria (ej. placeholder de imagen).
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setData(Vehicle vehicle)'
    // Este método recibirá el objeto 'Vehicle' de la base de datos y rellenará los labels:
    // 1. lblModel.setText(vehicle.getBrand() + " " + vehicle.getModel());
    // 2. lblPrice.setText(vehicle.getPrice() + " €");
    // 3. Construir String para lblTechnicalInfo (fuel, km, year).
    // 4. Calcular días en stock (Fecha actual - Fecha llegada) para lblStockDays.
    // 5. Cargar la imagen en imgVehicle (usar una por defecto si es null).

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnViewDetails(Runnable action)'
    // Permite al controlador padre definir qué pasa cuando se pulsa "Ver Detalles".
    // btnViewDetails.setOnAction(event -> action.run());
}