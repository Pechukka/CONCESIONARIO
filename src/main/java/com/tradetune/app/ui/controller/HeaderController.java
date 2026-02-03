package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

/**
 * Controller for the application header.
 * Displays user information and provides logout functionality.
 */
public class HeaderController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private Button btnLogOut;
    @FXML
    private Label email; // Label to show user email
    @FXML
    private Label section; // Label for section title (e.g: "SALES")

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Basic initialization if necessary (e.g. clear default texts).
    }

    // -------------------------------------------------------------------------
    // SECTION 1: DATA INJECTION (PUBLIC API)
    // -------------------------------------------------------------------------

    // TODO: Create method 'setSection(String sectionText)'
    // Receives the current section name and updates the 'section' label.

    // TODO: Create method 'setEmail(String emailText)'
    // Receives the authenticated user email and updates the 'email' label.

    // TODO: Create method 'updateHeaderData(String sectionText, String emailText)'
    // Utility method to update both fields at once.
    // Internally calls setSection() and setEmail().

    // -------------------------------------------------------------------------
    // SECTION 2: VISUAL STATE MANAGEMENT
    // -------------------------------------------------------------------------

    // TODO: Create method 'clearHeader()'
    // Clears visible data (sets labels empty) when logging out or changing context.

    // TODO: Create method 'disableLogoutButton(boolean disable)'
    // Allows blocking the logout button if a critical operation is in progress.

    // TODO: Create method 'applyHeaderState()'
    // Applies final visual adjustments or component refresh if necessary after
    // receiving data.

    // -------------------------------------------------------------------------
    // SECTION 3: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'onLogoutAction(ActionEvent event)'
    // Handles click on 'btnLogOut'.
    // 1. Confirm intention (optional).
    // 2. Call logout service.
    // 3. Navigate back to Login screen.
}