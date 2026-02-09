package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Base controller for modal popup windows.
 * Provides common functionality for displaying and managing modal dialogs.
 */
public class BasePopUpController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private Label lblTitle;
    @FXML
    private Button btnCross;
    @FXML
    private StackPane paneModal;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------

    @FXML
    public void initialize() {
        // TODO: Configure initial modal state (listeners, accessibility, etc.).
    }

    // -------------------------------------------------------------------------
    // SECTION 1: HEADER CONFIGURATION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setTitle(String title)'
    // Dynamically assigns the modal title text (lblTitle).


    public void setContent(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();
            paneModal.getChildren().setAll(view);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar: " + fxmlPath, e);
        }
    }

    // -------------------------------------------------------------------------
    // SECTION 3: EVENTS AND CLOSING
    // -------------------------------------------------------------------------

    // TODO: Create method 'onCloseAction()'
    // Handles modal closing when X button is clicked.
    // Must close the Stage or notify the parent controller.

    // TODO: Create method 'closeModal()'
    // Closes the modal in a centralized way (reusable by other events).

    // -------------------------------------------------------------------------
    // SECTION 4: UTILITIES (OPTIONAL)
    // -------------------------------------------------------------------------

    // TODO: Create method 'clearModalContent()'
    // Removes the current content from StackPane paneModal.

}