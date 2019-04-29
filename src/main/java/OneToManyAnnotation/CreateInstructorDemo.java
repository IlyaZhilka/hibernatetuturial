package OneToManyAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
            int theId = 1;

            Instructor instructor = session.get(Instructor.class,theId);

            Course course1 = new Course("Air gitar");
            Course course2 = new Course("Fishing");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();

            System.out.println("Done!!!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }

}
