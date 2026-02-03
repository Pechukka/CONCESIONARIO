package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import com.tradetune.app.domain.model.Sale; // Uncomment when available

/**
 * Controller for displaying a sold vehicle item.
 * Shows sale information including vehicle, client, and transaction details.
 */
public class ItemSoldVehicleController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private Label lblModel;
    @FXML
    private Label lblClientName;
    @FXML
    private Label lblSaleDate;
    @FXML
    private Label lblPrice;
    @FXML
    private Button btnViewDetails;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Initial configuration if necessary.
    }

    /**
     * Sets the sold vehicle display data.
     * 
     * @param model      the vehicle model
     * @param clientName the name of the client who purchased the vehicle
     * @param saleDate   the date of the sale
     * @param price      the final sale price
     */
    public void setData(
            String model,
            String clientName,
            String saleDate,
            double price) {
        // Vehicle model
        lblModel.setText(model);

        // Client name
        lblClientName.setText(clientName);

        // Sale date
        lblSaleDate.setText(saleDate);

        // Final price
        lblPrice.setText("€" + String.format("%.2f", price));

        // Details button action
        btnViewDetails.setOnAction(event -> {
            System.out.println("View sold vehicle details: " + model);
        });
    }

    // -------------------------------------------------------------------------
    // SECTION 2: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnViewDetails(Runnable action)'
    // Allows the parent controller to define what happens when "View Details" is
    // pressed (e.g: open sale form).
    // btnViewDetails.setOnAction(event -> action.run());
}