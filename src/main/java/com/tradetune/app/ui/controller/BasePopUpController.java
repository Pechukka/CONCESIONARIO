package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
    private StackPane overlay;
    private Parent modalRoot;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------

    @FXML
    public void initialize() {
        btnCross.setOnAction(event -> closeModal());
    }

    // -------------------------------------------------------------------------
    // SECTION 1: HEADER CONFIGURATION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setTitle(String title)'
    // Dynamically assigns the modal title text (lblTitle).


// BasePopUpController.java

    public <T> T setContent(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();
            paneModal.getChildren().setAll(view);
            return loader.getController();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar: " + fxmlPath, e);
        }
    }
    // -------------------------------------------------------------------------
    // SECTION 3: EVENTS AND CLOSING
    // -------------------------------------------------------------------------

    private void closeModal() {
        StackPane rootStack = (StackPane) paneModal.getScene().getRoot();
        rootStack.getChildren().removeAll(overlay, modalRoot);
    }


    public void setOverlay(StackPane overlay) {
        this.overlay = overlay;
    }

    public void setModalRoot(Parent modalRoot) {
        this.modalRoot = modalRoot;
    }

    @FXML
    private void onCloseAction() {
        closeModal();
    }
    // -------------------------------------------------------------------------
    // SECTION 4: UTILITIES (OPTIONAL)
    // -------------------------------------------------------------------------

    // TODO: Create method 'clearModalContent()'
    // Removes the current content from StackPane paneModal.

}