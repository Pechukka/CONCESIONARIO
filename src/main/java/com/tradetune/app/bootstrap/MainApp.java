package com.tradetune.app.bootstrap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Main application class for Trade and Tune.
 * Initializes the JavaFX application, loads the primary FXML layout,
 * and applies CSS styling.
 */
public class MainApp extends Application {

    /**
     * Starts the JavaFX application.
     * Loads the SalesLayout FXML and applies the base CSS stylesheet.
     * 
     * @param primaryStage the primary stage (window) for the application
     * @throws IOException if the FXML or CSS resource cannot be loaded
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("/com/tradetune/app/ui/fxml/screens/SalesLayout.fxml")));
        Scene scene = new Scene(root);

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/tradetune/app/ui/css/base.css")).toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
