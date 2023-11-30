package exercises;

import utils.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

import static utils.TableName.TB_MINIONS;

public class PrintAllMinionNames extends Exercise {
    public PrintAllMinionNames() throws SQLException {
    }

    @Override
    public String execute() throws SQLException {
        StringBuilder out = new StringBuilder();
        Connection connection = ConnectorDB.getDBConnection();
        int totalMinions = getAllEntries(connection);
        Deque<String> allMinionsNames = getAllMinionsName(connection);

        for (int i = 0; i < totalMinions; i++) {
            out.append(i % 2 == 0 ? allMinionsNames.pollFirst()
                                 : allMinionsNames.pollLast())
               .append(System.lineSeparator());

        }
        return out.toString().trim();
    }

    private Deque<String> getAllMinionsName(Connection connection) throws SQLException {
        String SELECT_MINIONS_QUERY = "SELECT name FROM " + TB_MINIONS;
        PreparedStatement statement = connection.prepareStatement(SELECT_MINIONS_QUERY);
        ResultSet minionsResultSet = statement.executeQuery();
        Deque<String> names = new ArrayDeque<>();
        while (minionsResultSet.next()) {
            names.offer(minionsResultSet.getString(1));
        }
        return names;
    }

    private int getAllEntries(Connection connection) throws SQLException {
        String SELECT_ID_QUERY = "SELECT COUNT(id) FROM " + TB_MINIONS;
        PreparedStatement statement = connection.prepareStatement(SELECT_ID_QUERY);
        ResultSet minionsResultSet = statement.executeQuery();
        if (minionsResultSet.next()) {
            return minionsResultSet.getInt(1);
        }
        return -1;
    }
}
