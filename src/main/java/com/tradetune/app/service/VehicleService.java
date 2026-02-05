package com.tradetune.app.service;

import com.tradetune.app.domain.model.Vehicle;
import com.tradetune.app.domain.model.VehicleImage;

import java.util.List;

// Hereda el CRUD básico para Vehículos y añade métodos específicos
public interface VehicleService extends CommonService<Vehicle, Integer> {

    // El método específico que necesitamos para la galería
    List<VehicleImage> getVehicleImages(Integer vehicleId);
}