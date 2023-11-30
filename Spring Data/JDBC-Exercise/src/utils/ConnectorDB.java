package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static common.PromptMessages.ENTER_PASS;
import static common.PromptMessages.ENTER_USER;

public class ConnectorDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";

    private static final String USER_KEY = "user";
    private static String userValues;
    private static String PASSWORD_KEY = "password";
    private static String passwordValue;

    private ConnectorDB() {
    }

    public static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL + DB_NAME, getUserPassProps());
    }

    private static Properties getUserPassProps() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_USER);
        userValues = scanner.nextLine();
        System.out.println(ENTER_PASS);
        passwordValue = scanner.nextLine();

        Properties properties = new Properties();
        properties.setProperty(USER_KEY, userValues);
        properties.setProperty(PASSWORD_KEY, passwordValue);
        return properties;
    }
}
