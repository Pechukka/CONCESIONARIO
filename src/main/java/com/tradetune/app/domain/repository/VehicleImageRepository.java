package com.tradetune.app.domain.repository;

import com.tradetune.app.domain.model.VehicleImage;
import java.util.List;

public interface VehicleImageRepository extends CommonRepository<VehicleImage, Integer> {

    // Nuevo método para obtener la lista de fotos
    List<VehicleImage> findByVehicleId(Integer vehicleId);
}