package com.sunglowsys.allCurd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TestFindByPagination {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.all.curd.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Customer customer = new Customer();
        Query q1 = session.createQuery("from Customer");

        //implement pagination
        q1.setFirstResult(0);
        q1.setMaxResults(8);

       List<Customer> list = q1.list();
       for(Customer cus :list) {
           System.out.println(cus.getId()+" : "+cus.getName()+" : "+ cus.getAge()+" : "+cus.getGender());

       }
       session.close();
       factory.close();
    }
}
