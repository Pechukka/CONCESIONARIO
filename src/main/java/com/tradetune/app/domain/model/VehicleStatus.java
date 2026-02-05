package com.tradetune.app.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Catalog of vehicle statuses.
 */
@Entity
@Table(name = "vehicle_status")
public class VehicleStatus {
    @Id
    @Column(name = "id_vehicle_status", nullable = false)
    private Short id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    public VehicleStatus(Short id, String name) {
        this.id = id;
        this.name = name;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}