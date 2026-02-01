package com.tradetune.app.ui.controller;

import com.tradetune.app.ui.navigation.NavSection;
import javafx.fxml.FXML;

import java.util.HashMap;
import java.util.Map;

public class SalesLayoutController {

    @FXML private HeaderController headerController;         // Se inyecta desde fx:id="header"
    @FXML private NavController navController;
    @FXML private SectionContentController contentController; // Se inyecta desde fx:id="content"

    private Map<NavSection, Runnable> viewLoaders;


    @FXML
    public void initialize() {
        initializeViewLoaders();
        // Escuchamos al GRUPO entero de ToggleButtons
        navController.getSelectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null) return;

            NavSection section = navController.getSelectedSection();
            viewLoaders.get(section).run();
        });

        // Seleccionar uno por defecto al arrancar (esto dispara el listener automáticamente)
        loadDefaultView();
    }

    private void initializeViewLoaders() {
        viewLoaders = new HashMap<>();
        viewLoaders.put(NavSection.VEHICLES, contentController::loadVehiclesView);
        viewLoaders.put(NavSection.CLIENTS, contentController::loadClientsView);
        viewLoaders.put(NavSection.OFFERS, contentController::loadProposalsView);
        viewLoaders.put(NavSection.SOLD, contentController::loadSoldView);
    }

    private void loadDefaultView() {
        navController.getBtnVehicles().setSelected(true);
        contentController.loadVehiclesView();
    }


}

