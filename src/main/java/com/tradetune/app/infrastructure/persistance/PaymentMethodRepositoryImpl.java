package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.model.PaymentMethod;
import com.tradetune.app.domain.repository.PaymentMethodRepository;
import org.hibernate.Session;

/**
 * Hibernate implementation of the PaymentMethod repository.
 */
public class PaymentMethodRepositoryImpl extends CommonRepositoryImpl<PaymentMethod, Integer>
        implements PaymentMethodRepository {
    protected PaymentMethodRepositoryImpl(Session session) {
        super(session);
    }
}