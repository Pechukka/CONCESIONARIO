package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.model.MaterialType;
import com.tradetune.app.domain.repository.MaterialTypeRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the MaterialType repository.
 */
public class MaterialTypeRepositoryImpl extends CommonRepositoryImpl<MaterialType, Integer>
        implements MaterialTypeRepository {
    protected MaterialTypeRepositoryImpl(Session session) {
        super(session);
    }
}