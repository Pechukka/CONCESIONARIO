package com.tradetune.app.domain.model;

import jakarta.persistence.*;

/**
 * Represents a mechanic role.
 * Extends the base Worker entity and can be assigned to repair work orders.
 */
@Entity
@Table(name = "mechanic")
public class Mechanic {
    @Id
    @Column(name = "id_worker", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_worker", nullable = false)
    private Worker worker;

    public Mechanic(Integer id, Worker worker) {
        this.id = id;
        this.worker = worker;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

}