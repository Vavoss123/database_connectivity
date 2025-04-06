import java.sql.*;
import java.util.ArrayList;

public class FilmDAO {

    // CREATE
    public static boolean insertFilm(Film f) {
        String sql = "INSERT INTO Film (runtime, distributor, cost, releaseYear, certificate, availableStart, availableEnd) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, f.getRuntime());
            stmt.setString(2, f.getDistributor());
            stmt.setDouble(3, f.getCost());
            stmt.setInt(4, f.getReleaseYear());
            stmt.setString(5, f.getCertificate());
            stmt.setTimestamp(6, f.getAvailableStart());
            stmt.setTimestamp(7, f.getAvailableEnd());

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
                        rs.getInt("runtime"),
                        rs.getString("distributor"),
                        rs.getDouble("cost"),
                        rs.getInt("releaseYear"),
                        rs.getString("certificate"),
                        rs.getTimestamp("availableStart"),
                        rs.getTimestamp("availableEnd")
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
                        rs.getInt("runtime"),
                        rs.getString("distributor"),
                        rs.getDouble("cost"),
                        rs.getInt("releaseYear"),
                        rs.getString("certificate"),
                        rs.getTimestamp("availableStart"),
                        rs.getTimestamp("availableEnd")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static boolean updateFilm(Film f) {
        String sql = "UPDATE Film SET runtime = ?, distributor = ?, cost = ?, releaseYear = ?, certificate = ?, availableStart = ?, availableEnd = ? WHERE filmId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, f.getRuntime());
            stmt.setString(2, f.getDistributor());
            stmt.setDouble(3, f.getCost());
            stmt.setInt(4, f.getReleaseYear());
            stmt.setString(5, f.getCertificate());
            stmt.setTimestamp(6, f.getAvailableStart());
            stmt.setTimestamp(7, f.getAvailableEnd());
            stmt.setInt(8, f.getFilmId());

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
