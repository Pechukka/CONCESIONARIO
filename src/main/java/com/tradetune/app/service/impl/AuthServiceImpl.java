package com.tradetune.app.service.impl;

import com.tradetune.app.domain.model.Worker;
import com.tradetune.app.domain.repository.WorkerRepository;
import com.tradetune.app.infrastructure.persistence.WorkerRepositoryImpl;
import com.tradetune.app.service.AuthService;
import com.tradetune.app.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {

    @Override
    public Optional<Worker> authenticate(String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return Optional.empty();
        }

        String normalizedEmail = email.trim().toLowerCase();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) { // adapta a tu util real
            WorkerRepository repo = new WorkerRepositoryImpl(session);

            Optional<Worker> opt = repo.findByEmail(normalizedEmail);
            if (opt.isEmpty()) return Optional.empty();

            Worker w = opt.get();

            // Si tienes campo active
            Byte active = w.getActive();
            if (active == null || active == 0) return Optional.empty();

            // Verificación password (RECOMENDADO)
            // return BCrypt.checkpw(password, w.getPasswordHash()) ? Optional.of(w) : Optional.empty();

            // Temporal si aún NO tienes bcrypt en BD (NO recomendado)
            return password.equals(w.getPasswordHash()) ? Optional.of(w) : Optional.empty();
        }
    }

    @Override
    public String determineRole(Worker worker) {
        // TODO: Implementar lógica de roles
        return "UNKNOWN";
    }
}