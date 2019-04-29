package OneToOneAnnotation.OneToOneStudent;

import OneToOneAnnotation.Instructor;
import OneToOneAnnotation.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

    try {
        session.beginTransaction();

        int InstructoeId = 1;

        Instructor instructor = session.get(Instructor.class,InstructoeId);

        if (instructor != null){

            session.delete(instructor);
        }

        session.getTransaction().commit();
        System.out.println("Done!!!");
    }finally {
        sessionFactory.close();
    }

    }

}
