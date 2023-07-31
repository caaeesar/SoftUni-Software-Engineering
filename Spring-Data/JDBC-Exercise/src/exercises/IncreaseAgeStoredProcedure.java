package exercises;

import utils.ConnectorDB;

import java.sql.*;
import java.util.Scanner;

import static common.PromptMessages.ENTER_MINIONS_ID;
import static utils.SQLUtility.findNameById;
import static utils.TableName.TB_MINIONS;

public class IncreaseAgeStoredProcedure extends Exercise {

    private final String PROCEDURE = "DELIMITER $$" +
            " CREATE PROCEDURE usp_get_older (minion_id INT)" +
            " BEGIN" +
            "    UPDATE minions" +
            "    SET age = age + 1" +
            "    WHERE id = minion_id;" +
            "END $$";

    private final String CALL_PROCEDURE = "CALL usp_get_older (?)";

    public IncreaseAgeStoredProcedure() throws SQLException {}

    @Override
    public String execute() throws SQLException {
        System.out.println(ENTER_MINIONS_ID);
        int minion_id = Integer.parseInt(new Scanner(System.in).nextLine());

        Connection connection = ConnectorDB.getDBConnection();
        CallableStatement callableStatement = connection.prepareCall(CALL_PROCEDURE);
        callableStatement.setInt(1, minion_id);
        callableStatement.execute();

        int age = getMinionAge(connection, minion_id);
        StringBuilder out = new StringBuilder();
        out.append(findNameById(connection, minion_id, TB_MINIONS))
            .append(" ")
            .append(age);

        return out.toString().trim();
    }

    private int getMinionAge(Connection connection, int minion_id) throws SQLException {
        String SELECT_MINION_QUERY = "SELECT age FROM " + TB_MINIONS + " WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(SELECT_MINION_QUERY);
        statement.setInt(1, minion_id);
        ResultSet resultSet = statement.executeQuery();
        int age = -1;
        if (resultSet.next()) {
            age = resultSet.getInt(1);
        }
        return age;
    }
}
