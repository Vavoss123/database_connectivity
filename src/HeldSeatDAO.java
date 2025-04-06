import java.sql.*;
import java.util.ArrayList;

public class HeldSeatDAO {

    // CREATE
    public static boolean insertHeldSeat(HeldSeat hs) {
        String sql = "INSERT INTO HeldSeats (seatNumber, status, screeningID, groupID, folID) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, hs.getSeatNumber());
            stmt.setString(2, hs.getStatus());
            stmt.setInt(3, hs.getScreeningId());
            stmt.setInt(4, hs.getGroupId());
            stmt.setInt(5, hs.getFolId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<HeldSeat> getAllHeldSeats() {
        ArrayList<HeldSeat> seats = new ArrayList<>();
        String sql = "SELECT * FROM HeldSeats";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                HeldSeat hs = new HeldSeat(
                        rs.getInt("seatID"),
                        rs.getInt("seatNumber"),
                        rs.getString("status"),
                        rs.getInt("screeningID"),
                        rs.getInt("groupID"),
                        rs.getInt("folID")
                );
                seats.add(hs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seats;
    }

    // READ ONE
    public static HeldSeat getHeldSeatById(int id) {
        String sql = "SELECT * FROM HeldSeats WHERE seatID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new HeldSeat(
                        rs.getInt("seatID"),
                        rs.getInt("seatNumber"),
                        rs.getString("status"),
                        rs.getInt("screeningID"),
                        rs.getInt("groupID"),
                        rs.getInt("folID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateHeldSeat(HeldSeat hs) {
        String sql = "UPDATE HeldSeats SET seatNumber = ?, status = ?, screeningID = ?, groupID = ?, folID = ? WHERE seatID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, hs.getSeatNumber());
            stmt.setString(2, hs.getStatus());
            stmt.setInt(3, hs.getScreeningId());
            stmt.setInt(4, hs.getGroupId());
            stmt.setInt(5, hs.getFolId());
            stmt.setInt(6, hs.getSeatId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteHeldSeat(int id) {
        String sql = "DELETE FROM HeldSeats WHERE seatID = ?";

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
