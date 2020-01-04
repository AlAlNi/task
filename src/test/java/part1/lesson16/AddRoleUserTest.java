package part1.lesson16;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.*;
import static part1.lesson15.utilities.Utilities.URL_SQL_PROPERTIES;

class AddRoleUserTest {

    @Test
    void addRoleUser() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"))) {
            try (Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
                connection.setAutoCommit(false);
                statement.addBatch(properties.getProperty("drop_TABLE3"));
                statement.addBatch(properties.getProperty("create_TABLE3"));
                statement.addBatch(properties.getProperty("insert_column_in_TABLE3_3"));
                statement.executeBatch();
                connection.commit();
            }
        }
    }
}
