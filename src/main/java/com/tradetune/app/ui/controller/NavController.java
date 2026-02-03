package com.tradetune.app.ui.controller;

import com.tradetune.app.ui.navigation.NavSection;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class NavController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private ToggleGroup navGroup;

    // SALES
    @FXML
    private ToggleButton btnVehicles;
    @FXML
    private ToggleButton btnClients;
    @FXML
    private ToggleButton btnOffers;
    @FXML
    private ToggleButton btnSold;

    // MECHANIC
    @FXML
    private ToggleButton btnMyJobs;
    @FXML
    private ToggleButton btnFinished;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // Associate each ToggleButton with its NavSection using UserData
        btnVehicles.setUserData(NavSection.VEHICLES);
        btnClients.setUserData(NavSection.CLIENTS);
        btnOffers.setUserData(NavSection.PROPOSALS);
        btnSold.setUserData(NavSection.SOLD);
        btnMyJobs.setUserData(NavSection.MY_JOBS);
        btnFinished.setUserData(NavSection.FINISHED);
    }

    // -------------------------------------------------------------------------
    // PUBLIC GETTERS
    // -------------------------------------------------------------------------

    // Returns the property of "who is selected"
    public ReadOnlyObjectProperty<Toggle> getSelectedToggleProperty() {
        return navGroup.selectedToggleProperty();
    }

    // Getters for comparison (to know if the selected one is btnVehicles, etc.)
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
    // METHOD TO GET SELECTED SECTION
    // -------------------------------------------------------------------------

    public NavSection getSelectedSection() {
        Toggle selected = navGroup.getSelectedToggle();
        return selected != null ? (NavSection) selected.getUserData() : null;
    }
}