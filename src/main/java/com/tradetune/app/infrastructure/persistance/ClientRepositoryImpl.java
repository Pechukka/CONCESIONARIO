package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.model.Client;
import com.tradetune.app.domain.repository.ClientRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the Client repository.
 */
public class ClientRepositoryImpl extends CommonRepositoryImpl<Client, Integer> implements ClientRepository {
    public ClientRepositoryImpl(Session session) {
        super(session);
    }
}
