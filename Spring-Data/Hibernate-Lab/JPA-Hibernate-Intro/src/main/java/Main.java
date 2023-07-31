import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateJPA");
        EntityManager em = emf.createEntityManager();

        // persist entity
        em.getTransaction().begin();
        Student student = new Student("Melissa", 5.50);
        em.persist(student);
        em.getTransaction().commit();

        // remove
        em.getTransaction().begin();
        Student studentForRemove = em.find(Student.class, 2L);
        em.remove(studentForRemove);
        em.getTransaction().commit();

        // get entity with JPQL
        em.getTransaction().begin();
        em.createQuery("FROM Student", Student.class)
           .getResultList()
           .forEach(System.out::println);
        em.getTransaction().commit();

        em.close();
    }
}
