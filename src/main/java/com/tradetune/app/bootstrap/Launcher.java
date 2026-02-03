package com.tradetune.app.bootstrap;

import javafx.application.Application;

/**
 * Entry point for the Trade and Tune application.
 * Launches the JavaFX application by delegating to MainApp.
 */
public class Launcher {
    /**
     * Main method that starts the JavaFX application.
     * 
     * @param args command line arguments to pass to the application
     */
    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }
}
