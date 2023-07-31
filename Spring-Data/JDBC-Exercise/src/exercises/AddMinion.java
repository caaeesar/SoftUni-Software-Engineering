package exercises;

import utils.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static common.OutputMessages.*;
import static common.PromptMessages.ENTER_MINION_INFO;
import static common.PromptMessages.ENTER_VILLAIN_NAME;
import static utils.SQLUtility.findIdByName;
import static utils.TableName.*;

public class AddMinion extends Exercise {
    private final Scanner scanner = new Scanner(System.in);
    private static PreparedStatement statement;
    public AddMinion() throws SQLException {}

    @Override
    public String execute() throws SQLException {
        System.out.println(ENTER_MINION_INFO);
        String minionInfo = scanner.nextLine();
        String minionName = minionInfo.split("\\s+")[1];
        int minionAge = Integer.parseInt(minionInfo.split("\\s+")[2]);
        String townName = minionInfo.split("\\s+")[3];

        System.out.println(ENTER_VILLAIN_NAME);
        String villainName = scanner.nextLine().split("\\s+")[1];

        StringBuilder out = new StringBuilder();
        Connection connection = ConnectorDB.getDBConnection();

        int townId = findIdByName(connection, townName, "towns");
        if (townId == -1) { // if not exist
            // add town
           String INSERT_TOWNS_QUERY = String.format("INSERT INTO towns (name)" +
                                    " VALUES (\"%s\")", townName);
            statement = connection.prepareStatement(INSERT_TOWNS_QUERY);
            statement.execute();
            townId = findIdByName(connection, townName, TB_TOWNS);
            out.append(String.format(SUCCESSFULLY_ADDED_TOWNS, townName)).append(System.lineSeparator());
        }
        // add minion
        int minionId;
        String INSERT_MINIONS_QUERY = String.format("INSERT INTO minions (name, age, town_id)" +
                                " VALUES (\"%s\", %d, %d)", minionName, minionAge, townId);
        statement = connection.prepareStatement(INSERT_MINIONS_QUERY);
        statement.execute();
        minionId = findIdByName(connection, minionName, TB_MINIONS);


        int villainId = findIdByName(connection, villainName, TB_VILLAINS);
        if (villainId == -1) { // if not exist
            // add villain
            String INSERT_VILLAINS_QUERY = String.format("INSERT INTO villains (name, evilness_factor)" +
                                                        " VALUES(\"%s\", \"%s\")", villainName, "evil");
            statement = connection.prepareStatement(INSERT_VILLAINS_QUERY);
            statement.execute();
            villainId = findIdByName(connection, villainName, TB_VILLAINS);
            out.append(String.format(SUCCESSFULLY_ADDED_VILLAIN, villainName))
                    .append(System.lineSeparator());
        }

        // set the new minion to be a servant of the villain
        String INSERT_MINION_VILLAIN_QUERY = String.format("INSERT INTO minions_villains" +
                                                           " VALUES(%d, %d)", minionId, villainId);
        statement = connection.prepareStatement(INSERT_MINION_VILLAIN_QUERY);
        statement.execute();
        out.append(String.format(SUCCESSFULLY_ADDED_MINION, minionName, villainName));

        return out.toString().trim();
    }
}
