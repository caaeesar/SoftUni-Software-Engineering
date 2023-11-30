import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _01_Main {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/soft_uni";
    public static final String SQL_QUERY = "SELECT `first_name`, `last_name` FROM employees WHERE `salary` > ?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Connect to MySQL server and execute sql scripts

        // 2. Add driver -> external library

        // 3. Connect to database
        // URL -> protocol:db://host:port/databaseName

        // 4. Read properties from console
        Properties userPass = new Properties();

        System.out.println("Enter DB username (<Enter> for 'root'): ");
        String user = scanner.nextLine();
        user = user.length() == 0 ? "root" : user;
        userPass.setProperty("user", user);

        System.out.println("Enter DB password (<Enter> for default empty): ");
        String password = scanner.nextLine();
        password = password.trim().length() == 0 ? "" : password;
        userPass.setProperty("password", password);

        try (Connection con = DriverManager.getConnection(DB_URL, userPass);
             PreparedStatement pr = con.prepareStatement(SQL_QUERY)) {

            // 5. Execute prepared statement with parameter
            System.out.println("Enter salary:");
            double salary = Double.parseDouble(scanner.nextLine());
            pr.setDouble(1, salary);
            ResultSet rs = pr.executeQuery();

            // 6. Print results
            while (rs.next()) {
                System.out.printf("%s %s\n", rs.getString("first_name"), rs.getString("last_name"));
            }

        } catch (SQLException e) {
            System.err.printf("Error closing DB connection %s", e.getMessage());
        }
    }
}
