package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent; // Required for the TODO event

/**
 * Controller for the login screen.
 * Handles user authentication, form validation, and UI feedback.
 */
public class LoginController {

    // -------------------------------------------------------------------------
    // FXML ELEMENTS
    // -------------------------------------------------------------------------
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private TextField txtEmail;

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configure initial state (focus on email, disable button if applicable,
        // etc.).
        // Call requestInitialFocus().
    }

    // -------------------------------------------------------------------------
    // SECTION 1: EVENTS AND INTERACTION
    // -------------------------------------------------------------------------

    // TODO: Create method 'onLoginAction(ActionEvent event)'
    // Handles the login button press event.
    // 1. Call validateForm().
    // 2. If valid, disable button (disableLoginButton(true)) and show spinner
    // (optional).
    // 3. Call authentication service.
    // 4. Handle response (success -> screen change, error -> showValidationError).

    // -------------------------------------------------------------------------
    // SECTION 2: VALIDATION
    // -------------------------------------------------------------------------

    // TODO: Create method 'validateForm()' (Return boolean)
    // Validates that form fields contain correct data.
    // Must use isEmailEmpty() and isPasswordEmpty().

    // TODO: Create method 'isEmailEmpty()' (Return boolean)
    // Checks if the txtEmail field is empty or null.

    // TODO: Create method 'isPasswordEmpty()' (Return boolean)
    // Checks if the pwdPassword field is empty.

    // -------------------------------------------------------------------------
    // SECTION 3: UI MANAGEMENT (FEEDBACK)
    // -------------------------------------------------------------------------

    // TODO: Create method 'showValidationError(String message)'
    // Displays an error message in the UI (hidden label or alert) when login fails.

    // TODO: Create method 'clearValidationErrors()'
    // Clears any visible error messages and resets red borders if present.

    // TODO: Create method 'disableLoginButton(boolean disable)'
    // Enables or disables the btnLogin visually (setDisable) during loading.

    // TODO: Create method 'updateUiAfterLoginAttempt(boolean success)'
    // Updates the UI after login attempt. If failed, reactivates button and clears
    // fields if necessary.

    // TODO: Create method 'requestInitialFocus()'
    // Sets keyboard focus to the txtEmail field (txtEmail.requestFocus()).
}