package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtility {

    private static String SQLQuery;

    public static int findIdByName(Connection connection, String name, String tableName) throws SQLException {
        SQLQuery = "SELECT id FROM " + tableName + " WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(SQLQuery);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }
        return -1;
    }

    public static String findNameById(Connection connection, int searchId, String tableName) throws SQLException {
        SQLQuery = "SELECT name FROM " + tableName + " WHERE id = ?";
        PreparedStatement pr = connection.prepareStatement(SQLQuery);
        pr.setInt(1, searchId);
        ResultSet rs = pr.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return rs.getString("name");
    }
}
