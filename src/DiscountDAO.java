import java.sql.*;
import java.util.ArrayList;

public class DiscountDAO {

    // CREATE
    public static boolean insertDiscount(Discount d) {
        String sql = "INSERT INTO Discount (discountName, discountRate, validFrom, validTo) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getDiscountName());
            stmt.setDouble(2, d.getDiscountRate());
            stmt.setDate(3, d.getValidFrom());
            stmt.setDate(4, d.getValidTo());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Discount> getAllDiscounts() {
        ArrayList<Discount> discounts = new ArrayList<>();
        String sql = "SELECT * FROM Discount";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Discount d = new Discount(
                        rs.getInt("discountId"),
                        rs.getString("discountName"),
                        rs.getDouble("discountRate"),
                        rs.getDate("validFrom"),
                        rs.getDate("validTo")
                );
                discounts.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return discounts;
    }

    // READ ONE
    public static Discount getDiscountById(int id) {
        String sql = "SELECT * FROM Discount WHERE discountId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Discount(
                        rs.getInt("discountId"),
                        rs.getString("discountName"),
                        rs.getDouble("discountRate"),
                        rs.getDate("validFrom"),
                        rs.getDate("validTo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateDiscount(Discount d) {
        String sql = "UPDATE Discount SET discountName = ?, discountRate = ?, validFrom = ?, validTo = ? WHERE discountId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getDiscountName());
            stmt.setDouble(2, d.getDiscountRate());
            stmt.setDate(3, d.getValidFrom());
            stmt.setDate(4, d.getValidTo());
            stmt.setInt(5, d.getDiscountId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteDiscount(int id) {
        String sql = "DELETE FROM Discount WHERE discountId = ?";

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
