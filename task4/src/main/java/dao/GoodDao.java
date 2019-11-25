package dao;

import entity.Good;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class GoodDao {
    private EntityManager entityManager;

    public GoodDao(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void save(Good good) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(good);
        transaction.commit();
    }

    public Good read(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Good good = entityManager.find(Good.class, id);
        transaction.commit();
        return good;
    }


    public List<Good> readAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        List goods = entityManager.createQuery("FROM Good").getResultList();
        transaction.commit();
        return goods;
    }

    public void delete(Good good) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(good);
        transaction.commit();
    }
}
