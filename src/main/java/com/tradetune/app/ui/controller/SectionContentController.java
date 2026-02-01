package com.tradetune.app.ui.controller;

import com.tradetune.app.ui.navigation.NavSection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SectionContentController {

    @FXML private Button btnAction;
    @FXML private Label lblTitle;
    @FXML private ListView<Node> listView;
    @FXML private TextField txtSearch;

    // Método para configurar el título de la sección
    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    // Método para configurar el botón de acción
    public void setActionButton(String text, Runnable action) {
        btnAction.setText(text);
        btnAction.setOnAction(e -> action.run());
        showActionButton(true);
    }

    public void showActionButton(boolean show) {
        btnAction.setVisible(show);
        btnAction.setManaged(show);
    }

    public void clearItems() {
        listView.getItems().clear();
    }

    private void loadView(String title, String actionButtonText, Runnable actionHandler, String fxmlItemPath, NavSection section) {
        setTitle(title);
        if (actionButtonText != null) {
            setActionButton(actionButtonText, actionHandler);
        } else {
            showActionButton(false);
        }
        clearItems();
        // Simulando la carga de 10 vehículos
        for (int i = 0; i < 10; i++) {
            addItemToContent(fxmlItemPath, section);
        }
    }

    // Métodos específicos para cargar las vistas
    public void loadVehiclesView() {
        loadView("VEHÍCULOS DISPONIBLES", null, null, "/com/tradetune/app/ui/fxml/components/ItemVehicle.fxml", NavSection.VEHICLES);
    }


    public void loadClientsView() {
        loadView("GESTIÓN DE CLIENTES","+ Registrar Interesado", () -> System.out.println("Click Registrar"), "/com/tradetune/app/ui/fxml/components/ItemClient.fxml", NavSection.CLIENTS);
    }

    public void loadProposalsView() {
        loadView("PROPUESTAS DE VENTA",
                "+ Crear Propuesta",
                () -> System.out.println("Click Crear"),
                "/com/tradetune/app/ui/fxml/components/ItemProposal.fxml",
                NavSection.OFFERS);
    }

    public void loadSoldView() {
        loadView("VEHÍCULOS VENDIDOS",
                null,
                null,
                "/com/tradetune/app/ui/fxml/components/ItemSoldVehicle.fxml",
                NavSection.SOLD);
    }

    // Método para cargar el FXML y configurar los datos correspondientes
    private void addItemToContent(String fxmlPath, NavSection section) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Node node = loader.load();

            switch (section) {
                case VEHICLES:
                    ItemVehicleController ctrlVehicle = loader.getController();
                    ctrlVehicle.setData(
                            "Ford Focus",
                            "Diesel",
                            120000,
                            2018,
                            "Madrid",
                            30,
                            12000,
                            null
                    );
                    break;
                case SOLD:
                    ItemSoldVehicleController ctrlSoldVehicle = loader.getController();
                    ctrlSoldVehicle.setData(
                            "BMW Serie 1",
                            "Juan Pérez",
                            "12/01/2026",
                            18500
                    );
                    break;
                case CLIENTS:
                    // Configuración futura para clientes
                    break;
                case OFFERS:
                    // Configuración futura para propuestas
                    break;
                default:
                    System.err.println("Tipo de item no reconocido: ");
            }

            listView.getItems().add(node);  // Agregar el nodo al ListView
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
