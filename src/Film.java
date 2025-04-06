import java.sql.Timestamp;

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

    // Constructors
    public Film() {}

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

    // Getters and Setters
    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getDistributor() { return distributor; }
    public void setDistributor(String distributor) { this.distributor = distributor; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getCertificate() { return certificate; }
    public void setCertificate(String certificate) { this.certificate = certificate; }

    public Timestamp getAvailableStart() { return availableStart; }
    public void setAvailableStart(Timestamp availableStart) { this.availableStart = availableStart; }

    public Timestamp getAvailableEnd() { return availableEnd; }
    public void setAvailableEnd(Timestamp availableEnd) { this.availableEnd = availableEnd; }
}
