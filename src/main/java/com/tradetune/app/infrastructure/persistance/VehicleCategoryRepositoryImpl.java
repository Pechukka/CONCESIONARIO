package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.VehicleCategoryRepository;
import org.hibernate.Session;

public class VehicleCategoryRepositoryImpl extends CommonRepositoryImpl implements VehicleCategoryRepository {
    protected VehicleCategoryRepositoryImpl(Session session) {
        super(session);
    }
}