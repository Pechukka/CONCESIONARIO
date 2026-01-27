package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.Node; // Necesario para los items

public class SectionContentController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    // TODO: Verificar que estos nombres coinciden con los fx:id del archivo SectionContent.fxml
    @FXML private Label lblTitle;
    @FXML private TextField txtSearch;
    @FXML private VBox vboxItems;   // El contenedor dentro del ScrollPane
    @FXML private Button btnAction; // El botón de abajo a la derecha

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Estado inicial de la vista.
        // Pista: Ocultar btnAction por defecto (setVisible(false)) para que solo salga si lo pedimos.
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: CONFIGURACIÓN VISUAL
    // -------------------------------------------------------------------------

    // TODO: Método 'setTitle(String title)'
    // Debe cambiar el texto de lblTitle.

    // TODO: Método 'configureActionButton(String text, Runnable action)'
    // 1. Poner el texto al botón.
    // 2. Hacer el botón visible.
    // 3. Asignarle la acción (setOnAction).

    // -------------------------------------------------------------------------
    // SECCIÓN 2: GESTIÓN DE LA LISTA (ITEMS)
    // -------------------------------------------------------------------------

    // TODO: Método 'addItem(Node item)'
    // Debe recibir un Nodo (la tarjeta de coche/cliente) y añadirlo al vboxItems.

    // TODO: Método 'clearItems()'
    // Debe borrar todos los hijos de vboxItems (vboxItems.getChildren().clear()).

    // -------------------------------------------------------------------------
    // SECCIÓN 3: FUNCIONALIDAD DE BÚSQUEDA
    // -------------------------------------------------------------------------

    // TODO: Método 'getSearchField()'
    // Debe devolver el objeto txtSearch para poder añadirle listeners desde el controlador principal.
}