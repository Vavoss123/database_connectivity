import java.sql.*;
import java.util.ArrayList;

public class TicketDAO {

    // CREATE
    public static boolean insertTicket(Ticket t) {
        String sql = "INSERT INTO Ticket (bookingId, seatId, price, discountId, purchaseDatetime) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getBookingId());
            stmt.setInt(2, t.getSeatId());
            stmt.setDouble(3, t.getPrice());
            stmt.setInt(4, t.getDiscountId());
            stmt.setTimestamp(5, t.getPurchaseDatetime());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Ticket> getAllTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM Ticket";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ticket t = new Ticket(
                        rs.getInt("ticketId"),
                        rs.getInt("bookingId"),
                        rs.getInt("seatId"),
                        rs.getDouble("price"),
                        rs.getInt("discountId"),
                        rs.getTimestamp("purchaseDatetime")
                );
                tickets.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    // READ ONE
    public static Ticket getTicketById(int id) {
        String sql = "SELECT * FROM Ticket WHERE ticketId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Ticket(
                        rs.getInt("ticketId"),
                        rs.getInt("bookingId"),
                        rs.getInt("seatId"),
                        rs.getDouble("price"),
                        rs.getInt("discountId"),
                        rs.getTimestamp("purchaseDatetime")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateTicket(Ticket t) {
        String sql = "UPDATE Ticket SET bookingId = ?, seatId = ?, price = ?, discountId = ?, purchaseDatetime = ? WHERE ticketId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getBookingId());
            stmt.setInt(2, t.getSeatId());
            stmt.setDouble(3, t.getPrice());
            stmt.setInt(4, t.getDiscountId());
            stmt.setTimestamp(5, t.getPurchaseDatetime());
            stmt.setInt(6, t.getTicketId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteTicket(int id) {
        String sql = "DELETE FROM Ticket WHERE ticketId = ?";

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
