import java.sql.*;
import java.util.ArrayList;

public class ShowDAO {

    // CREATE
    public static boolean insertShow(Show s) {
        String sql = "INSERT INTO Show (duration, title, description, type) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getDuration());
            stmt.setString(2, s.getTitle());
            stmt.setString(3, s.getDescription());
            stmt.setString(4, s.getType());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Show> getAllShows() {
        ArrayList<Show> shows = new ArrayList<>();
        String sql = "SELECT * FROM Show";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Show s = new Show(
                        rs.getInt("showID"),
                        rs.getInt("duration"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("type")
                );
                shows.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shows;
    }

    // READ ONE
    public static Show getShowById(int showId) {
        String sql = "SELECT * FROM Show WHERE showID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, showId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Show(
                        rs.getInt("showID"),
                        rs.getInt("duration"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("type")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateShow(Show s) {
        String sql = "UPDATE Show SET duration = ?, title = ?, description = ?, type = ? WHERE showID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getDuration());
            stmt.setString(2, s.getTitle());
            stmt.setString(3, s.getDescription());
            stmt.setString(4, s.getType());
            stmt.setInt(5, s.getShowId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteShow(int showId) {
        String sql = "DELETE FROM Show WHERE showID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, showId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
