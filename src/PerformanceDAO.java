import java.sql.*;
import java.util.ArrayList;

public class PerformanceDAO {

    // CREATE
    public static boolean insertPerformance(Performance p) {
        String sql = "INSERT INTO Performance (title, description, performanceType, startDateTime, endDateTime, venueId) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getTitle());
            stmt.setString(2, p.getDescription());
            stmt.setString(3, p.getPerformanceType());
            stmt.setTimestamp(4, p.getStartDatetime());
            stmt.setTimestamp(5, p.getEndDatetime());
            stmt.setInt(6, p.getVenueId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Performance> getAllPerformances() {
        ArrayList<Performance> performances = new ArrayList<>();
        String sql = "SELECT * FROM Performance";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Performance p = new Performance(
                        rs.getInt("performanceId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("performanceType"),
                        rs.getTimestamp("startDateTime"),
                        rs.getTimestamp("endDateTime"),
                        rs.getInt("venueId")
                );
                performances.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return performances;
    }

    // READ ONE
    public static Performance getPerformanceById(int id) {
        String sql = "SELECT * FROM Performance WHERE performanceId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Performance(
                        rs.getInt("performanceId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("performanceType"),
                        rs.getTimestamp("startDateTime"),
                        rs.getTimestamp("endDateTime"),
                        rs.getInt("venueId")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updatePerformance(Performance p) {
        String sql = "UPDATE Performance SET title = ?, description = ?, performanceType = ?, startDateTime = ?, endDateTime = ?, venueId = ? WHERE performanceId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getTitle());
            stmt.setString(2, p.getDescription());
            stmt.setString(3, p.getPerformanceType());
            stmt.setTimestamp(4, p.getStartDatetime());
            stmt.setTimestamp(5, p.getEndDatetime());
            stmt.setInt(6, p.getVenueId());
            stmt.setInt(7, p.getPerformanceId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deletePerformance(int id) {
        String sql = "DELETE FROM Performance WHERE performanceId = ?";

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
