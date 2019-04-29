package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();


        try{

            System.out.println("Creating new student object...");

            Student student1 = new Student("Ilya","Zhilka","paul@luv2code.com");
            Student student2 = new Student("Oleg","Zhilka","paul@luv2code.com");
            Student student3 = new Student("Vlad","Zhilka","paul@luv2code.com");
            session.beginTransaction();

            System.out.println("Saving the student...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
