package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.service.VehicleService;
import com.tradetune.app.service.impl.VehicleServiceImpl;
import com.tradetune.app.ui.navigation.NavSection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class SectionContentController {

    @FXML private Button btnAction;
    @FXML private Label lblTitle;
    @FXML private ListView<Node> listView;
    @FXML private TextField txtSearch;

    // Instancia del servicio
    private final VehicleService vehicleService = new VehicleServiceImpl();

    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public void setActionButton(String text, Runnable action) {
        if (text != null) {
            btnAction.setText(text);
            btnAction.setOnAction(e -> action.run());
            showActionButton(true);
        } else {
            showActionButton(false);
        }
    }

    public void showActionButton(boolean show) {
        btnAction.setVisible(show);
        btnAction.setManaged(show);
    }

    public void clearItems() {
        listView.getItems().clear();
    }

    // --- CARGA DE VEHÍCULOS (CONEXIÓN REAL) ---
    public void loadVehiclesView() {
        setTitle("Cargando vehículos...");
        setActionButton(null, null);
        clearItems();

        // 1. Llamamos a la base de datos
        List<Vehicle> vehicles = vehicleService.findAll();

        setTitle("VEHÍCULOS DISPONIBLES (" + vehicles.size() + ")");

        // 2. Iteramos sobre los datos reales
        for (Vehicle vehicle : vehicles) {
            addItemToContent("/com/tradetune/app/ui/fxml/components/ItemVehicle.fxml", NavSection.VEHICLES, vehicle);
        }
    }

    // --- MOCKS (Los dejamos igual por ahora para que no falle el resto) ---
    public void loadClientsView() {
        setTitle("GESTIÓN DE CLIENTES");
        setActionButton("+ Registrar Interesado", () -> System.out.println("Click Registrar"));
        clearItems();
        // Simulamos 5 clientes (pasamos null como dato por ahora)
        for (int i = 0; i < 5; i++) addItemToContent("/com/tradetune/app/ui/fxml/components/ItemClient.fxml", NavSection.CLIENTS, null);
    }

    public void loadProposalsView() {
        setTitle("PROPUESTAS DE VENTA");
        setActionButton("+ Crear Propuesta", () -> System.out.println("Click Crear"));
        clearItems();
        for (int i = 0; i < 5; i++) addItemToContent("/com/tradetune/app/ui/fxml/components/ItemProposal.fxml", NavSection.PROPOSALS, null);
    }

    public void loadSoldView() {
        setTitle("VEHÍCULOS VENDIDOS");
        setActionButton(null, null);
        clearItems();
        for (int i = 0; i < 5; i++) addItemToContent("/com/tradetune/app/ui/fxml/components/ItemSoldVehicle.fxml", NavSection.SOLD, null);
    }


    // --- MÉTODO GENÉRICO PARA AÑADIR ITEMS ---
    // Ahora acepta "Object data" en vez de "int i" para ser flexible
    private void addItemToContent(String fxmlPath, NavSection section, Object data) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Node node = loader.load();

            switch (section) {
                case VEHICLES:
                    if (loader.getController() instanceof ItemVehicleController) {
                        ItemVehicleController ctrl = loader.getController();
                        // Pasamos el Vehículo REAL
                        if (data instanceof Vehicle) {
                            ctrl.setData((Vehicle) data);
                        }
                    }
                    break;

                // Resto de casos (MOCKS)
                case CLIENTS:
                case PROPOSALS:
                case SOLD:
                    // Aquí iría la lógica de los otros controladores cuando estén listos
                    break;
            }

            listView.getItems().add(node);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error cargando FXML: " + fxmlPath);
        }
    }
}