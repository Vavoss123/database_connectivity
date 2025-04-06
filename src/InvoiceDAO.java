import java.sql.*;
import java.util.ArrayList;

public class InvoiceDAO {

    // CREATE
    public static boolean insertInvoice(Invoice i) {
        String sql = "INSERT INTO Invoice (issueDate, dueDate, clientID, meetingID) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, i.getIssueDate());
            stmt.setDate(2, i.getDueDate());
            stmt.setString(3, i.getClientId());
            stmt.setInt(4, i.getMeetingId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Invoice> getAllInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<>();
        String sql = "SELECT * FROM Invoice";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Invoice i = new Invoice(
                        rs.getInt("invoiceID"),
                        rs.getDate("issueDate"),
                        rs.getDate("dueDate"),
                        rs.getString("clientID"),
                        rs.getInt("meetingID")
                );
                invoices.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoices;
    }

    // READ ONE
    public static Invoice getInvoiceById(int invoiceId) {
        String sql = "SELECT * FROM Invoice WHERE invoiceID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, invoiceId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Invoice(
                        rs.getInt("invoiceID"),
                        rs.getDate("issueDate"),
                        rs.getDate("dueDate"),
                        rs.getString("clientID"),
                        rs.getInt("meetingID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateInvoice(Invoice i) {
        String sql = "UPDATE Invoice SET issueDate = ?, dueDate = ?, clientID = ?, meetingID = ? WHERE invoiceID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, i.getIssueDate());
            stmt.setDate(2, i.getDueDate());
            stmt.setString(3, i.getClientId());
            stmt.setInt(4, i.getMeetingId());
            stmt.setInt(5, i.getInvoiceId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteInvoice(int invoiceId) {
        String sql = "DELETE FROM Invoice WHERE invoiceID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, invoiceId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
