import java.sql.*;
import java.util.ArrayList;

public class TourDAO {

    // CREATE
    public static boolean insertTour(Tour t) {
        String sql = "INSERT INTO Tours (title, description, date, venues, showID) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getTitle());
            stmt.setString(2, t.getDescription());
            stmt.setDate(3, t.getDate());
            stmt.setString(4, t.getVenues());
            stmt.setInt(5, t.getShowId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Tour> getAllTours() {
        ArrayList<Tour> tours = new ArrayList<>();
        String sql = "SELECT * FROM Tours";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tour t = new Tour(
                        rs.getInt("tourID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("date"),
                        rs.getString("venues"),
                        rs.getInt("showID")
                );
                tours.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tours;
    }

    // READ ONE
    public static Tour getTourById(int id) {
        String sql = "SELECT * FROM Tours WHERE tourID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Tour(
                        rs.getInt("tourID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("date"),
                        rs.getString("venues"),
                        rs.getInt("showID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateTour(Tour t) {
        String sql = "UPDATE Tours SET title = ?, description = ?, date = ?, venues = ?, showID = ? WHERE tourID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getTitle());
            stmt.setString(2, t.getDescription());
            stmt.setDate(3, t.getDate());
            stmt.setString(4, t.getVenues());
            stmt.setInt(5, t.getShowId());
            stmt.setInt(6, t.getTourId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteTour(int id) {
        String sql = "DELETE FROM Tours WHERE tourID = ?";

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
