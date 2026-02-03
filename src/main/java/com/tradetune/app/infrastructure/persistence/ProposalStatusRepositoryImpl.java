package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.ProposalStatus;
import com.tradetune.app.domain.repository.ProposalStatusRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the ProposalStatus repository.
 */
public class ProposalStatusRepositoryImpl extends CommonRepositoryImpl<ProposalStatus, Integer>
        implements ProposalStatusRepository {
    protected ProposalStatusRepositoryImpl(Session session) {
        super(session);
    }
}