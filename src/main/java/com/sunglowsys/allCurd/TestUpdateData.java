package com.sunglowsys.allCurd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestUpdateData {
    public static void main(String[] args) {
        SessionFactory  factory = new Configuration().configure("hibernate.all.curd.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Customer c = new Customer();
        Query q1= session.createQuery("update Customer set name=:x  where id=:y");
        q1.setParameter("x","shivam Kashyap");
        q1.setParameter("y",1);
        int n =  q1.executeUpdate();

        System.out.println("updated");
        System.out.println(n);
        tx.commit();
        session.close();
        factory.close();

    }
}
