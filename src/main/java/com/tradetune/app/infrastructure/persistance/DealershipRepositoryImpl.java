package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.DealershipRepository;
import org.hibernate.Session;

public class DealershipRepositoryImpl extends CommonRepositoryImpl implements DealershipRepository {
    protected DealershipRepositoryImpl(Session session) {
        super(session);
    }
}