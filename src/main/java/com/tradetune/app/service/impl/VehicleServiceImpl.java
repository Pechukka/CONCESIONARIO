package com.tradetune.app.service.impl;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.model.VehicleImage;
import com.tradetune.app.service.VehicleService;
import java.util.List;
import java.util.Optional;

public class VehicleServiceImpl implements VehicleService {

    @Override
    public List<VehicleImage> getVehicleImages(Integer vehicleId) {
        return List.of();
    }

    @Override
    public List<Vehicle> findAll() {
        return List.of();
    }

    @Override
    public Optional<Vehicle> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void save(Vehicle entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}