package orm.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static Connection connection;
    private static String connectionString = "jdbc:mysql:";

    public static void createConnection(String host, String port, String dbName,
                                        String username, String password) throws SQLException {
        connectionString = connectionString + host + ":" + port + "/" + dbName;
        connection = DriverManager.getConnection(connectionString, username,password);
    }

    public static Connection getConnection() {
        return connection;
    }
}
