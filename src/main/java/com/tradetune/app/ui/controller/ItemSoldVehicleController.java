package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Sale;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ItemSoldVehicleController {

    @FXML private Label lblModel;
    @FXML private Label lblClientName;
    @FXML private Label lblSaleDate;
    @FXML private Label lblPrice;
    @FXML private Button btnViewDetails;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // --- MÉTODO SET DATA CON ENTIDAD REAL ---
    public void setData(Sale sale) {
        if (sale == null) return;

        // 1. Vehículo (Navegación Sale -> Vehicle)
        if (sale.getIdVehicle() != null) {
            lblModel.setText(sale.getIdVehicle().getBrand() + " " + sale.getIdVehicle().getModel());
        }

        // 2. Cliente (Navegación Sale -> Offer -> Client)
        if (sale.getidProposal() != null && sale.getidProposal().getIdClient() != null) {
            lblClientName.setText("Cliente: " + sale.getidProposal().getIdClient().getFullName());
        } else {
            lblClientName.setText("Cliente: Desconocido");
        }

        // 3. Fecha Venta (Convertir Instant a LocalDate para formatear)
        if (sale.getSaleTs() != null) {
            String fechaStr = sale.getSaleTs().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter);
            lblSaleDate.setText("Fecha de venta: " + fechaStr);
        }

        // 4. Precio Final (Snapshot del momento de la venta)
        lblPrice.setText(String.format("%,.0f €", sale.getFinalPriceSnapshot()));

        // Acción
        btnViewDetails.setOnAction(e -> System.out.println("Ver venta ID: " + sale.getId()));
    }
}