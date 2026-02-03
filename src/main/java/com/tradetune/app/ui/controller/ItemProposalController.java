package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import com.tradetune.app.domain.model.Proposal; // Descomentar cuando exista

public class ItemProposalController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Label lblProposalId;
    @FXML private Label lblClientName;
    @FXML private Label lblVehicleInfo;
    @FXML private Label lblPrice;
    @FXML private Label lblDate;

    @FXML private Button btnViewDetails;
    @FXML private Button btnConfirmSale;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configuración inicial (ej. tooltips en botones si hiciera falta).
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setData(Proposal proposal)'
    // 1. Rellenar lblProposalId con el ID (ej: "Propuesta #" + id).
    // 2. Rellenar lblClientName con el nombre del cliente asociado.
    // 3. Rellenar lblVehicleInfo con la marca y modelo del coche.
    // 4. Rellenar lblPrice con el precio formateado.
    // 5. Rellenar lblDate con la fecha de caducidad.
    // 6. Lógica visual extra: Si la propuesta está caducada, cambiar estilo de la fecha a rojo.

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnViewDetails(Runnable action)'
    // Define la acción al pulsar "Ver Detalles".

    // TODO: Crear método 'setOnConfirmSale(Runnable action)'
    // Define la acción al pulsar "Confirmar Venta".
}