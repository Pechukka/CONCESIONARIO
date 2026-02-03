package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Offer;
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
    public void setData(Offer offer) {
        if (offer == null) return;

        // 1. ID formateado (ej. PROPUESTA #005)
        lblProposalId.setText(String.format("PROPUESTA #%03d", offer.getId()));

        // 2. Cliente (Navegación Offer -> Client)
        if (offer.getIdClient() != null) {
            lblClientName.setText("Cliente: " + offer.getIdClient().getFullName());
        }

        // 3. Vehículo (Navegación Offer -> Vehicle)
        if (offer.getIdVehicle() != null) {
            lblVehicleInfo.setText("Vehículo: " + offer.getIdVehicle().getBrand() + " " + offer.getIdVehicle().getModel());
        }

        // 4. Precio Final
        lblPrice.setText(String.format("%,.0f €", offer.getFinalPrice()));

        // 5. Fecha Validez
        lblDate.setText("Válida hasta: " + offer.getValidityDate().toString());

        // Acciones
        btnViewDetails.setOnAction(e -> System.out.println("Detalle oferta ID: " + offer.getId()));
        btnConfirmSale.setOnAction(e -> System.out.println("Vender oferta ID: " + offer.getId()));
    }
}