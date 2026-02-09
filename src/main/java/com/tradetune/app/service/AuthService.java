package com.tradetune.app.service;

import com.tradetune.app.domain.model.Worker;
import java.util.Optional;

public interface AuthService {
    Optional<Worker> authenticate(String email, String password);
    String determineRole(Worker worker);
}