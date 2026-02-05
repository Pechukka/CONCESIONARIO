package com.tradetune.app.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite primary key for the RepairMaterial entity.
 */
@Embeddable
public class RepairMaterialId implements Serializable {
    private static final long serialVersionUID = 7133949969328264321L;
    @Column(name = "id_repair", nullable = false)
    private Integer idRepair;

    @Column(name = "id_material", nullable = false)
    private Integer idMaterial;

    public RepairMaterialId(Integer idRepair, Integer idMaterial) {
        this.idRepair = idRepair;
        this.idMaterial = idMaterial;
    }

    public Integer getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(Integer idRepair) {
        this.idRepair = idRepair;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RepairMaterialId entity = (RepairMaterialId) o;
        return Objects.equals(this.idRepair, entity.idRepair) &&
                Objects.equals(this.idMaterial, entity.idMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRepair, idMaterial);
    }
}