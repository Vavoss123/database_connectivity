import java.sql.*;
import java.util.ArrayList;

public class TicketSalesDAO {

    // CREATE
    public static boolean insertTicketSale(TicketSales t) {
        String sql = "INSERT INTO TicketSales (quantity, saleDate, ticketID, tourID) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getQuantity());
            stmt.setDate(2, t.getSaleDate());
            stmt.setInt(3, t.getTicketId());
            stmt.setInt(4, t.getTourId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<TicketSales> getAllTicketSales() {
        ArrayList<TicketSales> sales = new ArrayList<>();
        String sql = "SELECT * FROM TicketSales";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TicketSales t = new TicketSales(
                        rs.getInt("ticketSalesID"),
                        rs.getInt("quantity"),
                        rs.getDate("saleDate"),
                        rs.getInt("ticketID"),
                        rs.getInt("tourID")
                );
                sales.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sales;
    }

    // READ ONE
    public static TicketSales getTicketSaleById(int ticketSalesId) {
        String sql = "SELECT * FROM TicketSales WHERE ticketSalesID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ticketSalesId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new TicketSales(
                        rs.getInt("ticketSalesID"),
                        rs.getInt("quantity"),
                        rs.getDate("saleDate"),
                        rs.getInt("ticketID"),
                        rs.getInt("tourID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateTicketSale(TicketSales t) {
        String sql = "UPDATE TicketSales SET quantity = ?, saleDate = ?, ticketID = ?, tourID = ? WHERE ticketSalesID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getQuantity());
            stmt.setDate(2, t.getSaleDate());
            stmt.setInt(3, t.getTicketId());
            stmt.setInt(4, t.getTourId());
            stmt.setInt(5, t.getTicketSalesId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteTicketSale(int ticketSalesId) {
        String sql = "DELETE FROM TicketSales WHERE ticketSalesID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ticketSalesId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
