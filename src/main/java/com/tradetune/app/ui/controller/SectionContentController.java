package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class SectionContentController {

    @FXML
    private Button btnAction;

    @FXML
    private Label lblTitle;

    @FXML
    private ListView<Node> listView;

    @FXML
    private TextField txtSearch;

    // Método para configurar el título de la sección
    // Método para configurar el título de la sección
    public void setTitle(String title) {
        lblTitle.setText(title);
        System.out.println("Título de sección: " + title);
    }

    // Método para configurar el botón de acción
    public void configureActionButton(String buttonText, Runnable action) {
        if (buttonText != null) {
            btnAction.setText(buttonText);
            btnAction.setOnAction(e -> action.run());
        } else {
            btnAction.setVisible(false); // Si no hay texto, ocultamos el botón
        }
    }

    // Método para limpiar los elementos antes de cargar una nueva vista
    public void clearItems() {
        listView.getItems().clear();  // Limpiar los elementos de la lista
    }

    // Métodos específicos para cargar las vistas
    public void loadVehiclesView() {
        setTitle("VEHÍCULOS DISPONIBLES");
        //configureActionButton(null, null);
        clearItems();

        // Simulando la carga de 10 vehículos
        for (int i = 0; i < 10; i++) {
            addItemToContent("/com/tradetune/app/ui/fxml/components/ItemVehicle.fxml", "VEHICULO");
        }
    }

    public void loadClientsView() {
        setTitle("GESTIÓN DE CLIENTES");
        configureActionButton("+ Registrar Interesado", () -> System.out.println("Click Registrar"));
        clearItems();

        for (int i = 0; i < 10; i++) {
            addItemToContent("/com/tradetune/app/ui/fxml/components/ItemClient.fxml", "CLIENTE");
        }
    }

    public void loadProposalsView() {
        setTitle("PROPUESTAS DE VENTA");
        configureActionButton("+ Crear Propuesta", () -> System.out.println("Click Crear"));
        clearItems();

        for (int i = 0; i < 10; i++) {
            addItemToContent("/com/tradetune/app/ui/fxml/components/ItemProposal.fxml", "PROPUESTA");
        }
    }

    public void loadSoldView() {
        setTitle("VEHÍCULOS VENDIDOS");
        configureActionButton(null, null);
        clearItems();

        for (int i = 0; i < 10; i++) {
            addItemToContent("/com/tradetune/app/ui/fxml/components/ItemSoldVehicle.fxml", "VENDIDO");
        }
    }

    // Método para cargar el FXML y configurar los datos correspondientes
    private void addItemToContent(String fxmlPath, String type) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Node node = loader.load();


            switch (type) {
                case "VEHICULO":
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
                case "VENDIDO":
                    ItemSoldVehicleController ctrlSoldVehicle = loader.getController();
                    ctrlSoldVehicle.setData(
                            "BMW Serie 1",
                            "Juan Pérez",
                            "12/01/2026",
                            18500
                    );
                }


            listView.getItems().add(node);  // Agregar el nodo al ListView
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
