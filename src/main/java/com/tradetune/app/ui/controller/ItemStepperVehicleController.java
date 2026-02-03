package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Vehicle;

public class ItemStepperVehicleController {

    @FXML
    private ImageView imgVehicle;
    @FXML
    private Label lblModel;
    @FXML
    private Label lblPrice;
    @FXML
    private Button btnSelect;

    @FXML
    public void initialize() {
        // TODO: Configure image placeholder if necessary.
    }

    // -------------------------------------------------------------------------
    // SECTION 1: POPULATE DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'setData(Vehicle vehicle)'
    // 1. Fill lblModel with Brand and Model.
    // 2. Fill lblPrice.
    // 3. Load image in imgVehicle.

    // -------------------------------------------------------------------------
    // SECTION 2: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnSelect(Runnable action)'
    // Defines what happens when "Select" is pressed (normally advances to next
    // stepper step).
    // btnSelect.setOnAction(event -> action.run());
}