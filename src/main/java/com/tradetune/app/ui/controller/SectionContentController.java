package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.*; // Importar tus modelos (Vehicle, Client, etc.)
import com.tradetune.app.ui.navigation.NavSection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

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

    private void loadView(String title, String actionButtonText, Runnable actionHandler, String fxmlItemPath, NavSection section) {
        setTitle(title);
        setActionButton(actionButtonText, actionHandler);
        clearItems();

        // Simulando la carga de 5 elementos para probar
        for (int i = 1; i <= 15; i++) {
            addItemToContent(fxmlItemPath, section, i);
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
                NavSection.PROPOSALS);
    }

    public void loadSoldView() {
        loadView("VEHÍCULOS VENDIDOS",
                null,
                null,
                "/com/tradetune/app/ui/fxml/components/ItemSoldVehicle.fxml",
                NavSection.SOLD);
    }

    // Método para cargar el FXML y configurar los datos correspondientes
    // He añadido el índice 'i' para variar los datos de prueba
    private void addItemToContent(String fxmlPath, NavSection section, int i) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Node node = loader.load();

            switch (section) {
                case VEHICLES:
                    if (loader.getController() instanceof ItemVehicleController) {
                        ItemVehicleController ctrl = loader.getController();
//                        // Crear Mock Vehicle
//                        Vehicle vehicle = new Vehicle();
//                        vehicle.setId(i);
//                        vehicle.setBrand("Ford");
//                        vehicle.setModel("Focus " + i);
//                        vehicle.setFuel("Diesel");
//                        vehicle.setKm(120000 + (i * 1000));
//                        vehicle.setYear((short) 2018);
//                        vehicle.setBasePrice(new BigDecimal("12500.00"));
//                        vehicle.setArrivalDate(LocalDate.now().minusDays(30 + i));
//
//
//                        // Mock relación Dealership para evitar NullPointer
//                        Dealership d = new Dealership();
//                        d.setCity("Madrid");
//                        vehicle.setIdDealership(d);
//
//                        ctrl.setData(vehicle);
                    }
                    break;

                case SOLD:
                    if (loader.getController() instanceof ItemSoldVehicleController) {
                        ItemSoldVehicleController ctrl = loader.getController();
//                        // Crear Mock Sale
//                        Sale sale = new Sale();
//                        sale.setId(i);
//                        sale.setSaleTs(Instant.now());
//                        sale.setFinalPriceSnapshot(new BigDecimal("18500.00"));
//
//                        // Mock relaciones (Sale -> Vehicle)
//                        Vehicle sv = new Vehicle();
//                        sv.setBrand("BMW");
//                        sv.setModel("Serie 1");
//                        sale.setIdVehicle(sv);
//
//                        // Mock relaciones (Sale -> Proposal -> Client)
//                        Proposal so = new Proposal();
//                        Client sc = new Client();
//                        sc.setFullName("Comprador " + i);
//                        so.setIdClient(sc);
//                        sale.setIdProposal(so);
//
//                        ctrl.setData(sale);
                    }
                    break;

                case CLIENTS:
                    if (loader.getController() instanceof ItemClientController) {
                        ItemClientController ctrl = loader.getController();
//                        // Crear Mock Client
//                        Client client = new Client();
//                        client.setId(i);
//                        client.setFullName("Cliente Ejemplo " + i);
//                        client.setDniNif("12345678" + i);
//                        client.setEmail("cliente" + i + "@email.com");
//                        client.setPhoneNumber("600 000 00" + i);
//
//                        // Pasamos el objeto cliente + un booleano random para probar el badge
//                        ctrl.setData(client, i % 2 == 0);
                    }
                    break;

                case PROPOSALS:
                    if (loader.getController() instanceof ItemProposalController) {
                        ItemProposalController ctrl = loader.getController();
//                        // Crear Mock Proposal
//                        Proposal proposal = new Proposal();
//                        proposal.setId(i);
//                        proposal.setFinalPrice(new BigDecimal("15800.00"));
//                        proposal.setValidityDate(LocalDate.now().plusDays(15));
//
//                        // Mock Relaciones
//                        Client oc = new Client();
//                        oc.setFullName("María López " + i);
//                        proposal.setIdClient(oc);
//
//                        Vehicle ov = new Vehicle();
//                        ov.setBrand("Seat");
//                        ov.setModel("Ibiza");
//                        proposal.setIdVehicle(ov);
//
//                        ctrl.setData(proposal);
                    }
                    break;

                default:
                    System.err.println("Sección no manejada: " + section);
            }

            listView.getItems().add(node);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error cargando FXML: " + fxmlPath);
        }
    }
}