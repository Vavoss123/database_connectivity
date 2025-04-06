import java.sql.*;
import java.util.ArrayList;

public class MeetingDAO {

    // CREATE
    public static boolean insertMeeting(Meeting m) {
        String sql = "INSERT INTO Meeting (schedule, organiser, purpose, showID, clientID) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, m.getSchedule());
            stmt.setString(2, m.getOrganiser());
            stmt.setString(3, m.getPurpose());
            stmt.setInt(4, m.getShowId());
            stmt.setString(5, m.getClientId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Meeting> getAllMeetings() {
        ArrayList<Meeting> meetings = new ArrayList<>();
        String sql = "SELECT * FROM Meeting";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Meeting m = new Meeting(
                        rs.getInt("meetingID"),
                        rs.getTimestamp("schedule"),
                        rs.getString("organiser"),
                        rs.getString("purpose"),
                        rs.getInt("showID"),
                        rs.getString("clientID")
                );
                meetings.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meetings;
    }

    // READ ONE
    public static Meeting getMeetingById(int meetingId) {
        String sql = "SELECT * FROM Meeting WHERE meetingID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, meetingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Meeting(
                        rs.getInt("meetingID"),
                        rs.getTimestamp("schedule"),
                        rs.getString("organiser"),
                        rs.getString("purpose"),
                        rs.getInt("showID"),
                        rs.getString("clientID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateMeeting(Meeting m) {
        String sql = "UPDATE Meeting SET schedule = ?, organiser = ?, purpose = ?, showID = ?, clientID = ? WHERE meetingID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, m.getSchedule());
            stmt.setString(2, m.getOrganiser());
            stmt.setString(3, m.getPurpose());
            stmt.setInt(4, m.getShowId());
            stmt.setString(5, m.getClientId());
            stmt.setInt(6, m.getMeetingId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteMeeting(int meetingId) {
        String sql = "DELETE FROM Meeting WHERE meetingID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, meetingId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
