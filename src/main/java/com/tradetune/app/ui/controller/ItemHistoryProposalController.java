package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
// import com.tradetune.app.domain.model.Proposal; // Uncomment when available

/**
 * Controller for displaying a proposal in history.
 * Shows proposal summary with dynamic styling based on proposal status.
 */
public class ItemHistoryProposalController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private HBox rootBox; // Main container to change background color
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDetails;
    @FXML
    private Label lblStatus;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Initial configuration if necessary.
    }

    // -------------------------------------------------------------------------
    // SECTION 1: POPULATE DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'setData(Proposal proposal)'
    // 1. Fill lblTitle with ID and vehicle name.
    // 2. Fill lblDetails with date and formatted price.
    // 3. Clear previous dynamic style classes from 'rootBox' and 'lblStatus'.
    // 4. Evaluate proposal status (proposal.getStatus()):
    // - If "ACTIVE":
    // * Add 'history-row-active' class to rootBox.
    // * Add 'history-badge-active' class to lblStatus.
    // * Set text "ACTIVE".
    // - If "SOLD":
    // * Add 'history-row-sold' class to rootBox.
    // * Add 'history-badge-sold' class to lblStatus.
    // * Set text "SOLD".
}