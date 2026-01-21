package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.PaymentMethodRepository;
import org.hibernate.Session;

public class PaymentMethodRepositoryImpl extends CommonRepositoryImpl implements PaymentMethodRepository {
    protected PaymentMethodRepositoryImpl(Session session) {
        super(session);
    }
}