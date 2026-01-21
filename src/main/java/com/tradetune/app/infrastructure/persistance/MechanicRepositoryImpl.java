package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.MechanicRepository;
import org.hibernate.Session;

public class MechanicRepositoryImpl extends CommonRepositoryImpl implements MechanicRepository {
    protected MechanicRepositoryImpl(Session session) {
        super(session);
    }
}