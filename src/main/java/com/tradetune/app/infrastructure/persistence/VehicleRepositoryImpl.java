package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.repository.VehicleRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class VehicleRepositoryImpl extends CommonRepositoryImpl<Vehicle, Integer> implements VehicleRepository {

    public VehicleRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public List<Vehicle> findAll() {
        String hql = "SELECT DISTINCT v FROM Vehicle v " +
                "JOIN FETCH v.idDealership " +
                "LEFT JOIN FETCH v.images";

        Query<Vehicle> query = session.createQuery(hql, Vehicle.class);
        return query.list();
    }
}