package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Proposal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemProposalController {

    @FXML private Label lblProposalId;
    @FXML private Label lblClientName;
    @FXML private Label lblVehicleInfo;
    @FXML private Label lblPrice;
    @FXML private Label lblDate;
    @FXML private Button btnViewDetails;
    @FXML private Button btnConfirmSale;

    // --- MÉTODO SET DATA CON ENTIDAD REAL ---
    public void setData(Proposal proposal) {
        if (proposal == null) return;

        // 1. ID formateado (ej. PROPUESTA #005)
        lblProposalId.setText(String.format("PROPUESTA #%03d", proposal.getId()));

        // 2. Cliente (Navegación Offer -> Client)
        if (proposal.getIdClient() != null) {
            lblClientName.setText("Cliente: " + proposal.getIdClient().getFullName());
        }

        // 3. Vehículo (Navegación Offer -> Vehicle)
        if (proposal.getIdVehicle() != null) {
            lblVehicleInfo.setText("Vehículo: " + proposal.getIdVehicle().getBrand() + " " + proposal.getIdVehicle().getModel());
        }

        // 4. Precio Final
        lblPrice.setText(String.format("%,.0f €", proposal.getFinalPrice()));

        // 5. Fecha Validez
        lblDate.setText("Válida hasta: " + proposal.getValidityDate().toString());

        // Acciones
        btnViewDetails.setOnAction(e -> System.out.println("Detalle oferta ID: " + proposal.getId()));
        btnConfirmSale.setOnAction(e -> System.out.println("Vender oferta ID: " + proposal.getId()));
    }
}