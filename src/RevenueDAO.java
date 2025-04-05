import java.sql.*;
import java.util.ArrayList;

public class RevenueDAO {

    // CREATE
    public static boolean insertRevenue(Revenue r) {
        String sql = "INSERT INTO Revenue (bookingId, totalAmount, revenueDate) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, r.getBookingId());
            stmt.setDouble(2, r.getTotalAmount());
            stmt.setTimestamp(3, r.getRevenueDate());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Revenue> getAllRevenue() {
        ArrayList<Revenue> revenues = new ArrayList<>();
        String sql = "SELECT * FROM Revenue";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Revenue r = new Revenue(
                        rs.getInt("revenueId"),
                        rs.getInt("bookingId"),
                        rs.getDouble("totalAmount"),
                        rs.getTimestamp("revenueDate")
                );
                revenues.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return revenues;
    }

    // READ ONE
    public static Revenue getRevenueById(int id) {
        String sql = "SELECT * FROM Revenue WHERE revenueId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Revenue(
                        rs.getInt("revenueId"),
                        rs.getInt("bookingId"),
                        rs.getDouble("totalAmount"),
                        rs.getTimestamp("revenueDate")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateRevenue(Revenue r) {
        String sql = "UPDATE Revenue SET bookingId = ?, totalAmount = ?, revenueDate = ? WHERE revenueId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, r.getBookingId());
            stmt.setDouble(2, r.getTotalAmount());
            stmt.setTimestamp(3, r.getRevenueDate());
            stmt.setInt(4, r.getRevenueId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteRevenue(int id) {
        String sql = "DELETE FROM Revenue WHERE revenueId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
