package part1.lesson15;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.*;
import static part1.lesson15.utilities.Utilities.URL_SQL_PROPERTIES;

class FormationTableRoleTest {

    @Test
    void formationTableRole() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"),
                properties.getProperty("USER"),
                properties.getProperty("PASSWORD"));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            statement.addBatch(properties.getProperty("drop_TABLE2"));
            statement.addBatch(properties.getProperty("create_TABLE2"));
            connection.setAutoCommit(false);
            statement.addBatch(properties.getProperty("insert_column_in_TABLE2"));
            statement.executeBatch();
            connection.commit();
            CreationTableMain creationTableMain = new CreationTableMain();
            creationTableMain.dropDuplicatesTableRole();
            ResultSet rsu;
            connection.commit();
            try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE2"))) {
                rsu = preparedStatement.executeQuery();
                while (rsu.next()) {
                    System.out.print(rsu.getRow() + " - ");
                    System.out.println(rsu.getString(1));
                }
            }
        }
    }
}