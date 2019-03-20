package hibernate.main;

import hibernate.entity.Student;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class CreateStudent {
    public static void main(String[] args) {
        String firstName = "sona";
        String lastName = "sona 2";
        String email = "sona@gmail.commm";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = new Student(firstName, lastName, email);
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
