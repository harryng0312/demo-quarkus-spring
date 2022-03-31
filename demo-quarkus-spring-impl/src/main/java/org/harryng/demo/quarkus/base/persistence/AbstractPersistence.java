package org.harryng.demo.quarkus.base.persistence;

import io.quarkus.hibernate.orm.PersistenceUnit;
import org.harryng.demo.quarkus.base.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import java.io.Serializable;

public abstract class AbstractPersistence<Id extends Serializable, T extends BaseEntity<Id>>
        implements BasePersistence<Id, T> {

    protected Class<T> entityClass;

    @Autowired
    @PersistenceUnit("primary_pu")
    private EntityManager defaultEntityManager;

    public EntityManager getEntityManager(){
        return defaultEntityManager;
    }

    public T selectById(Id id) throws RuntimeException, Exception {
        return getEntityManager().find(entityClass, id);
    }

    public int insert(T obj) throws RuntimeException, Exception {
        getEntityManager().persist(obj);
        return 1;
    }

    public int update(T obj) throws RuntimeException, Exception {
        getEntityManager().merge(obj);
        return 1;
    }

    public int delete(Id id) throws RuntimeException, Exception {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaDelete<T> criteriaDelete = cb.createCriteriaDelete(entityClass);
        Root<T> root = criteriaDelete.from(entityClass);
        criteriaDelete.where(cb.equal(root.get("id"), id));
        Query query = getEntityManager().createQuery(criteriaDelete);
        return query.executeUpdate();
    }
}
