package com.tradetune.app.service;

import com.tradetune.app.domain.model.Worker;
import java.util.Optional;

public interface AuthService {
    // Este servicio no necesita el CRUD completo de CommonService,
    // solo un método específico para el login.

    /**
     * Busca un trabajador por su email y devuelve el objeto Worker si existe,
     * junto con su rol determinado.
     */
    Optional<Worker> authenticate(String email, String password);

    String determineRole(Worker worker);
}