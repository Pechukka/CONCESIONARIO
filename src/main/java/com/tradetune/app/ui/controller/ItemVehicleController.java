package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ItemVehicleController {

    @FXML private ImageView imgVehicle;
    @FXML private Label lblModel;
    @FXML private Label lblTechnicalInfo;
    @FXML private Label lblLocation;
    @FXML private Label lblStockDays;
    @FXML private Label lblPrice;
    @FXML private Button btnViewDetails;

    @FXML
    private void initialize() {
        btnViewDetails.setOnAction(e -> openVehicleDetailsPopup());
    }

    // --- MÉTODO SET DATA CON ENTIDAD REAL ---
    public void setData(Vehicle vehicle) {
        if (vehicle == null) return;

        // 1. Marca y Modelo
        lblModel.setText(vehicle.getBrand() + " " + vehicle.getModel());

        // 2. Info Técnica (Combustible • Km • Año)
        lblTechnicalInfo.setText(String.format("%s • %d km • %d",
                vehicle.getFuel(),
                vehicle.getKm(),
                vehicle.getYear()));

        // 3. Ubicación (Navegamos a Dealership)
        // Nota: Asegúrate de que idDealership venga cargado (no sea null/lazy)
        if (vehicle.getIdDealership() != null) {
            lblLocation.setText(vehicle.getIdDealership().getCity());
        } else {
            lblLocation.setText("Ubicación desconocida");
        }

        // 4. Días en Stock (Cálculo dinámico)
        long days = 0;
        if (vehicle.getArrivalDate() != null) {
            days = ChronoUnit.DAYS.between(vehicle.getArrivalDate(), LocalDate.now());
        }
        lblStockDays.setText("En stock: " + days + " días");

        // 5. Precio (BigDecimal formateado)
        lblPrice.setText(String.format("%,.0f €", vehicle.getBasePrice()));

        // TODO: Cargar imagen real si tienes la lógica (ej. vehicle.getImages()...)

        // Acción del botón
        btnViewDetails.setOnAction(e -> System.out.println("Ver vehículo ID: " + vehicle.getId()));
    }

    private void openVehicleDetailsPopup() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/tradetune/app/ui/fxml/components/BasePopUp.fxml"
            ));
            Parent root = loader.load();

            BasePopUpController popUpCtrl = loader.getController();
            popUpCtrl.setContent("/com/tradetune/app/ui/fxml/screens/VehicleDetails.fxml");

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(true);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo abrir el popup de detalles", ex);
        }
    }

}