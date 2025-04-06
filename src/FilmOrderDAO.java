import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for handling FilmOrder database operations.
 */
public class FilmOrderDAO {

    /**
     * Inserts a new FilmOrder record into the database.
     *
     * @param fo the FilmOrder object to insert
     * @return true if insertion was successful, false otherwise
     */
    public static boolean insertFilmOrder(FilmOrder fo) {
        String sql = "INSERT INTO FilmOrder (filmId, start_date, end_date, price, notes) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fo.getFilmId());
            stmt.setTimestamp(2, fo.getStartDate());
            stmt.setTimestamp(3, fo.getEndDate());
            stmt.setDouble(4, fo.getPrice());
            stmt.setString(5, fo.getNotes());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Retrieves all FilmOrder records from the database.
     *
     * @return an ArrayList of FilmOrder objects
     */
    public static ArrayList<FilmOrder> getAllFilmOrders() {
        ArrayList<FilmOrder> orders = new ArrayList<>();
        String sql = "SELECT * FROM FilmOrder";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                FilmOrder fo = new FilmOrder(
                        rs.getInt("orderId"),
                        rs.getInt("filmId"),
                        rs.getTimestamp("start_date"),
                        rs.getTimestamp("end_date"),
                        rs.getDouble("price"),
                        rs.getString("notes")
                );
                orders.add(fo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    /**
     * Retrieves a single FilmOrder by its orderId.
     *
     * @param orderId the ID of the order to retrieve
     * @return the FilmOrder object if found, null otherwise
     */
    public static FilmOrder getFilmOrderById(int orderId) {
        String sql = "SELECT * FROM FilmOrder WHERE orderId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new FilmOrder(
                        rs.getInt("orderId"),
                        rs.getInt("filmId"),
                        rs.getTimestamp("start_date"),
                        rs.getTimestamp("end_date"),
                        rs.getDouble("price"),
                        rs.getString("notes")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Updates an existing FilmOrder in the database.
     *
     * @param fo the FilmOrder object containing updated data
     * @return true if update was successful, false otherwise
     */
    public static boolean updateFilmOrder(FilmOrder fo) {
        String sql = "UPDATE FilmOrder SET filmId = ?, start_date = ?, end_date = ?, price = ?, notes = ? WHERE orderId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fo.getFilmId());
            stmt.setTimestamp(2, fo.getStartDate());
            stmt.setTimestamp(3, fo.getEndDate());
            stmt.setDouble(4, fo.getPrice());
            stmt.setString(5, fo.getNotes());
            stmt.setInt(6, fo.getOrderId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes a FilmOrder record by its orderId.
     *
     * @param orderId the ID of the order to delete
     * @return true if deletion was successful, false otherwise
     */
    public static boolean deleteFilmOrder(int orderId) {
        String sql = "DELETE FROM FilmOrder WHERE orderId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, orderId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
