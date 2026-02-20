package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.model.VehicleImage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class VehicleDetailsController {

    @FXML
    private ImageView imgVehicle;

    @FXML
    private Label lblBrand;

    @FXML
    private Label lblDealer;

    @FXML
    private Label lblFuel;

    @FXML
    private Label lblKm;

    @FXML
    private Label lblModel;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblStockDays;

    @FXML
    private Label lblYear;
    public void setData(Vehicle vehicle) {
        if (vehicle == null) return;

        lblModel.setText(vehicle.getModel());
        lblBrand.setText(vehicle.getBrand());
        lblFuel.setText(String.valueOf(vehicle.getFuel()));
        lblKm.setText(vehicle.getKm() + " km");
        lblYear.setText(String.valueOf(vehicle.getYear()));
        lblPrice.setText(String.format("%,.0f €", vehicle.getBasePrice()));

        if (vehicle.getIdDealership() != null) {
            lblDealer.setText(vehicle.getIdDealership().getName() + " (" + vehicle.getIdDealership().getCity() + ")");
        } else {
            lblDealer.setText("-");
        }

        long days = 0;
        if (vehicle.getArrivalDate() != null) {
            days = ChronoUnit.DAYS.between(vehicle.getArrivalDate(), LocalDate.now());
        }
        lblStockDays.setText(days + " días");

        // Imagen
        imgVehicle.setImage(null);
        List<VehicleImage> images = vehicle.getImages();
        if (images != null && !images.isEmpty()) {
            String dbPath = images.get(0).getUrl();
            try {
                String filename = dbPath.substring(dbPath.lastIndexOf("/") + 1);
                String correctPath = "/com/tradetune/app/assets/images/vehicles/" + filename;
                var resource = getClass().getResource(correctPath);
                if (resource != null) imgVehicle.setImage(new Image(resource.toExternalForm(), true));
            } catch (Exception ignored) {}
        }
    }
}
