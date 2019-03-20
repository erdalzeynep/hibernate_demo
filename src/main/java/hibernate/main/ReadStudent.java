package hibernate.main;

import hibernate.entity.Student;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ReadStudent {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);

        Root<Student> root = query.from(Student.class);
        query.select(root);
//        query.where(builder.equal(root.get("firstName"), "zeynep"));
//        query.orderBy(builder.desc(root.get("id")));

        List<Student> studentList = session.createQuery(query).getResultList();

        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
