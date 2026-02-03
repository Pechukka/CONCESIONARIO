package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StepperProposalController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML
    private Label circle1; // The circle with the "1"
    @FXML
    private Label label1; // The text "Vehicle"

    @FXML
    private Label circle2;
    @FXML
    private Label label2;

    @FXML
    private Label circle3;
    @FXML
    private Label label3;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Initialize at step 1 by default (setActiveStep(1)).
    }

    // -------------------------------------------------------------------------
    // STATE LOGIC
    // -------------------------------------------------------------------------

    // TODO: Create method 'setActiveStep(int stepNumber)'
    // This is the only method external classes should call.
    // Logic:
    // 1. Reset all styles to "inactive":
    // - Remove 'stepper-circle-active' class from circle1, circle2, circle3.
    // - Remove 'stepper-label-active' class from label1, label2, label3.
    // 2. Apply "active" style based on the received number:
    // - If stepNumber == 1: Add active classes to circle1 and label1.
    // - If stepNumber == 2: Add active classes to circle2 and label2.
    // - If stepNumber == 3: Add active classes to circle3 and label3.
}