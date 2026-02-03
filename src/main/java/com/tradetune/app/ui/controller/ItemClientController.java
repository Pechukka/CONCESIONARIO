package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Client; // Descomentar cuando exista

public class ItemClientController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private ImageView imgAvatar;
    @FXML private Label lblName;
    @FXML private Label lblDni;
    @FXML private Label lblPhone;
    @FXML private Label lblEmail;
    @FXML private Label lblStatus; // La etiqueta "Interesado"
    @FXML private Button btnViewProfile;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Cargar una imagen/avatar por defecto si fuera necesario.
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setClientData(Client client, boolean isInterested)'
    // 1. Rellenar lblName con nombre y apellidos.
    // 2. Rellenar lblDni con el DNI.
    // 3. Rellenar lblPhone con el teléfono.
    // 4. Rellenar lblEmail con el correo.
    // 5. Llamar al método interno para gestionar la visibilidad del estado (ver siguiente TODO).

    // TODO: Crear método privado 'updateStatusVisibility(boolean isInterested)'
    // Lógica para el badge 'lblStatus':
    // - Si isInterested es TRUE: setVisible(true) y setManaged(true).
    // - Si isInterested es FALSE: setVisible(false) y setManaged(false) para que no ocupe espacio.

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnViewProfile(Runnable action)'
    // Permite definir desde fuera qué ocurre al pulsar "Ver Ficha".
    // btnViewProfile.setOnAction(event -> action.run());
}