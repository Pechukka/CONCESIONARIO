package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class BasePopUpController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Label lblTitle;
    @FXML private Button btnCross;
    @FXML private StackPane paneModal;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------

    @FXML
    public void initialize() {
        // TODO: Configurar estado inicial del modal (listeners, accesibilidad, etc.).
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: CONFIGURACIÓN DEL HEADER
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setTitle(String title)'
    // Asigna dinámicamente el texto del título del modal (lblTitle).

    // -------------------------------------------------------------------------
    // SECCIÓN 2: GESTIÓN DEL CONTENIDO MODAL
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setModalContent(javafx.scene.Node content)'
    // Inserta la pantalla/modal recibida dentro del StackPane paneModal.
    // Debe reemplazar cualquier contenido previo.

    // -------------------------------------------------------------------------
    // SECCIÓN 3: EVENTOS Y CIERRE
    // -------------------------------------------------------------------------

    // TODO: Crear método 'onCloseAction()'
    // Gestiona el cierre del modal al pulsar la cruz.
    // Debe cerrar el Stage o notificar al controlador padre.

    // TODO: Crear método 'closeModal()'
    // Cierra el modal de forma centralizada (reutilizable por otros eventos).

    // -------------------------------------------------------------------------
    // SECCIÓN 4: UTILIDADES (OPCIONAL)
    // -------------------------------------------------------------------------

    // TODO: Crear método 'clearModalContent()'
    // Elimina el contenido actual del StackPane paneModal.

}