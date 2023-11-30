import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _02_Main {

    public static final String STRING_CONNECTION = "jdbc:mysql://localhost:3306/diablo";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties userPass = new Properties();
        userPass.setProperty("user", "root");
        userPass.setProperty("password", "1234");

        Connection con = DriverManager.getConnection(STRING_CONNECTION, userPass);

        PreparedStatement ps = con.prepareStatement("SELECT  `first_name`, `last_name`, COUNT(ug.`id`) AS 'count'" +
                " FROM `users` AS u" +
                " JOIN `users_games` AS ug" +
                " ON u.`id` = ug.`user_id`" +
                " WHERE `user_name` = ?" +
                " GROUP BY u.`id`" +
                " HAVING `count` <> 0;");
        System.out.println("Enter the username: ");
        String username = scanner.nextLine();
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.printf("User: %s\n" +
                            "%s %s has played %d games",
                    username, rs.getString(1), rs.getString(2), rs.getInt(3));
        } else {
            System.out.println("No such user exists");
        }
    }
}