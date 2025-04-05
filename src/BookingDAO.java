import java.sql.*;
import java.util.ArrayList;

public class BookingDAO {

    // CREATE
    public static boolean insertBooking(Booking b) {
        String sql = "INSERT INTO Booking (companyId, performanceId, bookingDate, startDate, endDate, totalCost, numberOfSeats) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, b.getCompanyId()); // VARCHAR
            stmt.setInt(2, b.getPerformanceId());
            stmt.setTimestamp(3, b.getBookingDate());
            stmt.setDate(4, b.getStartDate());
            stmt.setDate(5, b.getEndDate());
            stmt.setDouble(6, b.getTotalCost());
            stmt.setInt(7, b.getNumberOfSeats());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Booking> getAllBookings() {
        ArrayList<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Booking b = new Booking(
                        rs.getInt("bookingId"),
                        rs.getString("companyId"),
                        rs.getInt("performanceId"),
                        rs.getTimestamp("bookingDate"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getDouble("totalCost"),
                        rs.getInt("numberOfSeats")
                );
                bookings.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // READ ONE
    public static Booking getBookingById(int id) {
        String sql = "SELECT * FROM Booking WHERE bookingId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Booking(
                        rs.getInt("bookingId"),
                        rs.getString("companyId"),
                        rs.getInt("performanceId"),
                        rs.getTimestamp("bookingDate"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getDouble("totalCost"),
                        rs.getInt("numberOfSeats")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateBooking(Booking b) {
        String sql = "UPDATE Booking SET companyId = ?, performanceId = ?, bookingDate = ?, startDate = ?, endDate = ?, totalCost = ?, numberOfSeats = ? " +
                "WHERE bookingId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, b.getCompanyId());
            stmt.setInt(2, b.getPerformanceId());
            stmt.setTimestamp(3, b.getBookingDate());
            stmt.setDate(4, b.getStartDate());
            stmt.setDate(5, b.getEndDate());
            stmt.setDouble(6, b.getTotalCost());
            stmt.setInt(7, b.getNumberOfSeats());
            stmt.setInt(8, b.getBookingId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteBooking(int id) {
        String sql = "DELETE FROM Booking WHERE bookingId = ?";

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
