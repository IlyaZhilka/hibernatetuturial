package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();


        try{

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").list();

            for (Student student : students){
                System.out.println(student);
            }

            students = session.createQuery("from Student s where s.lastName = 'Duck'").list();

            for (Student studentss : students){
                System.out.println(studentss);
            }

            System.out.println(" ");
            students = session.createQuery("from Student s where s.lastName='Zhilka' OR s.firstName ='Ilya'").list();

            for (Student student : students){
                System.out.println(student);
            }

            System.out.println(" ");

            students = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list();

            for (Student student : students){
                System.out.println(student);
            }

            session.getTransaction().commit();


            System.out.println("Done!");

        }
        finally {
            factory.close();
        }



    }


}
