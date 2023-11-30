package relations;

import relations.ManyToMany.Course;
import relations.ManyToMany.Student;
import relations.OneToMany.Aircraft;
import relations.OneToMany.Company;
import relations.OneToOne.MyCar;
import relations.OneToOne.PlateNumber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateJPA");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        PlateNumber plateNumber = new PlateNumber();
        plateNumber.setNumber("CB11111CK");
        MyCar car = new MyCar();
        car.setPlateNumber(plateNumber);

        entityManager.persist(plateNumber);
        entityManager.persist(car);

      /*  Company company = new Company();
        company.setName("MyCompany");

        Aircraft aircraft1 = new Aircraft();
        aircraft1.setCompany(company);
        Aircraft aircraft2 = new Aircraft();
        aircraft2.setCompany(company);
        Aircraft aircraft3 = new Aircraft();
        aircraft3.setCompany(company);

        entityManager.persist(company);
        entityManager.persist(aircraft1);
        entityManager.persist(aircraft2);
        entityManager.persist(aircraft3);*/

       /* Student student1 = new Student();
        Student student2 = new Student();

        Course math = new Course();
        Course bel = new Course();
        Course geo = new Course();

        student1.setCourses(List.of(math,bel));
        student2.setCourses(List.of(math,bel, geo));

        math.setStudents(List.of(student1,student2));
        bel.setStudents(List.of(student1,student2));
        geo.setStudents(List.of(student2));

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(math);
        entityManager.persist(bel);
        entityManager.persist(geo);*/

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
