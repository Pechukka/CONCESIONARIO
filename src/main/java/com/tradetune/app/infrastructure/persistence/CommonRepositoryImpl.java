package com.tradetune.app.infrastructure.persistence;

import com.tradetune.app.domain.repository.CommonRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class CommonRepositoryImpl<T, ID> implements CommonRepository<T, ID> {

    private static final Logger logger = LoggerFactory.getLogger(CommonRepositoryImpl.class);

    private final Class<T> entityClass;
    private final String entityName;

    protected Session session;

    @SuppressWarnings("unchecked")
    protected CommonRepositoryImpl(Session session) {
        this.session = session;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.entityName = entityClass.getName();
    }

    // --- CRUD SIN TRANSACCIONES (La sesión viene abierta desde el Servicio) ---

    @Override
    public T save(T entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");
        // Solo persistimos. El commit lo hará el servicio.
        session.persist(entity);
        logger.debug("{} persisted (pending commit)", entityName);
        return entity;
    }

    @Override
    public T update(T entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");
        T updated = session.merge(entity);
        logger.debug("{} merged (pending commit)", entityName);
        return updated;
    }

    @Override
    public void delete(T entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");
        session.remove(entity);
        logger.debug("{} removed (pending commit)", entityName);
    }

    @Override
    public boolean deleteById(ID id) {
        T entity = session.find(entityClass, id);
        if (entity == null) {
            return false;
        }
        session.remove(entity);
        return true;
    }

    @Override
    public Optional<T> findById(ID id) {
        T entity = session.find(entityClass, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public List<T> findAll() {
        String hql = "FROM " + entityName;
        Query<T> query = session.createQuery(hql, entityClass);
        return query.getResultList();
    }
}