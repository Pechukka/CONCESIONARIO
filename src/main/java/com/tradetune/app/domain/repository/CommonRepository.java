package com.tradetune.app.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio genérico con operaciones CRUD básicas
 *
 * @param <T> Tipo de la entidad
 * @param <ID> Tipo de la clave primaria
 */
public interface CommonRepository<T, ID> {

    /**
     * Guarda una nueva entidad en la base de datos
     *
     * @param entity Entidad a guardar
     */
    void save(T entity);

    /**
     * Busca una entidad por su ID
     *
     * @param id Identificador de la entidad
     * @return Optional con la entidad si existe, vacío si no
     */
    Optional<T> findById(ID id);

    /**
     * Obtiene todas las entidades de la tabla
     *
     * @return Lista con todas las entidades
     */
    List<T> findAll();

    /**
     * Actualiza una entidad existente
     *
     * @param entity Entidad a actualizar
     */
    void update(T entity);

    /**
     * Elimina una entidad de la base de datos
     *
     * @param entity Entidad a eliminar
     */
    void delete(T entity);
}