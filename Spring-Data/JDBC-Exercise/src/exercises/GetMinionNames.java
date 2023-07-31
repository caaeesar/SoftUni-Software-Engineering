package exercises;

import utils.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static common.ErrorMessages.INVALID_VILLAIN_ID;
import static common.OutputMessages.MINION_NAME_AGE;
import static common.OutputMessages.VILLAIN_NAME;
import static common.PromptMessages.ENTER_VILLAIN_ID;
import static utils.SQLUtility.findNameById;
import static utils.TableName.TB_VILLAINS;

public class GetMinionNames extends Exercise {
    public GetMinionNames() throws SQLException {}

    @Override
    public String execute() throws SQLException {
        System.out.println(ENTER_VILLAIN_ID);
        int villainId = Integer.parseInt(new Scanner(System.in).nextLine());

        Connection connection = ConnectorDB.getDBConnection();

        String villainName = findNameById(connection, villainId, TB_VILLAINS);
        if (villainName == null) {
           throw new IllegalArgumentException(String.format(INVALID_VILLAIN_ID, villainId));
        }

        String SELECT_QUERY = "SELECT m.name, m.age" +
                        " FROM minions AS m" +
                        " JOIN minions_villains AS mv" +
                        " ON m.id = mv.minion_id" +
                        " WHERE mv.villain_id = ?;";
        PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
        statement.setInt(1, villainId);
        ResultSet resultSet = statement.executeQuery();

        AtomicInteger count = new AtomicInteger(0);
        StringBuilder out = new StringBuilder();
        out.append(String.format(VILLAIN_NAME, villainName)).append(System.lineSeparator());
        while (resultSet.next()) {
            out.append(String.format(MINION_NAME_AGE,
                            count.incrementAndGet(),
                            resultSet.getString(1),
                            resultSet.getInt(2)))
                .append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
