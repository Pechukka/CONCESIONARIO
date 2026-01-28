package com.tradetune.app.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class HeaderController {

    // -------------------------------------------------------------------------
    // ELEMENTOS FXML
    // -------------------------------------------------------------------------
    @FXML private Button btnLogOut;
    @FXML private Label email;   // Label para mostrar el correo del usuario
    @FXML private Label section; // Label para el título de la sección (ej: "VENTAS")

    // -------------------------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------------------------
    @FXML
    public void initialize() {
        // TODO: Inicialización básica si fuera necesaria (ej. limpiar textos por defecto).
    }

    // -------------------------------------------------------------------------
    // SECCIÓN 1: INYECCIÓN DE DATOS (API PÚBLICA)
    // -------------------------------------------------------------------------

    // TODO: Crear método 'setSection(String sectionText)'
    // Recibe el nombre de la sección actual y actualiza el label 'section'.

    // TODO: Crear método 'setEmail(String emailText)'
    // Recibe el email del usuario autenticado y actualiza el label 'email'.

    // TODO: Crear método 'updateHeaderData(String sectionText, String emailText)'
    // Método de utilidad para actualizar ambos campos a la vez.
    // Llama a setSection() y setEmail() internamente.

    // -------------------------------------------------------------------------
    // SECCIÓN 2: GESTIÓN DE ESTADO VISUAL
    // -------------------------------------------------------------------------

    // TODO: Crear método 'clearHeader()'
    // Limpia los datos visibles (pone los labels vacíos) al cerrar sesión o cambiar contexto.

    // TODO: Crear método 'disableLogoutButton(boolean disable)'
    // Permite bloquear el botón de cerrar sesión si hay una operación crítica en curso.

    // TODO: Crear método 'applyHeaderState()'
    // Aplica ajustes visuales finales o refresco de componentes si fuera necesario tras recibir datos.

    // -------------------------------------------------------------------------
    // SECCIÓN 3: INTERACCIÓN
    // -------------------------------------------------------------------------

    // TODO: Crear método 'onLogoutAction(ActionEvent event)'
    // Gestiona el clic en 'btnLogOut'.
    // 1. Confirmar intención (opcional).
    // 2. Llamar al servicio de cierre de sesión.
    // 3. Navegar de vuelta a la pantalla de Login.
}