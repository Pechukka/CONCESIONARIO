package com.tradetune.app.service.impl;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.model.VehicleImage;
import com.tradetune.app.domain.repository.CommonRepository;
import com.tradetune.app.infrastructure.persistence.VehicleImageRepositoryImpl;
import com.tradetune.app.infrastructure.persistence.VehicleRepositoryImpl;
import com.tradetune.app.service.VehicleService;
import com.tradetune.app.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

// Heredamos de BaseServiceImpl para tener el CRUD gratis
public class VehicleServiceImpl extends BaseServiceImpl<Vehicle, Integer> implements VehicleService {

    // 1. Conectamos con el Repositorio Específico
    @Override
    protected CommonRepository<Vehicle, Integer> getRepository(Session session) {
        return new VehicleRepositoryImpl(session);
    }

    // 2. Implementamos solo la lógica extra (Imágenes)
    @Override
    public List<VehicleImage> getVehicleImages(Integer vehicleId) {
        // Abrimos sesión solo lectura (sin transacción porque es select)
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            VehicleImageRepositoryImpl imgRepo = new VehicleImageRepositoryImpl(session);
            return imgRepo.findByVehicleId(vehicleId);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}