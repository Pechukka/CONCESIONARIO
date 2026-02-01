package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import com.tradetune.app.domain.model.Sale; // Descomentar cuando exista

public class ItemSoldVehicleController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Label lblModel;
    @FXML private Label lblClientName;
    @FXML private Label lblSaleDate;
    @FXML private Label lblPrice;
    @FXML private Button btnViewDetails;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configuración inicial si fuera necesaria.
    }

    public void setData(
            String model,
            String clientName,
            String saleDate,
            double price
    ) {
        // Modelo del vehículo
        lblModel.setText(model);

        // Nombre del cliente
        lblClientName.setText(clientName);

        // Fecha de venta
        lblSaleDate.setText(saleDate);

        // Precio final
        lblPrice.setText("€" + String.format("%.2f", price));

        // Acción del botón detalles
        btnViewDetails.setOnAction(event -> {
            System.out.println("View sold vehicle details: " + model);
        });
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnViewDetails(Runnable action)'
    // Permite al controlador padre definir qué pasa cuando se pulsa "Ver Detalles" (ej: abrir ficha de venta).
    // btnViewDetails.setOnAction(event -> action.run());
}