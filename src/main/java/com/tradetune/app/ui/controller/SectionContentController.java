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

    @FXML
    private Button btnAction;
    @FXML
    private Label lblTitle;
    @FXML
    private ListView<Node> listView;
    @FXML
    private TextField txtSearch;

    // Sets the section title
    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    // Configures the action button with text and handler
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

    private void loadView(String title, String actionButtonText, Runnable actionHandler, String fxmlItemPath,
            NavSection section) {
        setTitle(title);
        if (actionButtonText != null) {
            setActionButton(actionButtonText, actionHandler);
        } else {
            showActionButton(false);
        }
        clearItems();
        // Simulating the loading of 10 items
        for (int i = 0; i < 10; i++) {
            addItemToContent(fxmlItemPath, section);
        }
    }

    // Specific methods to load different views
    public void loadVehiclesView() {
        loadView("AVAILABLE VEHICLES", null, null, "/com/tradetune/app/ui/fxml/components/ItemVehicle.fxml",
                NavSection.VEHICLES);
    }

    public void loadClientsView() {
        loadView("CLIENT MANAGEMENT", "+ Register Interested", () -> System.out.println("Click Register"),
                "/com/tradetune/app/ui/fxml/components/ItemClient.fxml", NavSection.CLIENTS);
    }

    public void loadProposalsView() {
        loadView("SALES PROPOSALS",
                "+ Create Proposal",
                () -> System.out.println("Click Create"),
                "/com/tradetune/app/ui/fxml/components/ItemProposal.fxml",
                NavSection.PROPOSALS);
    }

    public void loadSoldView() {
        loadView("VEHICLES SOLD",
                null,
                null,
                "/com/tradetune/app/ui/fxml/components/ItemSoldVehicle.fxml",
                NavSection.SOLD);
    }

    // Method to load FXML and configure corresponding data
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
                            null);
                    break;
                case SOLD:
                    ItemSoldVehicleController ctrlSoldVehicle = loader.getController();
                    ctrlSoldVehicle.setData(
                            "BMW Serie 1",
                            "Juan Pérez",
                            "12/01/2026",
                            18500);
                    break;
                case CLIENTS:
                    // Future configuration for clients
                    break;
                case PROPOSALS:
                    // Future configuration for proposals
                    break;
                default:
                    System.err.println("Unrecognized item type: ");
            }

            listView.getItems().add(node); // Add the node to the ListView
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
