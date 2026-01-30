package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;

public class SalesLayoutController {

    @FXML private HeaderController headerController;         // Se inyecta desde fx:id="header"
    @FXML private NavController navController;
    @FXML private SectionContentController contentController; // Se inyecta desde fx:id="content"

    @FXML
    public void initialize() {
        // Escuchamos al GRUPO entero de ToggleButtons
        navController.getSelectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null) return;  // Por si se deselecciona todo (raro)

            if (newVal == navController.getBtnVehicles()) {
                contentController.loadVehiclesView();
            }
            else if (newVal == navController.getBtnClients()) {
                contentController.loadClientsView();
            }
            else if (newVal == navController.getBtnOffers()) {
                contentController.loadProposalsView();
            }
            else if (newVal == navController.getBtnSold()) {
                contentController.loadSoldView();
            }
        });

        // Seleccionar uno por defecto al arrancar (esto dispara el listener automáticamente)
        navController.getBtnVehicles().setSelected(true);
        contentController.loadVehiclesView();
    }

}

