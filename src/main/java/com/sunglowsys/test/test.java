package com.sunglowsys.test;

import com.sunglowsys.domain.AddrressAndImage;
import com.sunglowsys.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class test {
    public static void main(String[] args) throws IOException {
        System.out.println("started");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());

        //create student object
        Student student = new Student();
        student.setId(102L);
        student.setFirstName("Ravi");
        student.setLastName("kumar");

        //create AddresssAndImage object
        AddrressAndImage ai =new AddrressAndImage();
        ai.setStreet("husainpur");
        ai.setCity("Etah");
        ai.setOpen(true);
        ai.setDate(new Date());
        ai.setX("hey");

        //setting image
        FileInputStream inputStream = new FileInputStream("src/main/java/com/sunglowsys/domain/image.png");
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        ai.setImage(data);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ai);
        session.save(student);
        transaction.commit();
        System.out.println("inserted both record");
        session.close();
    }
}
