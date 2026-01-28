package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
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

    // -------------------------------------------------------------------------
    // SECCIÓN 1: MODO (VENTAS / MECÁNICA)
    // -------------------------------------------------------------------------

    // TODO: Método setMode(NavMode mode)
    // - Mostrar / ocultar botones según el modo.
    // - Usar setVisible + setManaged para no dejar huecos.
    // - Deshabilitar botones fuera de contexto.
    // - Forzar selección válida tras el cambio de modo.

    // -------------------------------------------------------------------------
    // SECCIÓN 2: NAVEGACIÓN
    // -------------------------------------------------------------------------

    // TODO: Método setOnNavigate(Consumer<NavItem> action)
    // - Permite al layout principal reaccionar al cambio de sección.

    // TODO: Método setActive(NavItem item)
    // - Marca programáticamente una sección como activa.

    // TODO: Método getActive()
    // - Devuelve la sección actualmente seleccionada.

    // -------------------------------------------------------------------------
    // UTILIDADES INTERNAS
    // -------------------------------------------------------------------------

    // TODO: Método isItemAllowedInMode(NavItem item, NavMode mode)
    // - Valida si un item pertenece al modo actual.

    // TODO: Método selectDefaultForMode(NavMode mode)
    // - VEHICLES para SALES.
    // - MY_JOBS para MECHANIC.
}