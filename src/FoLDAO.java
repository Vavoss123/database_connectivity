import java.sql.*;
import java.util.ArrayList;

public class FoLDAO {

    // CREATE
    public static boolean insertFoL(FoL f) {
        String sql = "INSERT INTO FoL (joinDate, membershipType, name, address, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, f.getJoinDate());
            stmt.setString(2, f.getMembershipType());
            stmt.setString(3, f.getName());
            stmt.setString(4, f.getAddress());
            stmt.setString(5, f.getEmail());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<FoL> getAllFoLs() {
        ArrayList<FoL> list = new ArrayList<>();
        String sql = "SELECT * FROM FoL";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                FoL f = new FoL(
                        rs.getInt("folID"),
                        rs.getDate("joinDate"),
                        rs.getString("membershipType"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                );
                list.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // READ ONE
    public static FoL getFoLById(int id) {
        String sql = "SELECT * FROM FoL WHERE folID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new FoL(
                        rs.getInt("folID"),
                        rs.getDate("joinDate"),
                        rs.getString("membershipType"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateFoL(FoL f) {
        String sql = "UPDATE FoL SET joinDate = ?, membershipType = ?, name = ?, address = ?, email = ? WHERE folID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, f.getJoinDate());
            stmt.setString(2, f.getMembershipType());
            stmt.setString(3, f.getName());
            stmt.setString(4, f.getAddress());
            stmt.setString(5, f.getEmail());
            stmt.setInt(6, f.getFolId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteFoL(int id) {
        String sql = "DELETE FROM FoL WHERE folID = ?";

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
