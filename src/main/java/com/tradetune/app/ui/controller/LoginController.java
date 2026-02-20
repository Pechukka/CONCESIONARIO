package com.tradetune.app.ui.controller;

import com.tradetune.app.domain.model.Worker;
import com.tradetune.app.service.AuthService;
import com.tradetune.app.service.impl.AuthServiceImpl;
import com.tradetune.app.ui.AppState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent; // Required for the TODO event
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

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
    @FXML
    private Label lblError;


    private final AuthService authService = new AuthServiceImpl();

    // -------------------------------------------------------------------------
    // INITIALIZATION
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        txtEmail.requestFocus();
        // TODO: Configure initial state (focus on email, disable button if applicable,
        // etc.).
        // Call requestInitialFocus().
    }

    @FXML
    private void onLoginAction(ActionEvent event) {

        String email = txtEmail.getText();
        String pass = pwdPassword.getText();

        Optional<Worker> opt = authService.authenticate(email, pass);

        if (opt.isPresent()) {
            Worker worker = opt.get();
            AppState.setCurrentWorker(worker);
            goToSalesLayout();
        } else {
            showError("Credenciales incorrectas");
            pwdPassword.clear();
            pwdPassword.requestFocus();
        }
    }

    private void showError(String message) {
        lblError.setText(message);
        lblError.setVisible(true);
    }

    private void clearError() {
        lblError.setText("");
        lblError.setVisible(false);
    }

    @FXML
    private void goToSalesLayout() {
        try {
            URL url = getClass().getResource("/com/tradetune/app/ui/layout/SalesLayout.fxml");
            if (url == null) {
                throw new IllegalStateException("No se encuentra SalesLayout.fxml. Revisa la ruta en resources.");
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    // -------------------------------------------------------------------------
    // SECTION 1: EVENTS AND INTERACTION
    // -------------------------------------------------------------------------

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