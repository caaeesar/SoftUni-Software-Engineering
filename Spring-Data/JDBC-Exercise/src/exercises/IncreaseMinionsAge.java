package exercises;

import utils.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import static common.PromptMessages.ENTER_MINIONS_IDS;
import static utils.TableName.TB_MINIONS;

public class IncreaseMinionsAge extends Exercise {
    public IncreaseMinionsAge() throws SQLException {
    }

    @Override
    public String execute() throws SQLException {
        System.out.println(ENTER_MINIONS_IDS);
        int[] minionsIds = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        String UPDATE_MINIONS_QUERY = "UPDATE " + TB_MINIONS +
                " SET name = LOWER(name), age = age + 1" +
                " WHERE id = ?";

        Connection connection = ConnectorDB.getDBConnection();

        for (int i = 0; i < minionsIds.length; i++) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_MINIONS_QUERY);
            statement.setInt(1, minionsIds[i]);
            statement.executeUpdate();
        }
        return getAllMinionsNameAge(connection);
    }

    private String getAllMinionsNameAge(Connection connection) throws SQLException {
        StringBuilder out = new StringBuilder();
        String SELECT_MINION_QUERY = "SELECT name, age FROM " + TB_MINIONS;
        PreparedStatement statement = connection.prepareStatement(SELECT_MINION_QUERY);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            out.append(resultSet.getString(1)).append(" ")
                    .append(resultSet.getInt(2))
                    .append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
