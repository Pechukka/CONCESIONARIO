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

        // Simulando la carga de 10 elementos para probar
        for (int i = 1; i <= 10; i++) {
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
    // He añadido el índice 'i' para variar los datos de prueba
    private void addItemToContent(String fxmlPath, NavSection section, int i) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Node node = loader.load();

            switch (section) {
                case VEHICLES:
                    if (loader.getController() instanceof ItemVehicleController) {
                        ItemVehicleController ctrl = loader.getController();
                        // Crear Mock Vehicle
                        Vehicle v = new Vehicle();
                        v.setId(i);
                        v.setBrand("Ford");
                        v.setModel("Focus " + i);
                        v.setFuel("Diesel");
                        v.setKm(120000 + (i * 1000));
                        v.setYear((short) 2018);
                        v.setBasePrice(new BigDecimal("12500.00"));
                        v.setArrivalDate(LocalDate.now().minusDays(30 + i));

                        // Mock relación Dealership para evitar NullPointer
                        Dealership d = new Dealership();
                        d.setCity("Madrid");
                        v.setIdDealership(d);

                        ctrl.setData(v); // ¡Pasamos el objeto!
                    }
                    break;

                case SOLD:
                    if (loader.getController() instanceof ItemSoldVehicleController) {
                        ItemSoldVehicleController ctrl = loader.getController();
                        // Crear Mock Sale
                        Sale s = new Sale();
                        s.setId(i);
                        s.setSaleTs(Instant.now());
                        s.setFinalPriceSnapshot(new BigDecimal("18500.00"));

                        // Mock relaciones (Sale -> Vehicle)
                        Vehicle sv = new Vehicle();
                        sv.setBrand("BMW");
                        sv.setModel("Serie 1");
                        s.setIdVehicle(sv);

                        // Mock relaciones (Sale -> Offer -> Client)
                        Offer so = new Offer();
                        Client sc = new Client();
                        sc.setFullName("Comprador " + i);
                        so.setIdClient(sc);
                        s.setIdOffer(so);

                        ctrl.setData(s); // ¡Pasamos el objeto!
                    }
                    break;

                case CLIENTS:
                    if (loader.getController() instanceof ItemClientController) {
                        ItemClientController ctrl = loader.getController();
                        // Crear Mock Client
                        Client c = new Client();
                        c.setId(i);
                        c.setFullName("Cliente Ejemplo " + i);
                        c.setDniNif("12345678" + i);
                        c.setEmail("cliente" + i + "@email.com");
                        c.setPhoneNumber("600 000 00" + i);

                        // Pasamos el objeto cliente + un booleano random para probar el badge
                        ctrl.setData(c, i % 2 == 0);
                    }
                    break;

                case OFFERS:
                    if (loader.getController() instanceof ItemProposalController) {
                        ItemProposalController ctrl = loader.getController();
                        // Crear Mock Offer
                        Offer o = new Offer();
                        o.setId(i);
                        o.setFinalPrice(new BigDecimal("15800.00"));
                        o.setValidityDate(LocalDate.now().plusDays(15));

                        // Mock Relaciones
                        Client oc = new Client();
                        oc.setFullName("María López " + i);
                        o.setIdClient(oc);

                        Vehicle ov = new Vehicle();
                        ov.setBrand("Seat");
                        ov.setModel("Ibiza");
                        o.setIdVehicle(ov);

                        ctrl.setData(o); // ¡Pasamos el objeto!
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