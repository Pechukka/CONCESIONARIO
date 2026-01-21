package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.ManagerRepository;
import org.hibernate.Session;

public class ManagerRepositoryImpl extends CommonRepositoryImpl implements ManagerRepository {
    protected ManagerRepositoryImpl(Session session) {
        super(session);
    }
}