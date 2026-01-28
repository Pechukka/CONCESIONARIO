package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.List;

public class SectionContentController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Label lblTitle;
    @FXML private TextField txtSearch;
    @FXML private VBox vboxItems;   // El contenedor dentro del ScrollPane
    @FXML private Button btnAction; // El botón de abajo a la derecha

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Estado inicial. Asegurar que btnAction esté oculto (visible=false) por defecto.
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: CONFIGURACIÓN VISUAL
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setTitle(String title)'
    // Debe actualizar el texto del label lblTitle con el nombre de la sección actual.

    // TODO: Crear método 'configureActionButton(String text, Runnable action)'
    // 1. Establecer el texto del botón.
    // 2. Hacer visible el botón (setVisible(true)).
    // 3. Asignar la acción al evento de clic (setOnAction).
    // Nota: Si text es null, el botón debe permanecer oculto.

    // -------------------------------------------------------------------------
    // SECCIÓN 2: GESTIÓN DE LA LISTA (ITEMS)
    // -------------------------------------------------------------------------

    // TODO: Crear método 'addItem(Node item)'
    // Recibe un nodo (la vista cargada de un coche, cliente, etc.) y lo añade a vboxItems.

    // TODO: Crear método 'clearItems()'
    // Elimina todos los elementos hijos actuales de vboxItems para limpiar la lista.

    // TODO: Crear método 'refreshItems(List<Node> items)'
    // Método de utilidad para limpiar la lista y añadir una colección nueva de golpe.

    // -------------------------------------------------------------------------
    // SECCIÓN 3: BÚSQUEDA Y LISTENERS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'getSearchField()'
    // Retorna el objeto TextField (txtSearch) para que el controlador padre pueda
    // añadirle listeners (ChangeListener) para filtrar en tiempo real.
}