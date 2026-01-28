package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Vehicle;

public class ItemStepperVehicleController {

    @FXML private ImageView imgVehicle;
    @FXML private Label lblModel;
    @FXML private Label lblPrice;
    @FXML private Button btnSelect;

    @FXML
    public void initialize() {
        // TODO: Configurar placeholder de imagen si es necesario.
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setData(Vehicle vehicle)'
    // 1. Rellenar lblModel con Marca y Modelo.
    // 2. Rellenar lblPrice.
    // 3. Cargar imagen en imgVehicle.

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnSelect(Runnable action)'
    // Define qué pasa al pulsar "Seleccionar" (normalmente avanza al siguiente paso del stepper).
    // btnSelect.setOnAction(event -> action.run());
}