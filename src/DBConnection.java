import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing the database connection to the MySQL server.
 * This class provides methods to establish and close connections to the project database.
 */
public class DBConnection {

    // Database credentials and URL
    private static final String URL = "jdbc:mysql://sst-stuproj.city.ac.uk:3306/in2033t36";
    private static final String USER = "in2033t36_a";
    private static final String PASSWORD = "9mwPO-256sg";

    // Single connection instance
    private static Connection connection;

    /**
     * Retrieves a connection to the database. If a connection does not already exist or is closed,
     * a new one is established.
     *
     * @return a valid database connection
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Log error if driver is not found
        }

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }

        return connection;
    }

    /**
     * Closes the current database connection if it is open.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
