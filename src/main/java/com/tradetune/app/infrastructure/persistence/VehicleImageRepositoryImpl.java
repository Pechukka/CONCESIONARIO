package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.model.VehicleImage;
import com.tradetune.app.domain.repository.VehicleImageRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class VehicleImageRepositoryImpl extends CommonRepositoryImpl<VehicleImage, Integer> implements VehicleImageRepository {

    public VehicleImageRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public List<VehicleImage> findByVehicleId(Integer vehicleId) {
        // CORRECTO: Usamos "vi.vehicle.id"
        String hql = "FROM VehicleImage vi WHERE vi.vehicle.id = :vid";

        Query<VehicleImage> query = session.createQuery(hql, VehicleImage.class);
        query.setParameter("vid", vehicleId);
        return query.list();
    }
}