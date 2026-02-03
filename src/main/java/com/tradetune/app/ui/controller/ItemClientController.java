package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Client; // Uncomment when available

/**
 * Controller for displaying a client item in lists.
 * Shows client information including name, contact details, and status.
 */
public class ItemClientController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private ImageView imgAvatar;
    @FXML
    private Label lblName;
    @FXML
    private Label lblDni;
    @FXML
    private Label lblPhone;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblStatus; // The "Interested" badge
    @FXML
    private Button btnViewProfile;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Load a default image/avatar if necessary.
    }

    // -------------------------------------------------------------------------
    // SECTION 1: POPULATE DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'setClientData(Client client, boolean isInterested)'
    // 1. Fill lblName with first and last name.
    // 2. Fill lblDni with the DNI/ID.
    // 3. Fill lblPhone with phone number.
    // 4. Fill lblEmail with email.
    // 5. Call internal method to manage status visibility (see next TODO).

    // TODO: Create private method 'updateStatusVisibility(boolean isInterested)'
    // Logic for the 'lblStatus' badge:
    // - If isInterested is TRUE: setVisible(true) and setManaged(true).
    // - If isInterested is FALSE: setVisible(false) and setManaged(false) to avoid
    // space usage.

    // -------------------------------------------------------------------------
    // SECTION 2: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnViewProfile(Runnable action)'
    // Allows defining what happens when "View Profile" is pressed.
    // btnViewProfile.setOnAction(event -> action.run());
}