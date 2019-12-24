package part1.lesson15;


import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.*;
import static part1.lesson15.utilities.Utilities.URL_SQL_PROPERTIES;

public class CreationBaseUser {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"),
                properties.getProperty("USER"),
                properties.getProperty("PASSWORD"));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            statement.execute(properties.getProperty("drop_TABL1"));
            statement.execute(properties.getProperty("create_TABL1"));
            statement.execute(properties.getProperty("insert_into_TABL1"));
        }
        CreationBaseUser creationBaseUser = new CreationBaseUser();
        creationBaseUser.FormatLoginId();
        creationBaseUser.FormationRole();
        creationBaseUser.FormationRoleUser();
    }

    void FormatLoginId() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"),
                properties.getProperty("USER"),
                properties.getProperty("PASSWORD"));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            try (ResultSet rsu = statement.executeQuery(properties.getProperty("select_TABL1"))) {
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

    void FormationRole() throws SQLException, IOException {
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
            ResultSet rsu;
            connection.commit();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement(properties.getProperty("select_TABL1") + "WHERE \"name\" = ? and \"login_ID\" = ?")) {
                preparedStatement.setString(1, "Marusya");
                preparedStatement.setString(2, "Marusya_4");
                rsu = preparedStatement.executeQuery();
                if (rsu.getMetaData().getColumnCount() == 7) {
                    while (rsu.next()) {
                        System.out.print("name= " + rsu.getString(2));
                        System.out.println(" login_ID= " + rsu.getString(4));
                    }
                }
            }
        }
    }

    void FormationRoleUser() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (Connection connection = getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"));
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE,
                     CONCUR_UPDATABLE, HOLD_CURSORS_OVER_COMMIT)) {
            ResultSet rsu;
            statement.execute(properties.getProperty("drop_TABLE3"));
            statement.execute( properties.getProperty("create_TABLE3"));
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement(properties.getProperty("select_TABL1"))) {
                rsu = preparedStatement.executeQuery();
                connection.setAutoCommit(false);
                while (rsu.next()) {
                    statement.addBatch(
                            "INSERT INTO \"USER_ROLE\""+"(\"user_id\")" +
                                    "VALUES ('" + rsu.getString("login_ID") + "');");
                }
            }
            statement.executeBatch();
            connection.commit();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement(properties.getProperty("select_TABL2"))) {
                rsu = preparedStatement.executeQuery();
                int counterId = 1;
                while (rsu.next()) {
                    if (rsu.getString("name").equalsIgnoreCase("Administration")) {
                        statement.addBatch
                                (String.format("update \"USER_ROLE\"set \"role_id\"='%s'WHERE id=%d;",
                                        rsu.getString("name"), counterId));
                    }
                    if (rsu.getString("name").equalsIgnoreCase("clients")) {
                        statement.addBatch
                                (String.format("update \"USER_ROLE\"set \"role_id\"='%s'WHERE id=%d;",
                                        rsu.getString("name"), counterId));
                    }
                    if (rsu.getString("name").equalsIgnoreCase("billing")) {
                        statement.addBatch(String.format("update \"USER_ROLE\"set \"role_id\"='%s'WHERE id=%d;",
                                rsu.getString("name"), counterId));
                    }
                    counterId++;
                }
                statement.executeBatch();
                connection.commit();
            }
        }
    }
}
