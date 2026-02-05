package com.tradetune.app.domain.model;

import jakarta.persistence.*;

/**
 * Represents a dealership manager role.
 * Extends the base Worker entity through table-per-type inheritance.
 */
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "id_worker", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_worker", nullable = false)
    private Worker worker;

    public Manager(Integer id, Worker worker) {
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