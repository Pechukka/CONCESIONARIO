package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.RepairStatusRepository;
import org.hibernate.Session;

public class RepairStatusRepositoryImpl extends CommonRepositoryImpl implements RepairStatusRepository {
    protected RepairStatusRepositoryImpl(Session session) {
        super(session);
    }
}