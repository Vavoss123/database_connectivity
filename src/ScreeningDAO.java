import java.sql.*;
import java.util.ArrayList;

public class ScreeningDAO {

    // CREATE
    public static boolean insertScreening(Screening s) {
        String sql = "INSERT INTO Screening (date, screenNumber, venue, order_id, start_time, price) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, s.getDate());
            stmt.setInt(2, s.getScreenNumber());
            stmt.setString(3, s.getVenue());
            stmt.setInt(4, s.getOrderId());
            stmt.setTime(5, s.getStartTime());
            stmt.setBigDecimal(6, s.getPrice());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Screening> getAllScreenings() {
        ArrayList<Screening> screenings = new ArrayList<>();
        String sql = "SELECT * FROM Screening";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Screening s = new Screening(
                        rs.getInt("screeningID"),
                        rs.getDate("date"),
                        rs.getInt("screenNumber"),
                        rs.getString("venue"),
                        rs.getInt("order_id"),
                        rs.getTime("start_time"),
                        rs.getBigDecimal("price")
                );
                screenings.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return screenings;
    }

    // READ ONE
    public static Screening getScreeningById(int id) {
        String sql = "SELECT * FROM Screening WHERE screeningID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Screening(
                        rs.getInt("screeningID"),
                        rs.getDate("date"),
                        rs.getInt("screenNumber"),
                        rs.getString("venue"),
                        rs.getInt("order_id"),
                        rs.getTime("start_time"),
                        rs.getBigDecimal("price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateScreening(Screening s) {
        String sql = "UPDATE Screening SET date = ?, screenNumber = ?, venue = ?, order_id = ?, start_time = ?, price = ? WHERE screeningID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, s.getDate());
            stmt.setInt(2, s.getScreenNumber());
            stmt.setString(3, s.getVenue());
            stmt.setInt(4, s.getOrderId());
            stmt.setTime(5, s.getStartTime());
            stmt.setBigDecimal(6, s.getPrice());
            stmt.setInt(7, s.getScreeningId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteScreening(int id) {
        String sql = "DELETE FROM Screening WHERE screeningID = ?";

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
