package com.tradetune.app.ui.controller;

import com.tradetune.app.ui.navigation.NavSection;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

public class SalesLayoutController {

    @FXML
    public StackPane rootStack;
    @FXML
    private HeaderController headerController;
    @FXML
    private NavController navController;
    @FXML
    private SectionContentController contentController;

    private Map<NavSection, Runnable> viewLoaders;

    @FXML
    public void initialize() {
        initializeViewLoaders();
        // Listen to the entire group of ToggleButtons
        navController.getSelectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null)
                return;

            NavSection section = navController.getSelectedSection();
            viewLoaders.get(section).run();
        });

        // Select one by default on startup (this triggers the listener automatically)
        loadDefaultView();
    }

    private void initializeViewLoaders() {
        viewLoaders = new HashMap<>();
        viewLoaders.put(NavSection.VEHICLES, contentController::loadVehiclesView);
        viewLoaders.put(NavSection.CLIENTS, contentController::loadClientsView);
        viewLoaders.put(NavSection.PROPOSALS, contentController::loadProposalsView);
        viewLoaders.put(NavSection.SOLD, contentController::loadSoldView);
    }

    private void loadDefaultView() {
        navController.getBtnVehicles().setSelected(true);
        contentController.loadVehiclesView();
    }

}
