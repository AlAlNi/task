package part1.lesson15;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static part1.lesson15.utilities.Utilities.*;

class CreationBaseUserTest {

    @Test
    void formatLoginId() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            try (ResultSet rsu = statement.executeQuery("select * from \"USER\"");) {
                statement.addBatch("DROP TABLE IF EXISTS \"ROLE\"");
                statement.addBatch("CREATE TABLE \"ROLE\" ( id bigserial primary key, name varchar(100),"
                        + "description varchar(100))");
                connection.setAutoCommit(false);
                while (rsu.next()) {
                    if (rsu.getString("login_ID").equalsIgnoreCase("<null>")) {
                        rsu.updateString("login_ID", rsu.getString("name")
                                + "_"
                                + rsu.getString("id"));
                        rsu.updateRow();
                    }
                    connection.commit();
                }
            }
        }
    }

    @Test
    void formationRole() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            try (ResultSet rsu = statement.executeQuery("select * from \"USER\"");) {
                statement.addBatch("DROP TABLE IF EXISTS \"ROLE\"");
                statement.addBatch("CREATE TABLE \"ROLE\" ( id bigserial primary key, name varchar(100),"
                        + "description varchar(100))");
                connection.setAutoCommit(false);
                while (rsu.next()) {
                    if (rsu.getString("email").contains("@administration.ru")) {
                        statement.addBatch("INSERT INTO \"ROLE\"(name) VALUES ('Administration');");
                    }
                    if (rsu.getString("email").contains("@clients.ru")) {
                        statement.addBatch("INSERT INTO \"ROLE\"(name) VALUES ('clients');");
                    }
                    if (rsu.getString("email").contains("@billing.ru")) {
                        statement.addBatch("INSERT INTO \"ROLE\"(name) VALUES ('billing');");
                    }
                }
                statement.executeBatch();
                connection.commit();
            }
            ResultSet rsu;
            connection.commit();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM \"USER\" WHERE \"name\" = ? and \"login_ID\" = ?")) {
                preparedStatement.setString(1, "Marusya");
                preparedStatement.setString(2, "Marusya_4");
                rsu = preparedStatement.executeQuery();
                while (rsu.next()) {
                    System.out.print("name= " + rsu.getString("name"));
                    System.out.println(" login_ID= " + rsu.getString("login_ID"));
                }
            }
        }
    }

    @Test
    void formationRoleUser() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            ResultSet rsu;
            statement.execute("-- Database: entity\n"
                    + "DROP TABLE IF EXISTS \"USER_ROLE\";"
                    + "CREATE TABLE \"USER_ROLE\" (\n"
                    + "    id bigserial primary key,\n"
                    + "    user_id varchar(100) ,\n"
                    + "    \"role_id\" varchar(100) \n"
                    + ");"
                    + "\n");
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM \"USER\"")) {
                rsu = preparedStatement.executeQuery();
                connection.setAutoCommit(false);
                while (rsu.next()) {
                    statement.addBatch(
                            "INSERT INTO \"USER_ROLE\"(\"user_id\")" +
                                    "VALUES ('" + rsu.getString("login_ID") + "');");
                }
            }
            statement.executeBatch();
            connection.commit();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM \"ROLE\"")) {
                rsu = preparedStatement.executeQuery();
                int counterId = 1;
                int counterIdAdministration = 1;
                int counterIdClients = 1;
                int counterIdBilling = 1;
                while (rsu.next()) {
                    if (rsu.getString("name").equalsIgnoreCase("Administration")) {
                        statement.addBatch
                                (String.format("update \"USER_ROLE\"set \"role_id\"='%s_%d'WHERE id=%d;",
                                        rsu.getString("name"), counterIdAdministration, counterId));
                        counterIdAdministration++;
                    }
                    if (rsu.getString("name").equalsIgnoreCase("clients")) {
                        statement.addBatch
                                (String.format("update \"USER_ROLE\"set \"role_id\"='%s_%d'WHERE id=%d;",
                                        rsu.getString("name"), counterIdClients, counterId));
                        counterIdClients++;
                    }
                    if (rsu.getString("name").equalsIgnoreCase("billing")) {
                        statement.addBatch(String.format("update \"USER_ROLE\"set \"role_id\"='%s_%d'WHERE id=%d;",
                                rsu.getString("name"), counterIdBilling, counterId));
                        counterIdBilling++;
                    }
                    counterId++;
                }
                statement.executeBatch();
                connection.commit();
            }
        }
    }
}