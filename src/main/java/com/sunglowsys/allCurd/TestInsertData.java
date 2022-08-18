package com.sunglowsys.allCurd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TestInsertData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.all.curd.cfg.xml").buildSessionFactory();

       /* Customer customer = new Customer("kaushal",14,"male");
        Customer customer1 = new Customer("mohit",15,"male");
        Customer customer2 = new Customer("ankit",39,"male");
        Customer customer3 = new Customer("neelesh",38,"male");
        Customer customer4 = new Customer("suraj",32,"male");
        Customer customer5 = new Customer("guddu",16,"male");
        Customer customer6 = new Customer("kanhaiya",12,"male");*/

        // insert data by Json
        // using json-simple  this is an old way
        // popular way is using jackson library
        JSONParser parser = new JSONParser();
        try {
            // read file
            File file = new File("E:\\jsonAndJavaConversion\\customer.json");
            System.out.println("successFully Read=======================================");

            // convert json file into java object
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("name");
            Long age = (Long) jsonObject.get("age");
            String gender = (String) jsonObject.get("gender");

            // save java object
            System.out.println(name+":"+":"+age+":"+gender);
            Customer customer = new Customer();
            customer.setName(name);
            customer.setAge(age);
            customer.setGender(gender);



            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            session.close();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

       /* Session  session = factory.openSession();
        Transaction tx = session.beginTransaction();*/
       /* session.save(customer);
        session.save(customer1);
        session.save(customer2);
        session.save(customer3);
        session.save(customer4);
        session.save(customer5);
        session.save(customer6);*/
       /* tx.commit();
        session.close();*/
        //factory.close();


    }
}
