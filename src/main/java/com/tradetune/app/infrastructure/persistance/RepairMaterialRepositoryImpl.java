package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.RepairMaterialRepository;
import org.hibernate.Session;

public class RepairMaterialRepositoryImpl extends CommonRepositoryImpl implements RepairMaterialRepository {
    protected RepairMaterialRepositoryImpl(Session session) {
        super(session);
    }
}