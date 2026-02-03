package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Client;

/**
 * Controller for displaying a client item in stepper selection.
 * Shows client information for selection in proposal workflow.
 */
public class ItemStepperClientController {

    @FXML
    private ImageView imgAvatar;
    @FXML
    private Label lblName;
    @FXML
    private Label lblDni;
    @FXML
    private Label lblEmail;
    @FXML
    private Button btnSelect;

    @FXML
    public void initialize() {
        // TODO: Load default avatar.
    }

    // -------------------------------------------------------------------------
    // SECTION 1: POPULATE DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'setData(Client client)'
    // 1. Fill lblName.
    // 2. Fill lblDni.
    // 3. Fill lblEmail.

    // -------------------------------------------------------------------------
    // SECTION 2: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnSelect(Runnable action)'
    // Defines the action when "Select" is pressed.
}