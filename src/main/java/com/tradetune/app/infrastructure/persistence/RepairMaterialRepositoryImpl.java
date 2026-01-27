package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.RepairMaterial;
import com.tradetune.app.domain.model.RepairMaterialId;
import com.tradetune.app.domain.repository.RepairMaterialRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the RepairMaterial repository.
 */
public class RepairMaterialRepositoryImpl extends CommonRepositoryImpl<RepairMaterial, RepairMaterialId>
        implements RepairMaterialRepository {
    protected RepairMaterialRepositoryImpl(Session session) {
        super(session);
    }
}