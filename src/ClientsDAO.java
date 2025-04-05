import java.sql.*;
import java.util.ArrayList;

public class ClientsDAO {

    // CREATE
    public static boolean insertClient(Clients c) {
        String sql = "INSERT INTO Client (companyId, companyName, contactName, contactEmail, phoneNumber, " +
                "streetAddress, city, postcode, billingName, billingEmailAddress) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getCompanyId());
            stmt.setString(2, c.getCompanyName());
            stmt.setString(3, c.getContactName());
            stmt.setString(4, c.getContactEmail());
            stmt.setString(5, c.getPhoneNumber());
            stmt.setString(6, c.getStreetAddress());
            stmt.setString(7, c.getCity());
            stmt.setString(8, c.getPostcode());
            stmt.setString(9, c.getBillingName());
            stmt.setString(10, c.getBillingEmail());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Clients> getAllClients() {
        ArrayList<Clients> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Clients c = new Clients(
                        rs.getString("companyId"),
                        rs.getString("companyName"),
                        rs.getString("contactName"),
                        rs.getString("contactEmail"),
                        rs.getString("phoneNumber"),
                        rs.getString("streetAddress"),
                        rs.getString("city"),
                        rs.getString("postcode"),
                        rs.getString("billingName"),
                        rs.getString("billingEmailAddress")
                );
                clients.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    // READ ONE
    public static Clients getClientById(String companyId) {
        String sql = "SELECT * FROM Client WHERE companyId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, companyId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Clients(
                        rs.getString("companyId"),
                        rs.getString("companyName"),
                        rs.getString("contactName"),
                        rs.getString("contactEmail"),
                        rs.getString("phoneNumber"),
                        rs.getString("streetAddress"),
                        rs.getString("city"),
                        rs.getString("postcode"),
                        rs.getString("billingName"),
                        rs.getString("billingEmailAddress")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateClient(Clients c) {
        String sql = "UPDATE Client SET companyName = ?, contactName = ?, contactEmail = ?, phoneNumber = ?, " +
                "streetAddress = ?, city = ?, postcode = ?, billingName = ?, billingEmailAddress = ? " +
                "WHERE companyId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getCompanyName());
            stmt.setString(2, c.getContactName());
            stmt.setString(3, c.getContactEmail());
            stmt.setString(4, c.getPhoneNumber());
            stmt.setString(5, c.getStreetAddress());
            stmt.setString(6, c.getCity());
            stmt.setString(7, c.getPostcode());
            stmt.setString(8, c.getBillingName());
            stmt.setString(9, c.getBillingEmail());
            stmt.setString(10, c.getCompanyId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteClient(String companyId) {
        String sql = "DELETE FROM Client WHERE companyId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, companyId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
