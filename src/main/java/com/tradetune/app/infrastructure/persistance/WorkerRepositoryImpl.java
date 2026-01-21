package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.WorkerRepository;
import org.hibernate.Session;

public class WorkerRepositoryImpl extends CommonRepositoryImpl implements WorkerRepository {
    protected WorkerRepositoryImpl(Session session) {
        super(session);
    }
}