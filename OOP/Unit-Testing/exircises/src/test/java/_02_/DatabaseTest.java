package _02_;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private Database database;
    private Person georgi;
    private Person petar;
    private Person tony;
    private Person niki;

    @Before
    public void setPut() throws OperationNotSupportedException {
        Person georgi = new Person(1, "Georgi");
        Person petar = new Person(2, "Petar");
        Person tony = new Person(1, "Tony");
        Person niki = new Person(1, "Niki");
        database = new Database(georgi, petar, tony, niki);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameIfMissing() throws OperationNotSupportedException {
        database.findByUsername("Aleks");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullParameters() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        long petarId = petar.getId();
        String petarUsername = petar.getUsername();
        Person person = database.findByUsername(petarUsername);
        assertEquals(petarId,person.getId());
        assertEquals(petarUsername, person.getUsername());
    }

}
