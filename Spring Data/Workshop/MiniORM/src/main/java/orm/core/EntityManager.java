package orm.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EntityManager <E> {

    boolean persist(E entity) throws IllegalAccessException, SQLException;

    /**
     * @param table
     * @return collection of all entity objects of type E
     */
    Iterable<E> find (Class<E> table);

    Iterable<E> find (Class<E> table, String where) throws SQLException;

    /**
     * @param table
     * @return the first entity object of type E
     */
    E findFirst (Class<E> table) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    E findFirst (Class<E> table, String where);

   Field getId(Class<?> entity);

   void create(Class<E> entityClass) throws SQLException;
   void alter(E entity);
   void delete(E entity) throws NoSuchFieldException, SQLException;
}
