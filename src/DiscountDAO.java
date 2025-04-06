import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for the Discount entity.
 * Provides methods to perform CRUD operations on the Discount table.
 */
public class DiscountDAO {

    /**
     * Inserts a new discount into the database.
     *
     * @param d the Discount object to insert
     * @return true if insertion is successful, false otherwise
     */
    public static boolean insertDiscount(Discount d) {
        String sql = "INSERT INTO Discount (discountType, discountValue, groupSaleID, folID) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getDiscountType());
            stmt.setDouble(2, d.getDiscountValue());
            stmt.setInt(3, d.getGroupSaleId());
            stmt.setInt(4, d.getFolId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Retrieves all discounts from the database.
     *
     * @return an ArrayList of Discount objects
     */
    public static ArrayList<Discount> getAllDiscounts() {
        ArrayList<Discount> discounts = new ArrayList<>();
        String sql = "SELECT * FROM Discount";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Discount d = new Discount(
                        rs.getInt("discountId"),
                        rs.getString("discountType"),
                        rs.getDouble("discountValue"),
                        rs.getInt("groupSaleID"),
                        rs.getInt("folID")
                );
                discounts.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return discounts;
    }

    /**
     * Retrieves a single discount by its ID.
     *
     * @param id the ID of the discount to retrieve
     * @return the Discount object if found, otherwise null
     */
    public static Discount getDiscountById(int id) {
        String sql = "SELECT * FROM Discount WHERE discountId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Discount(
                        rs.getInt("discountId"),
                        rs.getString("discountType"),
                        rs.getDouble("discountValue"),
                        rs.getInt("groupSaleID"),
                        rs.getInt("folID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Updates an existing discount in the database.
     *
     * @param d the Discount object with updated values
     * @return true if the update is successful, false otherwise
     */
    public static boolean updateDiscount(Discount d) {
        String sql = "UPDATE Discount SET discountType = ?, discountValue = ?, groupSaleID = ?, folID = ? WHERE discountId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getDiscountType());
            stmt.setDouble(2, d.getDiscountValue());
            stmt.setInt(3, d.getGroupSaleId());
            stmt.setInt(4, d.getFolId());
            stmt.setInt(5, d.getDiscountId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes a discount from the database by ID.
     *
     * @param id the ID of the discount to delete
     * @return true if the deletion is successful, false otherwise
     */
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
