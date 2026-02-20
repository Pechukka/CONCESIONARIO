package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.Worker;
import com.tradetune.app.domain.repository.WorkerRepository;
import org.hibernate.Session;

import java.util.Optional;

/**
 * Hibernate implementation of the Worker repository.
 */
public class WorkerRepositoryImpl extends CommonRepositoryImpl<Worker, Integer> implements WorkerRepository {
    public WorkerRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Optional<Worker> findByEmail(String email) {
        if (email == null) return Optional.empty();
        String normalized = email.trim().toLowerCase();

        return session.createQuery(
                        "select w from Worker w where lower(w.email) = :email",
                        Worker.class
                )
                .setParameter("email", normalized)
                .uniqueResultOptional();
    }
}