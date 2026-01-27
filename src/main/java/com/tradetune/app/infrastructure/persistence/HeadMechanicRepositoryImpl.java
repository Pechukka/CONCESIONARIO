package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.HeadMechanic;
import com.tradetune.app.domain.repository.HeadMechanicRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the HeadMechanic repository.
 */
public class HeadMechanicRepositoryImpl extends CommonRepositoryImpl<HeadMechanic, Integer>
        implements HeadMechanicRepository {
    protected HeadMechanicRepositoryImpl(Session session) {
        super(session);
    }
}