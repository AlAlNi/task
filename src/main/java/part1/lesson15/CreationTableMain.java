package part1.lesson15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.*;
import static part1.lesson15.utilities.Utilities.*;

public class CreationTableMain {
    private static final Logger logger = LogManager.getLogger(CreationTableMain.class);

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(URL_SQL_PROPERTIES));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        try (Connection connection = getConnection(properties.getProperty(URL),
                properties.getProperty(USER),
                properties.getProperty(PASSWORD));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            statement.execute(properties.getProperty("drop_TABLE_MAIN"));
            statement.execute(properties.getProperty("create_TABLE_MAIN"));
            statement.execute(properties.getProperty("insert_into_TABLE_MAIN"));
            CreationTableMain creationTableMain = new CreationTableMain();
            creationTableMain.formatFourthColumnMainTable();
            ResultSet rsu;
            try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE_MAIN"))) {
                rsu = preparedStatement.executeQuery();
                while (rsu.next()) {
                    logger.info("('" + rsu.getString(4) + "') ");
                }
            }
            creationTableMain.formationTableRole();
            creationTableMain.formationRoleUser();
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage());
        }
    }

    void formatFourthColumnMainTable() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(URL_SQL_PROPERTIES));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        try (Connection connection = getConnection(properties.getProperty(URL),
                properties.getProperty(USER),
                properties.getProperty(PASSWORD));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            try (ResultSet rsu = statement.executeQuery(properties.getProperty("select_TABLE_MAIN"))) {
                connection.setAutoCommit(false);
                while (rsu.next()) {
                    if (rsu.getString(4).equalsIgnoreCase("<null>")) {
                        rsu.updateString(4, rsu.getString(2)
                                + "_"
                                + rsu.getString(1));
                        rsu.updateRow();
                    }
                }
                connection.commit();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    void formationTableRole() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty(URL),
                properties.getProperty(USER),
                properties.getProperty(PASSWORD));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            statement.addBatch(properties.getProperty("drop_TABLE2"));
            statement.addBatch(properties.getProperty("create_TABLE2"));
            connection.setAutoCommit(false);
            statement.addBatch(properties.getProperty("insert_column_in_TABLE2"));
            statement.executeBatch();
            connection.commit();
            CreationTableMain creationTableMainError = new CreationTableMain();
            creationTableMainError.dropDuplicatesTableRole();
            ResultSet rsu;
            connection.commit();
            try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE2"))) {
                rsu = preparedStatement.executeQuery();
                while (rsu.next()) {
                    logger.info(rsu.getRow() + " - " + rsu.getString(1));
                }
            }
        }
    }

    void dropDuplicatesTableRole() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty(URL),
                properties.getProperty(USER),
                properties.getProperty(PASSWORD));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            statement.execute(properties.getProperty("drop_emptyTemporaryTable"));
            statement.execute(properties.getProperty("create_table_copy_TABLE_MAIN"));
            statement.execute(properties.getProperty("truncate_TABLE_MAIN"));
            statement.execute(properties.getProperty("insert_table_copy_TABLE_MAIN"));
            statement.execute(properties.getProperty("drop_emptyTemporaryTable"));
        }
    }

    void formationRoleUser() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty(URL), properties.getProperty(USER), properties.getProperty(PASSWORD))) {
            try (Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
                statement.execute(properties.getProperty("drop_TABLE3"));
                statement.execute(properties.getProperty("create_TABLE3"));
            }
        }
    }

    void searchUser(String userId) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(URL_SQL_PROPERTIES));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        try (Connection connection = getConnection(properties.getProperty(URL), properties.getProperty(USER), properties.getProperty(PASSWORD))) {
            try (Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
                connection.setAutoCommit(false);
                ResultSet rsu;
                connection.commit();
                try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE1_LOGIN_ID"))) {
                    preparedStatement.setString(1, userId);
                    rsu = preparedStatement.executeQuery();
                    while (rsu.next()) {
                        logger.info(rsu.getString(4));
                    }
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    void searchRole(String role) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(URL_SQL_PROPERTIES));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        try (Connection connection = getConnection(properties.getProperty(URL), properties.getProperty(USER), properties.getProperty(PASSWORD))) {
            try (Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
                connection.setAutoCommit(false);
                ResultSet rsu;
                connection.commit();
                try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE2_NAME"))) {
                    preparedStatement.setString(1, role);
                    rsu = preparedStatement.executeQuery();
                    while (rsu.next()) {
                        logger.info(rsu.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}