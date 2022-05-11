package com.sunglowsys.test;

import com.sunglowsys.embaddeableE.AddressEmp;
import com.sunglowsys.embaddeableE.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEmployee {
    public static void main(String[] args) {
        System.out.println("started");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.emp.xml").buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());

        Employee employee = new Employee();
        employee.setFirstname("baby");
        employee.setLastName("kumari");

        AddressEmp addEmp = new AddressEmp();
        addEmp.setStreet("nagla man singh");
        addEmp.setCity("Etah");

        employee.setAdd(addEmp);

        Session  session= factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        System.out.println("record inserted ");
        transaction.commit();

        session.close();

    }
}
