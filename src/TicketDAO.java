import java.sql.*;
import java.util.ArrayList;

public class TicketDAO {

    // CREATE
    public static boolean insertTicket(Ticket t) {
        String sql = "INSERT INTO Ticket (price, filmId) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, t.getPrice());
            stmt.setInt(2, t.getFilmId());

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
                        rs.getInt("ticketID"),
                        rs.getDouble("price"),
                        rs.getInt("filmID")
                );
                tickets.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    // READ ONE
    public static Ticket getTicketById(int ticketId) {
        String sql = "SELECT * FROM Ticket WHERE ticketID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ticketId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Ticket(
                        rs.getInt("ticketID"),
                        rs.getDouble("price"),
                        rs.getInt("filmID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateTicket(Ticket t) {
        String sql = "UPDATE Ticket SET price = ?, filmID = ? WHERE ticketID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, t.getPrice());
            stmt.setInt(2, t.getFilmId());
            stmt.setInt(3, t.getTicketId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteTicket(int ticketId) {
        String sql = "DELETE FROM Ticket WHERE ticketID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ticketId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
