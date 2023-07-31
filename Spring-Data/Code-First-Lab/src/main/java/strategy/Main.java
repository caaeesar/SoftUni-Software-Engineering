package strategy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateJPA");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Vehicle car = new Car(10);
        Vehicle truck = new Truck(45.9);
        Vehicle bike = new Bike();
        Vehicle plane = new Plane(300);

        entityManager.persist(car);
        entityManager.persist(truck);
        entityManager.persist(bike);
        entityManager.persist(plane);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
