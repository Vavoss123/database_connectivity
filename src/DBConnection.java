import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://sst-stuproj.city.ac.uk:3306/in2033t36";
    private static final String USER = "in2033t36_a";
    private static final String PASSWORD = "9mwPO-256sg";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            // This ensures the JDBC driver is loaded explicitly (sometimes required)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // log the issue if the driver isn't found
        }

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
