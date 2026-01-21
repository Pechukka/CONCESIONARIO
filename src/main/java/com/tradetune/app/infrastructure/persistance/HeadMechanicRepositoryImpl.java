package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.HeadMechanicRepository;
import org.hibernate.Session;

public class HeadMechanicRepositoryImpl extends CommonRepositoryImpl implements HeadMechanicRepository {
    protected HeadMechanicRepositoryImpl(Session session) {
        super(session);
    }
}