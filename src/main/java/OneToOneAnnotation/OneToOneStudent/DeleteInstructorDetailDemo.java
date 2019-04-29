package OneToOneAnnotation.OneToOneStudent;

import OneToOneAnnotation.Instructor;
import OneToOneAnnotation.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

    try {
        session.beginTransaction();

        int theId = 2;

        InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);

        System.out.println("tempInstructorDetails"+ instructorDetail);

        System.out.println();
        System.out.println("Instructor"+instructorDetail.getInstructor());

        session.delete(instructorDetail);

        session.getTransaction().commit();
        System.out.println("Done!!!");
    }
    catch (Exception exp){
        exp.printStackTrace();
    }
    finally {

        session.close();
        sessionFactory.close();
    }

    }

}
