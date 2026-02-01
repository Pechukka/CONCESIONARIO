package com.tradetune.app.ui.controller;

import com.tradetune.app.ui.navigation.NavSection;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class NavController {

    // -------------------------------------------------------------------------
    // ENUMS
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private ToggleGroup navGroup;

    // SALES
    @FXML private ToggleButton btnVehicles;
    @FXML private ToggleButton btnClients;
    @FXML private ToggleButton btnOffers;
    @FXML private ToggleButton btnSold;

    // MECHANIC
    @FXML private ToggleButton btnMyJobs;
    @FXML private ToggleButton btnFinished;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // Asociar cada ToggleButton con su NavSection mediante UserData
        btnVehicles.setUserData(NavSection.VEHICLES);
        btnClients.setUserData(NavSection.CLIENTS);
        btnOffers.setUserData(NavSection.OFFERS);
        btnSold.setUserData(NavSection.SOLD);
        btnMyJobs.setUserData(NavSection.MY_JOBS);
        btnFinished.setUserData(NavSection.FINISHED);
    }

    // -------------------------------------------------------------------------
    // GETTERS PÚBLICOS
    // -------------------------------------------------------------------------

    // Este método devuelve la propiedad de "quién está seleccionado"
    public ReadOnlyObjectProperty<Toggle> getSelectedToggleProperty() {
        return navGroup.selectedToggleProperty();
    }

    // Getters para comparar (saber si el seleccionado es btnVehicles, etc.)
    public ToggleButton getBtnVehicles() {
        return btnVehicles;
    }

    public ToggleButton getBtnClients() {
        return btnClients;
    }

    public ToggleButton getBtnOffers() {
        return btnOffers;
    }

    public ToggleButton getBtnSold() {
        return btnSold;
    }

    public ToggleButton getBtnMyJobs() {
        return btnMyJobs;
    }

    public ToggleButton getBtnFinished() {
        return btnFinished;
    }

    // -------------------------------------------------------------------------
    // MÉTODO PARA OBTENER SECCIÓN SELECCIONADA
    // -------------------------------------------------------------------------

    public NavSection getSelectedSection() {
        Toggle selected = navGroup.getSelectedToggle();
        return selected != null ? (NavSection) selected.getUserData() : null;
    }
}