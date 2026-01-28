package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent; // Necesario para el TODO del evento

public class LoginController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Button btnLogin;
    @FXML private PasswordField pwdPassword;
    @FXML private TextField txtEmail;

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Configurar estado inicial (foco en email, botón deshabilitado si aplica, etc.).
        // Llamar a requestInitialFocus().
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: EVENTOS E INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'onLoginAction(ActionEvent event)'
    // Gestiona el evento de pulsación del botón de login.
    // 1. Llamar a validateForm().
    // 2. Si es válido, deshabilitar botón (disableLoginButton(true)) y mostrar spinner (opcional).
    // 3. Llamar al servicio de autenticación.
    // 4. Gestionar respuesta (éxito -> cambio de pantalla, error -> showValidationError).

    // -------------------------------------------------------------------------
    // SECCIÓN 2: VALIDACIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'validateForm()' (Return boolean)
    // Valida que los campos contengan datos correctos.
    // Debe usar isEmailEmpty() e isPasswordEmpty().

    // TODO: Crear método 'isEmailEmpty()' (Return boolean)
    // Comprueba si el campo txtEmail está vacío o nulo.

    // TODO: Crear método 'isPasswordEmpty()' (Return boolean)
    // Comprueba si el campo pwdPassword está vacío.

    // -------------------------------------------------------------------------
    // SECCIÓN 3: GESTIÓN DE LA UI (FEEDBACK)
    // -------------------------------------------------------------------------

    // TODO: Crear método 'showValidationError(String message)'
    // Muestra en la interfaz un mensaje de error (label oculto o alerta) cuando el login falla.

    // TODO: Crear método 'clearValidationErrors()'
    // Limpia cualquier mensaje de error visible y resetea bordes rojos si los hubiera.

    // TODO: Crear método 'disableLoginButton(boolean disable)'
    // Habilita o deshabilita el btnLogin visualmente (setDisable) durante el proceso de carga.

    // TODO: Crear método 'updateUiAfterLoginAttempt(boolean success)'
    // Actualiza la interfaz tras el intento. Si falló, reactiva el botón y limpia campos si es necesario.

    // TODO: Crear método 'requestInitialFocus()'
    // Pone el foco del teclado en el campo txtEmail (txtEmail.requestFocus()).
}