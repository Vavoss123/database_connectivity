import java.sql.Timestamp;

/**
 * Represents a film entity in the system with detailed attributes such as title, duration, genre, and availability.
 */
public class Film {
    private int filmId;
    private int duration;
    private String title;
    private String genre;
    private String director;
    private String distributor;
    private int releaseYear;
    private String certificate;
    private Timestamp availableStart;
    private Timestamp availableEnd;

    /**
     * Default constructor.
     */
    public Film() {}

    /**
     * Constructs a Film object with the given attributes.
     *
     * @param filmId the unique ID of the film
     * @param duration the duration of the film in minutes
     * @param title the title of the film
     * @param genre the genre of the film
     * @param director the director of the film
     * @param distributor the distributor of the film
     * @param releaseYear the release year of the film
     * @param certificate the certificate rating (e.g. PG, 15, 18)
     * @param availableStart the start timestamp for film availability
     * @param availableEnd the end timestamp for film availability
     */
    public Film(int filmId, int duration, String title, String genre, String director, String distributor,
                int releaseYear, String certificate, Timestamp availableStart, Timestamp availableEnd) {
        this.filmId = filmId;
        this.duration = duration;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.distributor = distributor;
        this.releaseYear = releaseYear;
        this.certificate = certificate;
        this.availableStart = availableStart;
        this.availableEnd = availableEnd;
    }

    /** @return the film ID */
    public int getFilmId() { return filmId; }

    /** @param filmId sets the film ID */
    public void setFilmId(int filmId) { this.filmId = filmId; }

    /** @return the duration of the film in minutes */
    public int getDuration() { return duration; }

    /** @param duration sets the film duration */
    public void setDuration(int duration) { this.duration = duration; }

    /** @return the film title */
    public String getTitle() { return title; }

    /** @param title sets the film title */
    public void setTitle(String title) { this.title = title; }

    /** @return the genre of the film */
    public String getGenre() { return genre; }

    /** @param genre sets the genre of the film */
    public void setGenre(String genre) { this.genre = genre; }

    /** @return the director of the film */
    public String getDirector() { return director; }

    /** @param director sets the director of the film */
    public void setDirector(String director) { this.director = director; }

    /** @return the distributor of the film */
    public String getDistributor() { return distributor; }

    /** @param distributor sets the distributor of the film */
    public void setDistributor(String distributor) { this.distributor = distributor; }

    /** @return the release year of the film */
    public int getReleaseYear() { return releaseYear; }

    /** @param releaseYear sets the release year of the film */
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    /** @return the certificate rating of the film */
    public String getCertificate() { return certificate; }

    /** @param certificate sets the certificate rating of the film */
    public void setCertificate(String certificate) { this.certificate = certificate; }

    /** @return the timestamp when the film becomes available */
    public Timestamp getAvailableStart() { return availableStart; }

    /** @param availableStart sets the start availability timestamp */
    public void setAvailableStart(Timestamp availableStart) { this.availableStart = availableStart; }

    /** @return the timestamp when the film is no longer available */
    public Timestamp getAvailableEnd() { return availableEnd; }

    /** @param availableEnd sets the end availability timestamp */
    public void setAvailableEnd(Timestamp availableEnd) { this.availableEnd = availableEnd; }
}
