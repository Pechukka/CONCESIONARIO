package com.tradetune.app.domain.repository;

import com.tradetune.app.domain.model.Worker;

import java.util.Optional;

/**
 * Repository for Worker entity persistence operations.
 */
public interface WorkerRepository extends CommonRepository<Worker, Integer> {
    Optional<Worker> findByEmail(String email);
}