package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler {
    private static Connection connection;

    private DbHandler() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgres", "123");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
