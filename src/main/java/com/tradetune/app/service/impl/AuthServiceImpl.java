package com.tradetune.app.service.impl;

import com.tradetune.app.domain.model.Worker;
import com.tradetune.app.service.AuthService;
import java.util.Optional;

public class AuthServiceImpl implements AuthService {

    @Override
    public Optional<Worker> authenticate(String email, String password) {
        // TODO: Implementar lógica de login
        return Optional.empty();
    }

    @Override
    public String determineRole(Worker worker) {
        // TODO: Implementar lógica de roles
        return "UNKNOWN";
    }
}