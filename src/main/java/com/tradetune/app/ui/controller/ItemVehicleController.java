package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.model.VehicleImage;
import com.tradetune.app.service.VehicleService;
import com.tradetune.app.service.impl.VehicleServiceImpl;
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

    // Instancia del servicio (necesaria para pedir las fotos)
    private final VehicleService vehicleService = new VehicleServiceImpl();

    public void setData(Vehicle vehicle) {
        if (vehicle == null) return;

        // 1. Datos de texto (Igual que antes)
        lblModel.setText(vehicle.getBrand() + " " + vehicle.getModel());
        lblTechnicalInfo.setText(String.format("%s • %d km • %d",
                vehicle.getFuel(), vehicle.getKm(), vehicle.getYear()));

        // Manejo de nulos en Dealership
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
        lblPrice.setText(String.format("%,.0f €", vehicle.getBasePrice()));

        // --- 2. CARGA DE IMAGEN REAL (Backend) ---
        // Pedimos al servicio las fotos de ESTE vehículo
        List<VehicleImage> images = vehicleService.getVehicleImages(vehicle.getId());

        if (images != null && !images.isEmpty()) {
            // Cogemos la primera foto de la lista
            String imageUrl = images.get(0).getUrl();

            try {
                // 'true' en el constructor activa la carga en segundo plano (para no congelar la UI)
                Image image = new Image(imageUrl, true);
                imgVehicle.setImage(image);
            } catch (Exception e) {
                System.err.println("No se pudo cargar la imagen: " + imageUrl);
            }
        } else {
            // Si no hay fotos, podrías poner una imagen por defecto
            // imgVehicle.setImage(new Image(getClass().getResource("/images/placeholder.png").toExternalForm()));
        }

        btnViewDetails.setOnAction(e -> System.out.println("Ver vehículo ID: " + vehicle.getId()));
    }
}