package part1.lesson15;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static part1.lesson05.utilities.MainUtilities.EMPTY;
import static part1.lesson15.utilities.Utilities.*;

class AddBaseUserTest {

    @Test
    void addBaseUser() throws SQLException, IOException {
        CreationTableMain creationTableMain = new CreationTableMain();
        Properties properties = new Properties();
        properties.load(new FileReader(URL_SQL_PROPERTIES));
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            connection.setAutoCommit(false);
            try (PreparedStatement insertStmt = connection.prepareStatement(INSERT_SQL)) {
                // 1 запись
                insertStmt.setString(1, "Sanya");
                insertStmt.setDate(2, Date.valueOf("2007-04-18"));
                insertStmt.setString(3, "<null>");
                insertStmt.setString(4, "Novgorod");
                insertStmt.setString(5, "Sanya@administration.ru");
                insertStmt.executeUpdate();

                // 2 запись
                insertStmt.setString(1, "Gosha");
                insertStmt.setDate(2, Date.valueOf("1978-11-11"));
                insertStmt.setString(3, "<null>");
                insertStmt.setString(4, "Senkino");
                insertStmt.setString(5, "Gosha@billing.ru");
                insertStmt.executeUpdate();
                // 3 запись
                insertStmt.setString(1, "Danya");
                insertStmt.setDate(2, Date.valueOf("2007-04-18"));
                insertStmt.setString(3, "<null>");
                insertStmt.setString(4, "Tula");
                insertStmt.setString(5, "Danya@administration.ru");
                insertStmt.executeUpdate();
                Savepoint savepoint = connection.setSavepoint("A"); // Создание Savepoint

                // 4 запись
                insertStmt.setString(1, "Semen");
                insertStmt.setDate(2, Date.valueOf("1234-12-11"));
                insertStmt.setString(3, "<null>");
                insertStmt.setString(4, "Orel");
                insertStmt.setString(5, "Semen@administration.ru");
                insertStmt.executeUpdate();

                // 5 запись
                insertStmt.setString(1, "Danniil");
                insertStmt.setDate(2, Date.valueOf("1456-04-10"));
                insertStmt.setString(3, "<null>");
                insertStmt.setString(4, "Skolkova");
                insertStmt.setString(5, "Danniil@clients.ru");
                insertStmt.executeUpdate();
                 connection.rollback(savepoint);     // Rollback к savepoint
                // Commit транзакции
                connection.commit();
                creationTableMain.FormatFourthColumnMainTable();
                ResultSet rsu;
                try (PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("select_TABLE_MAIN"))) {
                    rsu = preparedStatement.executeQuery();
                    if (rsu.getMetaData().getColumnCount() == 7) {
                        while (rsu.next()) {
                            System.out.println(rsu.getString(4));
                        }
                        System.out.println(EMPTY);
                    }
                }
            }
        }
    }
}