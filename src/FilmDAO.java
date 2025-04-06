import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for performing CRUD operations on the Film table.
 */
public class FilmDAO {

    /**
     * Inserts a new film into the database.
     *
     * @param f the Film object to insert
     * @return true if insertion is successful, false otherwise
     */
    public static boolean insertFilm(Film f) {
        String sql = "INSERT INTO Film (duration, title, genre, director, distributor, releaseYear, certificate, availableStart, availableEnd) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, f.getDuration());
            stmt.setString(2, f.getTitle());
            stmt.setString(3, f.getGenre());
            stmt.setString(4, f.getDirector());
            stmt.setString(5, f.getDistributor());
            stmt.setInt(6, f.getReleaseYear());
            stmt.setString(7, f.getCertificate());
            stmt.setTimestamp(8, f.getAvailableStart());
            stmt.setTimestamp(9, f.getAvailableEnd());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Retrieves all films from the database.
     *
     * @return an ArrayList of Film objects
     */
    public static ArrayList<Film> getAllFilms() {
        ArrayList<Film> films = new ArrayList<>();
        String sql = "SELECT * FROM Film";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Film f = new Film(
                        rs.getInt("filmId"),
                        rs.getInt("duration"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("director"),
                        rs.getString("distributor"),
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

    /**
     * Retrieves a single film by its ID.
     *
     * @param filmId the ID of the film to retrieve
     * @return the Film object, or null if not found
     */
    public static Film getFilmById(int filmId) {
        String sql = "SELECT * FROM Film WHERE filmId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Film(
                        rs.getInt("filmId"),
                        rs.getInt("duration"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("director"),
                        rs.getString("distributor"),
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

    /**
     * Updates an existing film in the database.
     *
     * @param f the Film object containing updated information
     * @return true if update is successful, false otherwise
     */
    public static boolean updateFilm(Film f) {
        String sql = "UPDATE Film SET duration = ?, title = ?, genre = ?, director = ?, distributor = ?, releaseYear = ?, certificate = ?, availableStart = ?, availableEnd = ? " +
                "WHERE filmId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, f.getDuration());
            stmt.setString(2, f.getTitle());
            stmt.setString(3, f.getGenre());
            stmt.setString(4, f.getDirector());
            stmt.setString(5, f.getDistributor());
            stmt.setInt(6, f.getReleaseYear());
            stmt.setString(7, f.getCertificate());
            stmt.setTimestamp(8, f.getAvailableStart());
            stmt.setTimestamp(9, f.getAvailableEnd());
            stmt.setInt(10, f.getFilmId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes a film from the database by its ID.
     *
     * @param filmId the ID of the film to delete
     * @return true if deletion is successful, false otherwise
     */
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
