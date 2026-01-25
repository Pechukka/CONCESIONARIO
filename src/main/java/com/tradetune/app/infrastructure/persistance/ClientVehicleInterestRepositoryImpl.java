package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.model.ClientVehicleInterest;
import com.tradetune.app.domain.repository.ClientVehicleInterestRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the ClientVehicleInterest repository.
 */
public class ClientVehicleInterestRepositoryImpl extends CommonRepositoryImpl<ClientVehicleInterest, Integer>
        implements ClientVehicleInterestRepository {

    protected ClientVehicleInterestRepositoryImpl(Session session) {
        super(session);
    }

}