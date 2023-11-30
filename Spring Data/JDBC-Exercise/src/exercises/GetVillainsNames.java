package exercises;

import utils.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames extends Exercise {
    public GetVillainsNames() throws SQLException {}

    @Override
    public String execute() throws SQLException {
        String SELECT_QUERY = "SELECT v.name, COUNT(DISTINCT mv.minion_id) AS number_of_minions" +
                            " FROM villains AS v" +
                            " JOIN minions_villains AS mv ON v.id = mv.villain_id" +
                            " GROUP BY v.id" +
                            " HAVING number_of_minions > 15" +
                            " ORDER BY number_of_minions DESC;";

        Connection connection = ConnectorDB.getDBConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
        ResultSet resultSet = statement.executeQuery();
        StringBuilder out = new StringBuilder();

        while (resultSet.next()) {
            out.append(resultSet.getString(1)).append(" ").append(resultSet.getString(2));
            out.append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
