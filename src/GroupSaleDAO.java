import java.sql.*;
import java.util.ArrayList;

public class GroupSaleDAO {

    // CREATE
    public static boolean insertGroupSale(GroupSale gs) {
        String sql = "INSERT INTO GroupSale (saleDate, totalCost, groupID, showID) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, gs.getSaleDate());
            stmt.setDouble(2, gs.getTotalCost());
            stmt.setInt(3, gs.getGroupId());
            stmt.setInt(4, gs.getShowId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<GroupSale> getAllGroupSales() {
        ArrayList<GroupSale> sales = new ArrayList<>();
        String sql = "SELECT * FROM GroupSale";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                GroupSale gs = new GroupSale(
                        rs.getInt("groupSaleID"),
                        rs.getDate("saleDate"),
                        rs.getDouble("totalCost"),
                        rs.getInt("groupID"),
                        rs.getInt("showID")
                );
                sales.add(gs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sales;
    }

    // READ ONE
    public static GroupSale getGroupSaleById(int id) {
        String sql = "SELECT * FROM GroupSale WHERE groupSaleID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new GroupSale(
                        rs.getInt("groupSaleID"),
                        rs.getDate("saleDate"),
                        rs.getDouble("totalCost"),
                        rs.getInt("groupID"),
                        rs.getInt("showID")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateGroupSale(GroupSale gs) {
        String sql = "UPDATE GroupSale SET saleDate = ?, totalCost = ?, groupID = ?, showID = ? WHERE groupSaleID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, gs.getSaleDate());
            stmt.setDouble(2, gs.getTotalCost());
            stmt.setInt(3, gs.getGroupId());
            stmt.setInt(4, gs.getShowId());
            stmt.setInt(5, gs.getGroupSaleId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteGroupSale(int id) {
        String sql = "DELETE FROM GroupSale WHERE groupSaleID = ?";

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
