package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ItemClientController {

    @FXML private ImageView imgAvatar;
    @FXML private Label lblName;
    @FXML private Label lblDni;
    @FXML private Label lblPhone;
    @FXML private Label lblEmail;
    @FXML private Label lblStatus; // Badge "Interesado"
    @FXML private Button btnViewProfile;

    // --- MÉTODO SET DATA CON ENTIDAD REAL ---
    public void setData(Client client, boolean isInterested) {
        if (client == null) return;

        // 1. Datos personales
        lblName.setText(client.getFullName());
        lblDni.setText("DNI: " + client.getDniNif());
        lblPhone.setText("Tel: " + (client.getPhoneNumber() != null ? client.getPhoneNumber() : "-"));
        lblEmail.setText(client.getEmail());

        // 2. Lógica Visual del Badge (Amarillo)
        if (isInterested) {
            lblStatus.setVisible(true);
            lblStatus.setManaged(true);
        } else {
            lblStatus.setVisible(false);
            lblStatus.setManaged(false);
        }

        // Acción
        btnViewProfile.setOnAction(e -> System.out.println("Ver cliente ID: " + client.getId()));
    }
}