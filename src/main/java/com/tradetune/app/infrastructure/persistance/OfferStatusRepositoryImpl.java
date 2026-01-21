package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.OfferStatusRepository;
import org.hibernate.Session;

public class OfferStatusRepositoryImpl extends CommonRepositoryImpl implements OfferStatusRepository {
    protected OfferStatusRepositoryImpl(Session session) {
        super(session);
    }
}