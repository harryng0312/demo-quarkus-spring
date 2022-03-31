package org.harryng.demo.quarkus.base.persistence;

import org.harryng.demo.quarkus.base.entity.BaseEntity;

import java.io.Serializable;

public abstract class AbstractPersistence<Id extends Serializable, T extends BaseEntity<Id>>
        extends BasePersistence<Id, T> {
//    @Autowired
//    @Qualifier("entityManagerFactory")
    @PersistenceUnit(name = "primary_pu")
    private EntityManager defaultEntityManager;
    public EntityManager getEntityManager(){
        return defaultEntityManager;
    }

    public T selectById(Id id) throws RuntimeException, Exception {
        return getEntityManager().find(entityClass, id);
    }

    @Throws(RuntimeException::class, Exception::class) public int insert(T obj: T): Int {
        entityManager.persist(obj)
        return 1
    }

    @Throws(RuntimeException::class, Exception::class)
    override fun update(obj: T): Int {
        entityManager.merge(obj)
        return 1
    }

    @Throws(RuntimeException::class, Exception::class)
    override fun delete(id: Id): Int {
        val cb = entityManager.criteriaBuilder
        val criteriaDelete = cb.createCriteriaDelete(entityClass)
        val root = criteriaDelete.from(entityClass)
        criteriaDelete.where(cb.equal(root.get<Any>("id"), id))
        val query = entityManager.createQuery(criteriaDelete)
        return query.executeUpdate()
    }
}
