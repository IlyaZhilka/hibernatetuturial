package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemoUpdate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();


        try{

            int studentId =1;

            System.out.println("StudentId : "+ studentId);



            session=factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class,studentId);

            myStudent.setFirstName("Shabby");
            System.out.println("Updating student ... ");

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }



    }


}
