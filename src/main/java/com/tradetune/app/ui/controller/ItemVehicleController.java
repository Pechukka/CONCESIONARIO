package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Vehicle; // Descomentar cuando exista

public class ItemVehicleController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private ImageView imgVehicle;
    @FXML
    private Label lblModel;
    @FXML
    private Label lblTechnicalInfo; // For: "Diesel • 120,000 km • 2018"
    @FXML
    private Label lblLocation;
    @FXML
    private Label lblStockDays;
    @FXML
    private Label lblPrice;
    @FXML
    private Button btnViewDetails;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Initial configuration if necessary (e.g. placeholder image).
    }

    /**
     * Sets the vehicle display data.
     * Populates all UI elements with vehicle information.
     * 
     * @param model     the vehicle model name
     * @param fuelType  the fuel type (e.g. "Diesel", "Gasoline")
     * @param km        the mileage in kilometers
     * @param year      the manufacturing year
     * @param location  the vehicle location/city
     * @param stockDays days the vehicle has been in stock
     * @param price     the vehicle price
     * @param imagePath the path to the vehicle image (optional, can be null)
     */
    public void setData(String model, String fuelType, int km, int year, String location, int stockDays, double price,
            String imagePath) {
        // Sets the model
        lblModel.setText(model);

        // Configures technical information (fuel, km, year)
        lblTechnicalInfo.setText(fuelType + " • " + km + " km • " + year);

        // Configures vehicle location
        lblLocation.setText(location);

        // Configures days in stock
        lblStockDays.setText("In stock for " + stockDays + " days");

        // Configures vehicle price
        lblPrice.setText("€" + String.format("%.2f", price));

        // TODO: Add image logic

        // Configures vehicle image (if path is valid)
        /*
         * if (imagePath != null && !imagePath.isEmpty()) {
         * imgVehicle.setImage(new Image(imagePath));
         * }
         */

        // Configures the details button (if action is needed)
        btnViewDetails.setOnAction(event -> {
            // Here you can add the logic to view vehicle details
            System.out.println("View details for: " + model);
        });
    }

    // -------------------------------------------------------------------------
    // SECTION 2: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnViewDetails(Runnable action)'
    // Allows the parent controller to define what happens when "View Details" is
    // pressed.
    // btnViewDetails.setOnAction(event -> action.run());
}