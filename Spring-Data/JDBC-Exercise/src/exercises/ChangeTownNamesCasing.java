package exercises;

import utils.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static common.ErrorMessages.INVALID_COUNTRY_NAME;
import static common.OutputMessages.ROW_AFFECTED;
import static common.PromptMessages.ENTER_COUNTRY;
import static utils.TableName.TB_TOWNS;

public class ChangeTownNamesCasing extends Exercise {
    private final Scanner scanner = new Scanner(System.in);
    private static PreparedStatement statement;

    public ChangeTownNamesCasing() throws SQLException {
    }

    @Override
    public String execute() throws SQLException {
        Connection connection = ConnectorDB.getDBConnection();
        StringBuilder out = new StringBuilder();

        System.out.println(ENTER_COUNTRY);
        String countryName = scanner.nextLine();

        String UPDATE_TOWNS_QUERY = "UPDATE " + TB_TOWNS +
                                    " SET name = UPPER(name)" +
                                    " WHERE country = ?";
        statement = connection.prepareStatement(UPDATE_TOWNS_QUERY);
        statement.setString(1, countryName);
        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) {
            throw new IllegalArgumentException(INVALID_COUNTRY_NAME);
        }
        out.append(String.format(ROW_AFFECTED, affectedRows)).append(System.lineSeparator());
        String SELECT_TOWNS_QUERY = "SELECT name FROM " + TB_TOWNS + " WHERE country = ?";

        statement = connection.prepareStatement(SELECT_TOWNS_QUERY);
        statement.setString(1, countryName);
        ResultSet resultSet = statement.executeQuery();
        List<String> townsAffected = new ArrayList<>();
        while (resultSet.next()) {
            townsAffected.add(resultSet.getString(1));
        }

        out.append(townsAffected);
        return out.toString().trim();
    }
}
