package main;

import dao.CustomerDao;
import dao.GoodDao;
import entity.Customer;
import entity.Good;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;

public class MySqlConnection {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entity");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CustomerDao customerDao = new CustomerDao(entityManager);

        Customer customer1 = new Customer("Вова");
        Customer customer2 = new Customer("Вася");
        customerDao.save(customer1);
        customerDao.save(customer2);
        System.out.println(customerDao.readAll());
        System.out.println();

        GoodDao goodDao = new GoodDao(entityManager);
        Good good1 = new Good("Bread", 55.55);
        Good good2 = new Good("Milk", 77.77);
        Good good3 = new Good("Meat", 444.44);
        goodDao.save(good1);
        goodDao.save(good2);
        goodDao.save(good3);
        System.out.println(goodDao.readAll());
        System.out.println();

        customer1.setGoods(new ArrayList<>(Arrays.asList(good1, good2)));
        customer2.setGoods(new ArrayList<>(Arrays.asList(good2, good3)));
        System.out.println(customerDao.readAll());
        System.out.println();

        customerDao.delete(customer1);
        System.out.println(customerDao.readAll());
    }
}
