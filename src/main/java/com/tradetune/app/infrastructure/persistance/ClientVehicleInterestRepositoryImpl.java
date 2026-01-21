package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.ClientVehicleInterestRepository;
import org.hibernate.Session;

public class ClientVehicleInterestRepositoryImpl extends CommonRepositoryImpl implements ClientVehicleInterestRepository {

    protected ClientVehicleInterestRepositoryImpl(Session session) {
        super(session);
    }

}