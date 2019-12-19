package part1.lesson15.utilities;

public class Utilities {
    public static final String URL = "jdbc:postgresql://localhost:5433/entity";
    public static final String USER = "postgres";
    public static final ThreadLocal<String> PASSWORD = ThreadLocal.withInitial(() -> "1234");
    public static final String INSERT_SQL
            = "INSERT INTO \"USER\"(name, birthday,\"login_ID\", city, email) VALUES (?,?,?,?,?)";
}
