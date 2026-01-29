package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
// import com.tradetune.app.domain.model.Vehicle; // Descomentar cuando exista

public class ItemInterestedVehicleController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private HBox rootBox;

    @FXML private Label lblVehicle;   // "SEAT IBIZA 1.0 TSI"
    @FXML private Label lblDate;      // "Fecha de interés: 20/11/2025"
    @FXML private Button btnViewVehicle; // "Ver vehículo"

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Si el botón debe estar deshabilitado por defecto hasta setear datos, hacerlo aquí.
        // TODO: Si quieres ajustar comportamiento visual (managed/visible) inicial de algún nodo, hacerlo aquí.
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: POPULAR DATOS
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setInterestedVehicleData(Long vehicleId, String vehicleTitle, String interestDateText)'
    // 1. Guardar internamente el vehicleId (para saber qué abrir al pulsar).
    // 2. Rellenar lblVehicle con vehicleTitle (vacío si null).
    // 3. Rellenar lblDate con interestDateText (vacío si null).
    // 4. (Opcional) Llamar a un método interno para habilitar/deshabilitar el botón según vehicleId.

    // TODO: Crear método privado 'updateViewButtonState()'
    // Lógica recomendada:
    // - Si vehicleId es null: btnViewVehicle.setDisable(true)
    // - Si vehicleId no es null: btnViewVehicle.setDisable(false)

    // -------------------------------------------------------------------------
    // SECCIÓN 2: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setOnViewVehicle(java.util.function.Consumer<Long> action)'
    // Permite definir desde fuera qué ocurre al pulsar "Ver vehículo".
    // Recomendación:
    // - btnViewVehicle.setOnAction(event -> { if (vehicleId != null) action.accept(vehicleId); });

    // TODO: (Opcional) Crear método 'setOnViewVehicle(Runnable action)'
    // Variante simple si no necesitas pasar el id:
    // - btnViewVehicle.setOnAction(event -> action.run());
}