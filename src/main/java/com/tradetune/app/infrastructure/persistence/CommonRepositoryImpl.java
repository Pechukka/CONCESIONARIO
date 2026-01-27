package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.repository.CommonRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Generic repository implementation using Hibernate 6.x/7.x.
 * Uses standard JPA methods for persistence operations.
 *
 * @param <T>  the entity type
 * @param <ID> the primary key type
 */
public abstract class CommonRepositoryImpl<T, ID> implements CommonRepository<T, ID> {

    private static final Logger logger = LoggerFactory.getLogger(CommonRepositoryImpl.class);

    private final Class<T> entityClass;
    private final String entityName;

    protected Session session;

    /**
     * Constructs a repository and automatically detects the entity type using
     * reflection.
     *
     * @param session the Hibernate session to use for database operations
     */
    @SuppressWarnings("unchecked")
    protected CommonRepositoryImpl(Session session) {
        this.session = session;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.entityName = entityClass.getName();
    }

    public T save(T entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");
        logger.debug("Creating new {}", entityName);

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            logger.debug("{} created successfully with id: {}", entityName, entity);
            return entity;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            logger.error("Error creating {}", entityName, e);
            throw new RuntimeException("Error creating " + entityName + ": " + e.getMessage(), e);
        }
    }

    public Optional<T> findById(ID id) {
        logger.debug("Finding {} with id: {}", entityName, id);

        try {
            T entity = session.find(entityClass, id);
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            logger.error("Error finding {} with id: {}", entityName, id, e);
            throw new RuntimeException("Error finding entity by ID: " + e.getMessage(), e);
        }
    }

    public List<T> findAll() {
        logger.debug("Finding all {}", entityName);

        try {
            String hql = "FROM " + entityName;
            Query<T> query = session.createQuery(hql, entityClass);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Error finding all {}", entityName, e);
            throw new RuntimeException("Error retrieving all entities: " + e.getMessage(), e);
        }
    }

    public T update(T entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");
        logger.debug("Updating {}", entityName);

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            T updatedEntity = session.merge(entity);
            transaction.commit();
            logger.debug("{} updated successfully", entityName);
            return updatedEntity;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            logger.error("Error updating {}", entityName, e);
            throw new RuntimeException("Error updating entity: " + e.getMessage(), e);
        }
    }

    public void delete(T entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");
        logger.debug("Deleting {} entity", entityName);

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
            logger.debug("{} deleted successfully", entityName);
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            logger.error("Error deleting {}", entityName, e);
            throw new RuntimeException("Error deleting entity: " + e.getMessage(), e);
        }
    }

    public boolean deleteById(ID id) {
        logger.debug("Deleting {} with id: {}", entityName, id);

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            T entity = session.find(entityClass, id);
            if (entity == null) {
                transaction.rollback();
                logger.debug("{} with id {} not found for deletion", entityName, id);
                return false;
            }
            session.remove(entity);
            transaction.commit();
            logger.debug("{} with id {} deleted successfully", entityName, id);
            return true;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            logger.error("Error deleting {} with id: {}", entityName, id, e);
            throw new RuntimeException("Error deleting " + entityName + " by id", e);
        }
    }

}