package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import com.tradetune.app.domain.model.Proposal; // Uncomment when available

/**
 * Controller for displaying a proposal item.
 * Shows proposal information including client, vehicle, price, and expiration
 * date.
 */
public class ItemProposalController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private Label lblProposalId;
    @FXML
    private Label lblClientName;
    @FXML
    private Label lblVehicleInfo;
    @FXML
    private Label lblPrice;
    @FXML
    private Label lblDate;

    @FXML
    private Button btnViewDetails;
    @FXML
    private Button btnConfirmSale;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Initial configuration (e.g. tooltips on buttons if needed).
    }

    // -------------------------------------------------------------------------
    // SECTION 1: POPULATE DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'setData(Proposal proposal)'
    // 1. Fill lblProposalId with ID (e.g: "Proposal #" + id).
    // 2. Fill lblClientName with associated client name.
    // 3. Fill lblVehicleInfo with car brand and model.
    // 4. Fill lblPrice with formatted price.
    // 5. Fill lblDate with expiration date.
    // 6. Extra visual logic: If proposal is expired, change date style to red.

    // -------------------------------------------------------------------------
    // SECTION 2: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnViewDetails(Runnable action)'
    // Defines the action when "View Details" is pressed.

    // TODO: Create method 'setOnConfirmSale(Runnable action)'
    // Defines the action when "Confirm Sale" is pressed.
}