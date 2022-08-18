package com.sunglowsys.allCurd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestDeleteData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.all.curd.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Customer c = new Customer();
        Query q1 =session.createQuery("delete from  Customer  customer where customer.age=:x and customer.gender=:y ");
        q1.setParameter("x",12);
        q1.setParameter("y","male");
         int n =q1.executeUpdate();
        System.out.println("deleted");
        System.out.println(n);

        tx.commit();
        session.close();
        factory.close();

    }
}
