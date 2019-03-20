package hibernate.main;

import hibernate.entity.Student;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UpdateStudent {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        query.select(root);
        query.where(builder.equal(root.get("id"), 5));
        Student student = session.createQuery(query).uniqueResult();
        session.evict(student);
        student.setFirstName("sona");
        student.setEmail("111@gmail.com");
        session.update(student);
        transaction.commit();
        session.close();

        System.out.println(student);
    }
}
