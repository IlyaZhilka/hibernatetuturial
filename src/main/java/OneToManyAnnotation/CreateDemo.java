package OneToManyAnnotation;

import OneToManyAnnotation.Course;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Instructor tempInstructor = new Instructor("Kirill", "Truff", "oleg.truff@yandex.ru");

            InstructorDetail tempInstructoeDetails = new InstructorDetail("Trugg.channel", "running");

            tempInstructor.setInstructorDetail(tempInstructoeDetails);



            session.beginTransaction();


            session.save(tempInstructor);
            //  System.out.println("tempInstructor"+tempInstructor);
            //session.save(tempInstructor);

            session.getTransaction().commit();


            System.out.println("Done!!!");
        }finally {
            session.close();

            sessionFactory.close();
    }

    }

}
