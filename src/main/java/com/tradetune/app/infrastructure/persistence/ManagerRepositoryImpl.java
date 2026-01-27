package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.Manager;
import com.tradetune.app.domain.repository.ManagerRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the Manager repository.
 */
public class ManagerRepositoryImpl extends CommonRepositoryImpl<Manager, Integer> implements ManagerRepository {
    protected ManagerRepositoryImpl(Session session) {
        super(session);
    }
}