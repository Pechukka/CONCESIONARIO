package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.Proposal;
import com.tradetune.app.domain.repository.ProposalRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the Proposal repository.
 */
public class ProposalRepositoryImpl extends CommonRepositoryImpl<Proposal, Integer> implements ProposalRepository {
    protected ProposalRepositoryImpl(Session session) {
        super(session);
    }
}