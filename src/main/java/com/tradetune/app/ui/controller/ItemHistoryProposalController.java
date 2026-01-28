package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
// import com.tradetune.app.domain.model.Proposal; // Descomentar cuando exista

public class ItemHistoryProposalController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private HBox rootBox; // Contenedor principal para cambiar el color de fondo
    @FXML private Label lblTitle;
    @FXML private Label lblDetails;
    @FXML private Label lblStatus;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configuración inicial si fuera necesaria.
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setData(Proposal proposal)'
    // 1. Rellenar lblTitle con el ID y el nombre del vehículo.
    // 2. Rellenar lblDetails con la fecha y el precio formateado.
    // 3. Limpiar las clases de estilo dinámicas anteriores de 'rootBox' y 'lblStatus'.
    // 4. Evaluar el estado de la propuesta (proposal.getStatus()):
    //    - Si es "ACTIVA":
    //      * Añadir clase 'history-row-active' a rootBox.
    //      * Añadir clase 'history-badge-active' a lblStatus.
    //      * Setear texto "ACTIVA".
    //    - Si es "VENDIDA":
    //      * Añadir clase 'history-row-sold' a rootBox.
    //      * Añadir clase 'history-badge-sold' a lblStatus.
    //      * Setear texto "VENDIDA".
}