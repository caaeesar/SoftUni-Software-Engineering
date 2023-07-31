package exercises;

import utils.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static common.ErrorMessages.NOT_FOUND_VILLAIN_ID;
import static common.OutputMessages.SUCCESSFULLY_DELETED_VILLAIN;
import static common.OutputMessages.SUCCESSFULLY_RELEASED_MINIONS;
import static common.PromptMessages.ENTER_VILLAIN_ID;
import static utils.SQLUtility.findNameById;
import static utils.TableName.TB_MV;
import static utils.TableName.TB_VILLAINS;

public class RemoveVillain extends Exercise {
    private PreparedStatement statement;
    private ResultSet resultSet;

    public RemoveVillain() throws SQLException {
    }

    @Override
    public String execute() throws SQLException {
        Connection connection = ConnectorDB.getDBConnection();
        StringBuilder out = new StringBuilder();

        System.out.println(ENTER_VILLAIN_ID);
        int villainId = Integer.parseInt(new Scanner(System.in).nextLine());

        String villainName = findNameById(connection, villainId, TB_VILLAINS);
        if (villainName == null) {
            throw new IllegalArgumentException(NOT_FOUND_VILLAIN_ID);
        }

        String SELECT_MINIONS_ID_QUERY = "SELECT COUNT(minion_id) FROM minions_villains WHERE villain_id = ?";

        statement = connection.prepareStatement(SELECT_MINIONS_ID_QUERY);
        statement.setInt(1, villainId);
        resultSet = statement.executeQuery();

        int releasedMinions = 0;
        if (resultSet.next()) {
            releasedMinions = resultSet.getInt(1);
        }

        connection.setAutoCommit(false);
        try {
            String DELETE_VILLAIN_QUERY = "DELETE FROM " + TB_VILLAINS + " WHERE id = ?";
            statement = connection.prepareStatement(DELETE_VILLAIN_QUERY);
            statement.setInt(1, villainId);
            out.append(String.format(SUCCESSFULLY_DELETED_VILLAIN, villainName))
                    .append(System.lineSeparator());

            String DELETE_MINION_QUERY = "DELETE FROM " + TB_MV + " WHERE villain_id = ?";
            statement = connection.prepareStatement(DELETE_MINION_QUERY);
            statement.setInt(1, villainId);
            out.append(String.format(SUCCESSFULLY_RELEASED_MINIONS, releasedMinions))
                    .append(System.lineSeparator());
            ;

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }

        return out.toString().trim();
    }
}
