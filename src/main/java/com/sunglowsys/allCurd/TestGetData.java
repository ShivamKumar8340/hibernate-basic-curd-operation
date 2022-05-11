package com.sunglowsys.allCurd;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class TestGetData {
    public static void main(String[] args) {
        Customer customer = new Customer();

        SessionFactory  factory =new Configuration().configure("hibernate.all.curd.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
      //  String query = "from Customer where gender=:x";
        String query = "from Customer as customer where customer.gender=:x and customer.age=:y";
       // String query = "from Customer";
        Query q = session.createQuery(query);
        q.setParameter("x","female");
        q.setParameter("y",22);
        List<Customer> list = q.list();
        for (Customer c :list) {
            System.out.println(c.getId()+"       :"+ c.getName()+"    :"+c.getAge()+"        :"+c.getGender());
        }
        session.close();
        factory.close();


    }
}
