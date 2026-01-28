package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StepperProposalController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Label circle1; // El círculo con el "1"
    @FXML private Label label1;  // El texto "Vehículo"

    @FXML private Label circle2;
    @FXML private Label label2;

    @FXML private Label circle3;
    @FXML private Label label3;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Inicializar en el paso 1 por defecto (setActiveStep(1)).
    }

    // -------------------------------------------------------------------------
    // LÓGICA DE ESTADO
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setActiveStep(int stepNumber)'
    // Este método es el único que necesitan llamar desde fuera.
    // Lógica:
    // 1. Resetear todos los estilos a "inactivo":
    //    - Quitar clase 'stepper-circle-active' de circle1, circle2, circle3.
    //    - Quitar clase 'stepper-label-active' de label1, label2, label3.
    // 2. Aplicar estilo "activo" según el número recibido:
    //    - Si stepNumber == 1: Añadir clases activas a circle1 y label1.
    //    - Si stepNumber == 2: Añadir clases activas a circle2 y label2.
    //    - Si stepNumber == 3: Añadir clases activas a circle3 y label3.
}