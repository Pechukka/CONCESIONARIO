package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// import com.tradetune.app.domain.model.Vehicle; // Descomentar cuando exista

public class ItemVehicleController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private ImageView imgVehicle;
    @FXML private Label lblModel;
    @FXML private Label lblTechnicalInfo; // Para: "Diesel • 120.000 km • 2018"
    @FXML private Label lblLocation;
    @FXML private Label lblStockDays;
    @FXML private Label lblPrice;
    @FXML private Button btnViewDetails;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configuración inicial si fuera necesaria (ej. placeholder de imagen).
    }

    public void setData(String model, String fuelType, int km, int year, String location, int stockDays, double price, String imagePath) {
        // Configura el modelo
        lblModel.setText(model);

        // Configura la información técnica (combustible, km, año)
        lblTechnicalInfo.setText(fuelType + " • " + km + " km • " + year);

        // Configura la ubicación del vehículo
        lblLocation.setText(location);

        // Configura los días en stock
        lblStockDays.setText("En stock por " + stockDays + " días");

        // Configura el precio del vehículo
        lblPrice.setText("€" + String.format("%.2f", price));

        //TODO: Agregar lógica imagen

        // Configura la imagen del vehículo (si la ruta es válida)
/*
        if (imagePath != null && !imagePath.isEmpty()) {
            imgVehicle.setImage(new Image(imagePath));
        }
*/

        // Configura el botón para ver los detalles (si se desea añadir alguna acción)
        btnViewDetails.setOnAction(event -> {
            // Aquí puedes agregar la lógica para ver los detalles del vehículo
            System.out.println("Ver detalles de: " + model);
        });
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setData(Vehicle vehicle)'
    // Este método recibirá el objeto 'Vehicle' de la base de datos y rellenará los labels:
    // 1. lblModel.setText(vehicle.getBrand() + " " + vehicle.getModel());
    // 2. lblPrice.setText(vehicle.getPrice() + " €");
    // 3. Construir String para lblTechnicalInfo (fuel, km, year).
    // 4. Calcular días en stock (Fecha actual - Fecha llegada) para lblStockDays.
    // 5. Cargar la imagen en imgVehicle (usar una por defecto si es null).

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnViewDetails(Runnable action)'
    // Permite al controlador padre definir qué pasa cuando se pulsa "Ver Detalles".
    // btnViewDetails.setOnAction(event -> action.run());
}