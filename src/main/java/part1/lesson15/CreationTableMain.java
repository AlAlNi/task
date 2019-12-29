package part1.lesson15;


import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.*;
import static part1.lesson05.utilities.MainUtilities.EMPTY;
import static part1.lesson15.utilities.Utilities.URL_SQL_PROPERTIES;

public class CreationTableMain {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"),
                properties.getProperty("USER"),
                properties.getProperty("PASSWORD"));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            statement.execute(properties.getProperty("drop_TABLE_MAIN"));
            statement.execute(properties.getProperty("create_TABLE_MAIN"));
            statement.execute(properties.getProperty("insert_into_TABLE_MAIN"));
            CreationTableMain creationTableMain = new CreationTableMain();
            creationTableMain.FormatFourthColumnMainTable();
            ResultSet rsu;
            try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE_MAIN"))) {
                rsu = preparedStatement.executeQuery();
                if (rsu.getMetaData().getColumnCount() == 7) {
                    while (rsu.next()) {
                        System.out.print("('" + rsu.getString(4) + "'), ");
                    }
                    System.out.println(EMPTY);
                }
            }
            creationTableMain.FormationTableRole();
            creationTableMain.FormationRoleUser();
        }
    }

    void FormatFourthColumnMainTable() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"),
                properties.getProperty("USER"),
                properties.getProperty("PASSWORD"));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            try (ResultSet rsu = statement.executeQuery(properties.getProperty("select_TABLE_MAIN"))) {
                if (rsu.getMetaData().getColumnCount() == 7) {
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
            }
        }
    }

    void FormationTableRole() throws SQLException, IOException {
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
            creationTableMain.DropDuplicatesTableRole();
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

    void DropDuplicatesTableRole() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"),
                properties.getProperty("USER"),
                properties.getProperty("PASSWORD"));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            statement.execute(properties.getProperty("drop_emptyTemporaryTable"));
            statement.execute(properties.getProperty("create_table_copy_TABLE_MAIN"));
            statement.execute(properties.getProperty("truncate_TABLE_MAIN"));
            statement.execute(properties.getProperty("insert_table_copy_TABLE_MAIN"));
            statement.execute(properties.getProperty("drop_emptyTemporaryTable"));
        }
    }

    void FormationRoleUser() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"))) {
            try (Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
                statement.execute(properties.getProperty("drop_TABLE3"));
                statement.execute(properties.getProperty("create_TABLE3"));
            }
        }
    }
}
