package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;

public class SalesLayoutController {

    @FXML private HeaderController headerController;          // se inyecta desde fx:id="header"
    @FXML private NavController navController;                // si Nav.fxml tiene controller
    @FXML private SectionContentController contentController; // se inyecta desde fx:id="content"

    @FXML
    private void initialize() {
        // Header dinámico
        // Si quieres ocultar el botón de acción, ya lo tienes visible=false en el FXML.
        // Aquí puedes rellenar items (ver punto 3).
    }
}