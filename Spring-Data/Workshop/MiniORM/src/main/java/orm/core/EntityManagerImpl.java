package orm.core;

import orm.annotation.Column;
import orm.annotation.Entity;
import orm.annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityManagerImpl<E> implements EntityManager<E> {

    public static final String INT = "INT";
    public static final String DATE = "DATE";
    public static final String VARCHAR = "VARCHAR";
    private Connection connection;
    private static final String SELECT_STAR_FROM = "SELECT * FROM ";
    private static final String INSERT_QUERY = "INSERT INTO %s (id, %s) VALUE (%s) ;";
    private static final String UPDATE_QUERY = "UPDATE %s SET %s WHERE %s ;";
    private static final String UPDATE_VALUE_FORMAT = "%s = %s";
    private static final String DELETE_QUERY = "DELETE FROM %s WHERE %s ;";

    public EntityManagerImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param entity
     * @return the method should check if the given object to be persisted is not contained in the database
     * and if not add it, otherwise update its properties with the new values
     * @throws IllegalAccessException
     * @throws SQLException
     */
    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        // get field with id annotation
        Field primaryKey = getId(entity.getClass());
        primaryKey.setAccessible(true);
        // get value of the field with id annotation
        Object value = primaryKey.get(entity);

        return value == null ? doInsert(entity) : doUpdate(entity);
    }

    private <E> boolean doUpdate(E entity) throws SQLException {
        String tableName = getTableName(entity.getClass());


    }

    private boolean doInsert(E entity) throws SQLException {
        String tableName = getTableName((Class<E>) entity);
        String INSERT_QUERY = "INSERT INTO " + tableName +
                " VALUES (" + getFieldValues(entity).toString().replace("{}", "") + ")";
        return connection.prepareStatement(INSERT_QUERY).execute();
    }

    private <E> List<String> getFieldNames(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> {
                            f.setAccessible(true);
                            return f.getAnnotation(Column.class).name();
                        }
                )
                .collect(Collectors.toList());
    }

    private <E> List<String> getFieldValues(E entity) {
        return Arrays.stream(entity.getClass()
                        .getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class) && f.isAnnotationPresent(Column.class))
                .map(f -> {
                    f.setAccessible(true);
                    return getSQLType(entity, f);
                })
                .collect(Collectors.toList());
    }

    private String getSQLType(E entity, Field f) {
        try {
            return f.getType() == String.class || f.getType() == LocalDate.class
                    ? "'" + f.get(entity) + "'"
                    : f.get(entity).toString();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getTableName(Class<?> entity) {
        return entity.getAnnotation(Entity.class).tableName();
    }

    @Override
    public Field getId(Class<?> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key"));
    }


    @Override
    public void create(Class<E> entityClass) throws SQLException {

    }

    private String getSQLType(Class<?> type) {
        if (type == Integer.class || type == int.class || type == long.class || type == Long.class) {
            return INT;
        } else if (type == LocalDate.class) {
            return DATE;
        }

        return VARCHAR;
    }

    @Override
    public void alter(E entity) {

    }

    @Override
    public void delete(E entity) throws NoSuchFieldException, SQLException {
        String tableName = getTableName(entity.getClass());
        Field id = getId((Class<?>) entity);
        String sql = "DELETE " + tableName + " WHERE id = " + id;

        connection.prepareStatement(sql).executeUpdate();
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException {
        String SELECT_QUERY = "SELECT * FROM " + getTableName(table) + "WHERE " + where;

        PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
        ResultSet resultSet = statement.executeQuery();
        List<E> allEntities = new ArrayList<>();
        // todo
        return allEntities;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM " + table.getName() + " LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
      return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }

    private boolean executeQuery(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.execute();
    }


}
