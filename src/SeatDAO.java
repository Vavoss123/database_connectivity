import java.sql.*;
import java.util.ArrayList;

public class SeatDAO {

    // CREATE
    public static boolean insertSeat(Seat s) {
        String sql = "INSERT INTO Seat (venueId, rowLabel, seatNumber, isWheelchairAccessible) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getVenueId());
            stmt.setString(2, s.getRowLabel());
            stmt.setInt(3, s.getSeatNumber());
            stmt.setBoolean(4, s.isWheelchairAccessible());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Seat> getAllSeats() {
        ArrayList<Seat> seats = new ArrayList<>();
        String sql = "SELECT * FROM Seat";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seat s = new Seat(
                        rs.getInt("seatId"),
                        rs.getInt("venueId"),
                        rs.getString("rowLabel"),
                        rs.getInt("seatNumber"),
                        rs.getBoolean("isWheelchairAccessible")
                );
                seats.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seats;
    }

    // READ ONE
    public static Seat getSeatById(int id) {
        String sql = "SELECT * FROM Seat WHERE seatId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Seat(
                        rs.getInt("seatId"),
                        rs.getInt("venueId"),
                        rs.getString("rowLabel"),
                        rs.getInt("seatNumber"),
                        rs.getBoolean("isWheelchairAccessible")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateSeat(Seat s) {
        String sql = "UPDATE Seat SET venueId = ?, rowLabel = ?, seatNumber = ?, isWheelchairAccessible = ? WHERE seatId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getVenueId());
            stmt.setString(2, s.getRowLabel());
            stmt.setInt(3, s.getSeatNumber());
            stmt.setBoolean(4, s.isWheelchairAccessible());
            stmt.setInt(5, s.getSeatId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteSeat(int id) {
        String sql = "DELETE FROM Seat WHERE seatId = ?";

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
