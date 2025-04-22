import java.sql.*;
import java.util.ArrayList;

public class MeetingDAO {

    // CREATE
    public static boolean insertMeeting(Meeting m) {
        String sql = "INSERT INTO Meeting (schedule, organiser, purpose, date, startTime, showID, clientID, room) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, m.getSchedule());
            stmt.setString(2, m.getOrganiser());
            stmt.setString(3, m.getPurpose());
            stmt.setDate(4, m.getDate());
            stmt.setTime(5, m.getStartTime());
            stmt.setInt(6, m.getShowId());
            stmt.setString(7, m.getClientId());
            stmt.setString(8, m.getRoom());

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
                        rs.getDate("date"),
                        rs.getTime("startTime"),
                        rs.getInt("showID"),
                        rs.getString("clientID"),
                        rs.getString("room")
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
                        rs.getDate("date"),
                        rs.getTime("startTime"),
                        rs.getInt("showID"),
                        rs.getString("clientID"),
                        rs.getString("room")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateMeeting(Meeting m) {
        String sql = "UPDATE Meeting SET schedule = ?, organiser = ?, purpose = ?, date = ?, startTime = ?, showID = ?, clientID = ?, room = ? WHERE meetingID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, m.getSchedule());
            stmt.setString(2, m.getOrganiser());
            stmt.setString(3, m.getPurpose());
            stmt.setDate(4, m.getDate());
            stmt.setTime(5, m.getStartTime());
            stmt.setInt(6, m.getShowId());
            stmt.setString(7, m.getClientId());
            stmt.setString(8, m.getRoom());
            stmt.setInt(9, m.getMeetingId());

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