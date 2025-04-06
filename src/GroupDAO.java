import java.sql.*;
import java.util.ArrayList;

public class GroupDAO {

    // CREATE
    public static boolean insertGroup(Group g) {
        String sql = "INSERT INTO `Group` (groupSize, name, contactPerson) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, g.getGroupSize());
            stmt.setString(2, g.getName());
            stmt.setString(3, g.getContactPerson());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Group> getAllGroups() {
        ArrayList<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM `Group`";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Group g = new Group(
                        rs.getInt("groupID"),
                        rs.getInt("groupSize"),
                        rs.getString("name"),
                        rs.getString("contactPerson")
                );
                groups.add(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return groups;
    }

    // READ ONE
    public static Group getGroupById(int id) {
        String sql = "SELECT * FROM `Group` WHERE groupID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Group(
                        rs.getInt("groupID"),
                        rs.getInt("groupSize"),
                        rs.getString("name"),
                        rs.getString("contactPerson")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateGroup(Group g) {
        String sql = "UPDATE `Group` SET groupSize = ?, name = ?, contactPerson = ? WHERE groupID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, g.getGroupSize());
            stmt.setString(2, g.getName());
            stmt.setString(3, g.getContactPerson());
            stmt.setInt(4, g.getGroupId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteGroup(int id) {
        String sql = "DELETE FROM `Group` WHERE groupID = ?";

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