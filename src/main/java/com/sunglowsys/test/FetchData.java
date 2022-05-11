package com.sunglowsys.test;

import com.sunglowsys.domain.AddrressAndImage;
import com.sunglowsys.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {
        Configuration confg = new Configuration();
        confg.configure("hibernate.cfg.xml");
        SessionFactory factory = confg.buildSessionFactory();
        Session session = factory.openSession();

        //get data
        //we can find By get
        //Student student = session.get(Student.class,102L);
        //or we can find by load
        Student student = session.load(Student.class,102L);
        System.out.println(student);

        AddrressAndImage ai = session.get(AddrressAndImage.class,1L);
        System.out.println(ai.getCity() + " :"+ ai.getStreet());
        session.close();
        factory.close();

    }
}
