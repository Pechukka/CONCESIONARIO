package com.tradetune.app.service;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.model.VehicleImage;
import java.util.List;

// Hereda las operaciones CRUD básicas y añade la específica de imágenes
public interface VehicleService extends CommonService<Vehicle, Integer> {

    List<VehicleImage> getVehicleImages(Integer vehicleId);
}