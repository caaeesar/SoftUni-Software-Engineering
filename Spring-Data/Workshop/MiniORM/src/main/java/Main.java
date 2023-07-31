import entity.User;
import orm.core.Connector;
import orm.core.EntityManagerImpl;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws URISyntaxException, SQLException, IllegalAccessException {

        Connector.createConnection( "localhost",
                                    "3306",
                                    "demo",
                                    "root",
                                    "1234");

        Connection connection = Connector.getConnection();

        EntityManagerImpl<User> entityManager = new EntityManagerImpl<>(connection);

        // each instance of class with @Entity is one entry of table in database
        User user = new User("Melissa", 20, LocalDate.of(2023, 6, 17));

        entityManager.persist(user);

    }
}
