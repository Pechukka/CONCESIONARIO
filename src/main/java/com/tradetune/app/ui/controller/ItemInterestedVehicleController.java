package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
// import com.tradetune.app.domain.model.Vehicle; // Uncomment when available

/**
 * Controller for displaying an interested vehicle item.
 * Shows vehicle information with interest date for client interested in
 * vehicles.
 */
public class ItemInterestedVehicleController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private HBox rootBox;

    @FXML
    private Label lblVehicle; // "SEAT IBIZA 1.0 TSI"
    @FXML
    private Label lblDate; // "Interest date: 20/11/2025"
    @FXML
    private Button btnViewVehicle; // "View vehicle"

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: If button should be disabled by default until data is set, do it here.
        // TODO: If you want to adjust initial visual behavior (managed/visible) of any
        // node, do it here.
    }

    // -------------------------------------------------------------------------
    // SECTION 1: POPULATE DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'setInterestedVehicleData(Long vehicleId, String
    // vehicleTitle, String interestDateText)'
    // 1. Save vehicleId internally (to know what to open when pressed).
    // 2. Fill lblVehicle with vehicleTitle (empty if null).
    // 3. Fill lblDate with interestDateText (empty if null).
    // 4. (Optional) Call internal method to enable/disable button based on
    // vehicleId.

    // TODO: Create private method 'updateViewButtonState()'
    // Recommended logic:
    // - If vehicleId is null: btnViewVehicle.setDisable(true)
    // - If vehicleId is not null: btnViewVehicle.setDisable(false)

    // -------------------------------------------------------------------------
    // SECTION 2: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnViewVehicle(java.util.function.Consumer<Long>
    // action)'
    // Allows defining what happens from outside when "View vehicle" is pressed.
    // Recommendation:
    // - btnViewVehicle.setOnAction(event -> { if (vehicleId != null)
    // action.accept(vehicleId); });

    // TODO: (Optional) Create method 'setOnViewVehicle(Runnable action)'
    // Simple variant if you don't need to pass the id:
    // - btnViewVehicle.setOnAction(event -> action.run());
}