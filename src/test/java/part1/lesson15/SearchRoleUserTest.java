package part1.lesson15;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.*;
import static part1.lesson15.utilities.Utilities.URL_SQL_PROPERTIES;

class SearchRoleUserTest {

    @Test
    void searchUserRoleUser() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"))) {
            try (Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
                connection.setAutoCommit(false);
                ResultSet rsu;
                connection.commit();
                try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE3_ROLE_ID"))) {
                    CreationTableMain creationTableMain = new CreationTableMain();
                    preparedStatement.setString(1,"1");
                    rsu = preparedStatement.executeQuery();
                    creationTableMain.searchRole("1");
                    while (rsu.next()) {
                       creationTableMain.searchUser(rsu.getString(1));
                    }
                    preparedStatement.setString(1,"2");
                    rsu = preparedStatement.executeQuery();
                    System.out.println();
                    System.out.println("role_id: 2");
                    while (rsu.next()) {
                        creationTableMain.searchUser(rsu.getString(1));
                    }
                    preparedStatement.setString(1,"3");
                    rsu = preparedStatement.executeQuery();
                    System.out.println();
                    System.out.println("role_id: 3");
                    while (rsu.next()) {
                        creationTableMain.searchUser(rsu.getString(1));
                    }
                }
            }
        }
    }
}