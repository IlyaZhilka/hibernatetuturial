package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();


        try{

            System.out.println("Creating new student object...");
            Student student = new Student("Daaffyy","Duck","paul@luv2code.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            System.out.println(student);
            session.save(student);

            session.getTransaction().commit();


            System.out.println("Done!");

        }
        finally {
            factory.close();
        }



    }

}
