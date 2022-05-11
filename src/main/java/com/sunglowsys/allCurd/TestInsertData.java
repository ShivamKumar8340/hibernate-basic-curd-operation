package com.sunglowsys.allCurd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestInsertData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.all.curd.cfg.xml").buildSessionFactory();

        Customer customer = new Customer("kaushal",14,"male");
        Customer customer1 = new Customer("mohit",15,"male");
        Customer customer2 = new Customer("ankit",39,"male");
        Customer customer3 = new Customer("neelesh",38,"male");
        Customer customer4 = new Customer("suraj",32,"male");
        Customer customer5 = new Customer("guddu",16,"male");
        Customer customer6 = new Customer("kanhaiya",12,"male");

        Session  session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        session.save(customer1);
        session.save(customer2);
        session.save(customer3);
        session.save(customer4);
        session.save(customer5);
        session.save(customer6);
        tx.commit();
        session.close();
        factory.close();


    }
}
