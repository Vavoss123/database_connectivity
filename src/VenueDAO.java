import java.sql.*;
import java.util.ArrayList;

public class VenueDAO {

    // CREATE
    public static boolean insertVenue(Venue v) {
        String sql = "INSERT INTO Venue (name, capacity, venueType, description) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, v.getName());
            stmt.setInt(2, v.getCapacity());
            stmt.setString(3, v.getVenueType());
            stmt.setString(4, v.getDescription());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Venue> getAllVenues() {
        ArrayList<Venue> venues = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Venue")) {

            while (rs.next()) {
                Venue v = new Venue(
                        rs.getInt("venueId"),
                        rs.getString("name"),
                        rs.getInt("capacity"),
                        rs.getString("venueType"),
                        rs.getString("description")
                );
                venues.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venues;
    }

    // READ ONE
    public static Venue getVenueById(int id) {
        String sql = "SELECT * FROM Venue WHERE venueId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Venue(
                        rs.getInt("venueId"),
                        rs.getString("name"),
                        rs.getInt("capacity"),
                        rs.getString("venueType"),
                        rs.getString("description")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateVenue(Venue v) {
        String sql = "UPDATE Venue SET name = ?, capacity = ?, venueType = ?, description = ? WHERE venueId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, v.getName());
            stmt.setInt(2, v.getCapacity());
            stmt.setString(3, v.getVenueType());
            stmt.setString(4, v.getDescription());
            stmt.setInt(5, v.getVenueId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteVenue(int id) {
        String sql = "DELETE FROM Venue WHERE venueId = ?";

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
