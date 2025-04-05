import java.sql.*;
import java.util.ArrayList;

public class FilmDAO {

    // CREATE
    public static boolean insertFilm(Film f) {
        String sql = "INSERT INTO Film (performanceId, runtime, distributor, cost) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, f.getPerformanceId());
            stmt.setInt(2, f.getRuntime());
            stmt.setString(3, f.getDistributor());
            stmt.setDouble(4, f.getCost());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public static ArrayList<Film> getAllFilms() {
        ArrayList<Film> films = new ArrayList<>();
        String sql = "SELECT * FROM Film";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Film f = new Film(
                        rs.getInt("filmId"),
                        rs.getInt("performanceId"),
                        rs.getInt("runtime"),
                        rs.getString("distributor"),
                        rs.getDouble("cost")
                );
                films.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    // READ ONE
    public static Film getFilmById(int filmId) {
        String sql = "SELECT * FROM Film WHERE filmId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Film(
                        rs.getInt("filmId"),
                        rs.getInt("performanceId"),
                        rs.getInt("runtime"),
                        rs.getString("distributor"),
                        rs.getDouble("cost")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateFilm(Film f) {
        String sql = "UPDATE Film SET performanceId = ?, runtime = ?, distributor = ?, cost = ? WHERE filmId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, f.getPerformanceId());
            stmt.setInt(2, f.getRuntime());
            stmt.setString(3, f.getDistributor());
            stmt.setDouble(4, f.getCost());
            stmt.setInt(5, f.getFilmId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public static boolean deleteFilm(int filmId) {
        String sql = "DELETE FROM Film WHERE filmId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
