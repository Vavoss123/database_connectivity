import java.sql.*;
import java.util.ArrayList;

public class ScreeningDAO {

    // CREATE
    public static boolean insertScreening(Screening s) {
        String sql = "INSERT INTO Screening (screeningDate, startTime, filmId, price, venueId) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, s.getScreeningDate());
            stmt.setTime(2, s.getStartTime());
            stmt.setInt(3, s.getFilmId());
            stmt.setDouble(4, s.getPrice());
            stmt.setInt(5, s.getVenueId());

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
                        rs.getInt("screeningId"),
                        rs.getDate("screeningDate"),
                        rs.getTime("startTime"),
                        rs.getInt("filmId"),
                        rs.getDouble("price"),
                        rs.getInt("venueId")
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
        String sql = "SELECT * FROM Screening WHERE screeningId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Screening(
                        rs.getInt("screeningId"),
                        rs.getDate("screeningDate"),
                        rs.getTime("startTime"),
                        rs.getInt("filmId"),
                        rs.getDouble("price"),
                        rs.getInt("venueId")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateScreening(Screening s) {
        String sql = "UPDATE Screening SET screeningDate = ?, startTime = ?, filmId = ?, price = ?, venueId = ? WHERE screeningId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, s.getScreeningDate());
            stmt.setTime(2, s.getStartTime());
            stmt.setInt(3, s.getFilmId());
            stmt.setDouble(4, s.getPrice());
            stmt.setInt(5, s.getVenueId());
            stmt.setInt(6, s.getScreeningId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteScreening(int id) {
        String sql = "DELETE FROM Screening WHERE screeningId = ?";

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
