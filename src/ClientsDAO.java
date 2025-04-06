import java.sql.*;
import java.util.ArrayList;

public class ClientsDAO {

    // CREATE
    public static boolean insertClient(Clients c) {
        String sql = "INSERT INTO Client (clientID, companyName, contactName, contactEmail, contactNumber, " +
                "streetAddress, city, postCode, billingName, billingEmail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getClientId());
            stmt.setString(2, c.getCompanyName());
            stmt.setString(3, c.getContactName());
            stmt.setString(4, c.getContactEmail());
            stmt.setString(5, c.getContactNumber());
            stmt.setString(6, c.getStreetAddress());
            stmt.setString(7, c.getCity());
            stmt.setString(8, c.getPostCode());
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
                        rs.getString("clientID"),
                        rs.getString("companyName"),
                        rs.getString("contactName"),
                        rs.getString("contactEmail"),
                        rs.getString("contactNumber"),
                        rs.getString("streetAddress"),
                        rs.getString("city"),
                        rs.getString("postCode"),
                        rs.getString("billingName"),
                        rs.getString("billingEmail")
                );
                clients.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    // READ ONE
    public static Clients getClientById(String clientId) {
        String sql = "SELECT * FROM Client WHERE clientID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, clientId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Clients(
                        rs.getString("clientID"),
                        rs.getString("companyName"),
                        rs.getString("contactName"),
                        rs.getString("contactEmail"),
                        rs.getString("contactNumber"),
                        rs.getString("streetAddress"),
                        rs.getString("city"),
                        rs.getString("postCode"),
                        rs.getString("billingName"),
                        rs.getString("billingEmail")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateClient(Clients c) {
        String sql = "UPDATE Client SET companyName = ?, contactName = ?, contactEmail = ?, contactNumber = ?, " +
                "streetAddress = ?, city = ?, postCode = ?, billingName = ?, billingEmail = ? WHERE clientID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getCompanyName());
            stmt.setString(2, c.getContactName());
            stmt.setString(3, c.getContactEmail());
            stmt.setString(4, c.getContactNumber());
            stmt.setString(5, c.getStreetAddress());
            stmt.setString(6, c.getCity());
            stmt.setString(7, c.getPostCode());
            stmt.setString(8, c.getBillingName());
            stmt.setString(9, c.getBillingEmail());
            stmt.setString(10, c.getClientId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteClient(String clientId) {
        String sql = "DELETE FROM Client WHERE clientID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, clientId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
