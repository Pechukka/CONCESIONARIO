package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.VehicleCategory;
import com.tradetune.app.domain.repository.VehicleCategoryRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the VehicleCategory repository.
 */
public class VehicleCategoryRepositoryImpl extends CommonRepositoryImpl<VehicleCategory, Integer>
        implements VehicleCategoryRepository {
    protected VehicleCategoryRepositoryImpl(Session session) {
        super(session);
    }
}