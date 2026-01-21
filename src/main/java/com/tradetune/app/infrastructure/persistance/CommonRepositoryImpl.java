package com.tradetune.app.infrastructure.persistance;

import com.tradetune.app.domain.repository.CommonRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * Implementación genérica del repositorio con Hibernate 6.x/7.x
 * Usa métodos JPA estándar
 *
 * @param <T> Tipo de la entidad
 * @param <ID> Tipo de la clave primaria
 */
public abstract class CommonRepositoryImpl<T, ID> implements CommonRepository<T, ID> {

    /** Clase de la entidad (se obtiene automáticamente) */
    private final Class<T> entityClass;

    /** Sesión de Hibernate */
    protected Session session;

    /**
     * Constructor que detecta automáticamente el tipo de entidad
     *
     * @param session Sesión de Hibernate
     */
    @SuppressWarnings("unchecked")
    protected CommonRepositoryImpl(Session session) {
        this.session = session;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    /**
     * INSERT - Guarda una nueva entidad usando session.persist()
     */
    @Override
    public void save(T entity) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(entity);  // ← persist() en lugar de save()
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al guardar la entidad: " + e.getMessage(), e);
        }
    }

    /**
     * SELECT - Busca una entidad por ID usando session.find()
     */
    @Override
    public Optional<T> findById(ID id) {
        try {
            T entity = session.find(entityClass, id);  // ← find() en lugar de get()
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar entidad por ID: " + e.getMessage(), e);
        }
    }

    /**
     * SELECT ALL - Obtiene todas las entidades
     */
    @Override
    public List<T> findAll() {
        try {
            String hql = "FROM " + entityClass.getSimpleName();
            Query<T> query = session.createQuery(hql, entityClass);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las entidades: " + e.getMessage(), e);
        }
    }

    /**
     * UPDATE - Actualiza una entidad usando session.merge()
     */
    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(entity);  // ← merge() en lugar de update()
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al actualizar la entidad: " + e.getMessage(), e);
        }
    }

    /**
     * DELETE - Elimina una entidad usando session.remove()
     */
    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(entity);  // ← remove() en lugar de delete()
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al eliminar la entidad: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene la clase de la entidad
     *
     * @return Clase de la entidad
     */
    protected Class<T> getEntityClass() {
        return entityClass;
    }
}