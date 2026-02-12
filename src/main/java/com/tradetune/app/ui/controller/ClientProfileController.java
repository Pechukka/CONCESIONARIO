package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ClientProfileController {

// -------------------------------------------------------------------------
// FXML BINDINGS
// -------------------------------------------------------------------------

    // HEADER
    @FXML
    private ImageView imgAvatar;
    @FXML private Label lblAvatarIcon;
    @FXML private Label lblClientName;
    @FXML private Label lblStatus;

    // PERSONAL DETAILS
    @FXML private TextField txtDni;
    @FXML private TextField txtBirthdate;

    // CONTACT
    @FXML private TextField txtPhone;
    @FXML private TextField txtEmail;

    // DYNAMIC LISTS
    @FXML private VBox interestedVehiclesContainer;
    @FXML private VBox proposalHistoryContainer;

    // FOOTER
    @FXML private Button btnClose;

    @FXML
    public void initialize() {
        // TODO: Set default avatar (fallback icon visible, image hidden).

        // TODO: btnClose action (close modal / navigate back / parent decides).
    }

// TODO: Create method 'setData(...)' to populate header + fields + dynamic lists.
// TODO: If there is no avatar image, keep fallback icon.
// TODO: Fill interestedVehiclesContainer and proposalHistoryContainer with dynamically loaded item nodes.


}
