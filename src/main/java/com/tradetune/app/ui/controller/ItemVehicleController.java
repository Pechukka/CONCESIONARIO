package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.model.VehicleImage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ItemVehicleController {

    @FXML private ImageView imgVehicle;
    @FXML private Label lblModel;
    @FXML private Label lblTechnicalInfo;
    @FXML private Label lblLocation;
    @FXML private Label lblStockDays;
    @FXML private Label lblPrice;
    @FXML private Button btnViewDetails;

    public void setData(Vehicle vehicle) {
        if (vehicle == null) return;

        lblModel.setText(vehicle.getBrand() + " " + vehicle.getModel());
        lblTechnicalInfo.setText(String.format("%s • %d km • %d", vehicle.getFuel(), vehicle.getKm(), vehicle.getYear()));
        lblPrice.setText(String.format("%,.0f €", vehicle.getBasePrice()));

        // DEALERSHIP (Ya no fallará gracias al repositorio)
        if (vehicle.getIdDealership() != null) {
            lblLocation.setText(vehicle.getIdDealership().getCity());
        } else {
            lblLocation.setText("-");
        }

        long days = 0;
        if (vehicle.getArrivalDate() != null) {
            days = ChronoUnit.DAYS.between(vehicle.getArrivalDate(), LocalDate.now());
        }
        lblStockDays.setText("En stock: " + days + " días");

        // --- CARGA DE IMÁGENES ---
        imgVehicle.setImage(null);
        List<VehicleImage> images = vehicle.getImages();

        if (images != null && !images.isEmpty()) {
            String dbPath = images.get(0).getUrl();

            try {
                String filename = dbPath.substring(dbPath.lastIndexOf("/") + 1);

                String correctPath = "/com/tradetune/app/assets/images/vehicles/" + filename;

                // 3. Cargamos la imagen
                var resource = getClass().getResource(correctPath);
                if (resource != null) {
                    imgVehicle.setImage(new Image(resource.toExternalForm(), true));
                } else {
                    System.err.println("Imagen no encontrada en resources: " + correctPath);
                }

            } catch (Exception e) {
                System.err.println("Error cargando imagen: " + dbPath);
            }
        }

        btnViewDetails.setOnAction(e -> System.out.println("Ver vehículo ID: " + vehicle.getId()));
    }
}