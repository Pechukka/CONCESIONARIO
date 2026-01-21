package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.OfferRepository;
import org.hibernate.Session;

public class OfferRepositoryImpl extends CommonRepositoryImpl implements OfferRepository {
    protected OfferRepositoryImpl(Session session) {
        super(session);
    }
}