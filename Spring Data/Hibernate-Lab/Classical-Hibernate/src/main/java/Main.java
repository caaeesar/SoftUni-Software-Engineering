import entity.Student;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //Create Hibernate configuration
        Configuration cfg = new Configuration().configure();

        // Create SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        // Create Session
        Session session = sf.openSession();

        // Persist an entity
        Student student = new Student("Melissa");
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        // Get entity by id
        // 1-ви начин
        session.beginTransaction();
        Student result1 = session.get(Student.class, 1L, LockMode.READ);
        System.out.println(result1);
        session.getTransaction().commit();

        session.beginTransaction();
        long queryId = 2L;
        // 2ри начин
        // Student st = session.byId(Student.class).load(queryId);
        //3-ти начин
        Optional<Student> result = session.byId(Student.class).loadOptional(queryId);
        session.getTransaction().commit();
        if(result.isPresent()) {
            System.out.printf("Student: %s", result.get());
        } else {
            System.out.printf("Student with ID:%d does not exist.%n", queryId);
        }

        // List all students using HQL
        session.beginTransaction();
        session.createQuery("FROM Student", Student.class)
               .stream().forEach(System.out::println);
        session.getTransaction().commit();

        session.createQuery("FROM Student WHERE name = ?1", Student.class)
                .setParameter(1,"Tosho")
                .stream().forEach(System.out::println);

        // Type-safe criteria queries
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(cb.like(root.get("name"), "M%"));
        session.createQuery(query).getResultStream()
                .forEach(System.out::println);

        // Close Session
        session.close();
    }
}