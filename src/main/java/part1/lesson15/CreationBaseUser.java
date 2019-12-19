package part1.lesson15;

import java.sql.*;

import static part1.lesson15.utilities.Utilities.*;

public class CreationBaseUser {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD.get());
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            statement.execute("-- Database: entity\n"
                    + "DROP TABLE IF EXISTS \"USER\";"
                    + "CREATE TABLE \"USER\" (\n"
                    + "    id bigserial primary key,\n"
                    + "    name varchar(100) NOT NULL,\n"
                    + "    birthday date NOT NULL,\n"
                    + "    \"login_ID\" varchar ,\n"
                    + "    city varchar(100) NOT NULL,\n"
                    + "    email varchar(100) NOT NULL,\n"
                    + "    description varchar(100) );"
                    + "\n"
                    + "DROP TABLE IF EXISTS \"USER_ROLE\";"
                    + "CREATE TABLE \"USER_ROLE\" (\n"
                    + "    id bigserial primary key,\n"
                    + "    user_id varchar(100) ,\n"
                    + "    \"role_id\" varchar(100) \n"
                    + ");"
                    + "\n"
                    + "INSERT INTO \"USER\" (name, birthday,\"login_ID\", city, email)\n"
                    + "VALUES\n"
                    + "   ('Kolya', '1994-01-08','<null>' ,'Varoneg','Kolya@administration.ru'),\n"
                    + "   ('Vova', '1987-02-09','<null>' , 'Minsk','Vova@clients.ru'),\n"
                    + "   ('Sonya', '2002-03-08','<null>' , 'Tambop','Sonya@clients.ru'),\n"
                    + "   ('Marusya', '1456-01-12','<null>' , 'Moskva','Marusya@billing.ru'),\n"
                    + "   ('Marusya', '1956-01-12','<null>' , 'Moskva','Masha@clients.ru'),\n"
                    + "   ('Natasha', '1456-01-12','<null>' , 'Djerjinsk','Natasha@billing.ru'),\n"
                    + "   ('Moli', '1765-12-11','<null>' , 'Samara','Moli@administration.ru');"
            );
        }
        CreationBaseUser creationBaseUser = new CreationBaseUser();
        creationBaseUser.FormatLoginId();
        creationBaseUser.FormationRole();
        creationBaseUser.FormationRoleUser();
    }

    void FormatLoginId() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD.get());
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

    void FormationRole() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD.get());
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

    void FormationRoleUser() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD.get());
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            ResultSet rsu;
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
