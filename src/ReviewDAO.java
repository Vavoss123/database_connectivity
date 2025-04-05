import java.sql.*;
import java.util.ArrayList;

public class ReviewDAO {

    // CREATE
    public static boolean insertReview(Review r) {
        String sql = "INSERT INTO Review (performanceId, companyId, rating, comment, reviewDate) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, r.getPerformanceId());
            stmt.setString(2, r.getCompanyId());
            stmt.setInt(3, r.getRating());
            stmt.setString(4, r.getComment());
            stmt.setTimestamp(5, r.getReviewDate());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Review> getAllReviews() {
        ArrayList<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM Review";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Review r = new Review(
                        rs.getInt("reviewId"),
                        rs.getInt("performanceId"),
                        rs.getString("companyId"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getTimestamp("reviewDate")
                );
                reviews.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }

    // READ ONE
    public static Review getReviewById(int id) {
        String sql = "SELECT * FROM Review WHERE reviewId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Review(
                        rs.getInt("reviewId"),
                        rs.getInt("performanceId"),
                        rs.getString("companyId"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getTimestamp("reviewDate")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateReview(Review r) {
        String sql = "UPDATE Review SET performanceId = ?, companyId = ?, rating = ?, comment = ?, reviewDate = ? WHERE reviewId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, r.getPerformanceId());
            stmt.setString(2, r.getCompanyId());
            stmt.setInt(3, r.getRating());
            stmt.setString(4, r.getComment());
            stmt.setTimestamp(5, r.getReviewDate());
            stmt.setInt(6, r.getReviewId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteReview(int id) {
        String sql = "DELETE FROM Review WHERE reviewId = ?";

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
