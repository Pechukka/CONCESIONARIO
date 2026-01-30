package com.tradetune.app.ui.controller;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class NavController {

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
    // ESTADO / CONTEXTO
    // -------------------------------------------------------------------------

    // TODO: Crear enum NavMode { SALES, MECHANIC }
    // Determina si el usuario está en el área de Ventas o Mecánica.

    // TODO: Crear enum NavItem { VEHICLES, CLIENTS, OFFERS, SOLD, MY_JOBS, FINISHED }
    // Representa cada sección navegable del menú.

    // TODO: Variable currentMode para guardar el modo activo (SALES / MECHANIC).

    // TODO: Mapa NavItem -> ToggleButton para poder operar de forma genérica.

    // TODO: Consumer<NavItem> o similar para notificar navegación al controlador padre.

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Asociar cada ToggleButton con su NavItem (setUserData o Map).
        // TODO: Registrar listener único sobre navGroup.selectedToggleProperty().
        // TODO: Evitar selección de items que no correspondan al modo actual.
        // TODO: Definir selección inicial por defecto según el modo.
    }

    // --- GETTERS PÚBLICOS ---

    // Este método devuelve la propiedad de "quién está seleccionado"
    public ReadOnlyObjectProperty<Toggle> getSelectedToggleProperty() {
        return navGroup.selectedToggleProperty();
    }

    // Getters para comparar (saber si el seleccionado es btnVehicles, etc.)
    public ToggleButton getBtnVehicles() { return btnVehicles; }
    public ToggleButton getBtnClients() { return btnClients; }
    public ToggleButton getBtnOffers() { return btnOffers; }
    public ToggleButton getBtnSold() { return btnSold; }
    public ToggleButton btnMyJobs() { return btnMyJobs; }
    public ToggleButton btnFinished() { return btnFinished; }

}

