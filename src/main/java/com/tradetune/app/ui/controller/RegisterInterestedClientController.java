package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
// import com.tradetune.app.domain.model.Vehicle; // Uncomment when available

/**
 * Controller for registering an interested client.
 * Collects personal, contact and interest information to create an interested
 * client record linked to a vehicle (optional) and notes.
 */
public class RegisterInterestedClientController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private TextField txtFullName; // "Nombre y apellidos"
    @FXML
    private TextField txtDniNie; // "12345678A"
    @FXML
    private TextField txtBirthDate; // "Fecha nacimiento" (text input)

    @FXML
    private TextField txtPhone; // "612 345 678"
    @FXML
    private TextField txtEmail; // "email@ejemplo.com"
    @FXML
    private TextField txtAddress; // "Dirección"

    @FXML
    private ComboBox<?> cmbVehicle; // "Seleccionar vehículo..."
    @FXML
    private TextField txtBudget; // "Presupuesto aproximado (€)"
    @FXML
    private TextArea txtNotes; // "Preferencias, observaciones..."

    @FXML
    private Button btnRegister; // "Registrar Cliente"
    @FXML
    private Button btnCancel; // "Cancelar"

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: If register should be disabled by default until required fields are
        // valid, do it here.
        // TODO: If you want to set initial focus (txtFullName.requestFocus()), do it
        // here.
        // TODO: If you want to configure input constraints (budget numeric), do it
        // here.
        // TODO: If cmbVehicle needs custom cell factory / converter for display, do it
        // here.
    }

    // -------------------------------------------------------------------------
    // SECTION 1: POPULATE DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'setVehicles(java.util.List<?> vehicles)'
    // 1. Fill cmbVehicle items (clear previous items).
    // 2. (Optional) Set prompt / default selection if needed.

    // TODO: (Optional) Create method 'setSelectedVehicle(Object vehicle)'
    // 1. cmbVehicle.setValue(vehicle) or clear selection if null.

    // -------------------------------------------------------------------------
    // SECTION 2: GET FORM DATA
    // -------------------------------------------------------------------------

    // TODO: Create method 'getFullName()' -> String
    // TODO: Create method 'getDniNie()' -> String
    // TODO: Create method 'getBirthDateText()' -> String
    // TODO: Create method 'getPhone()' -> String
    // TODO: Create method 'getEmail()' -> String
    // TODO: Create method 'getAddress()' -> String
    // TODO: Create method 'getSelectedVehicle()' -> Object (or typed)
    // TODO: Create method 'getBudgetText()' -> String
    // TODO: Create method 'getNotes()' -> String

    // -------------------------------------------------------------------------
    // SECTION 3: VALIDATION / STATE
    // -------------------------------------------------------------------------

    // TODO: Create private method 'isFormValid()' -> boolean
    // Recommended required fields:
    // - full name, dni/nie, phone, email

    // TODO: Create private method 'updateRegisterButtonState()'
    // Recommended logic:
    // - btnRegister.setDisable(!isFormValid())

    // -------------------------------------------------------------------------
    // SECTION 4: INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'setOnRegister(java.lang.Runnable action)'
    // Allows defining what happens from outside when "Registrar Cliente" is pressed.
    // Recommendation:
    // - btnRegister.setOnAction(e -> action.run());

    // TODO: Create method 'setOnCancel(java.lang.Runnable action)'
    // Allows defining what happens from outside when "Cancelar" is pressed.
    // Recommendation:
    // - btnCancel.setOnAction(e -> action.run());

    // -------------------------------------------------------------------------
    // SECTION 5: UI HELPERS
    // -------------------------------------------------------------------------

    // TODO: (Optional) Create method 'resetForm()'
    // Clears fields, combo selection and notes after successful register.

    // TODO: (Optional) Create method 'setLoading(boolean loading)'
    // Disables buttons and inputs while submitting.
}
