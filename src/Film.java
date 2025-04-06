import java.sql.Timestamp;

public class Film {
    private int filmId;
    private int runtime;
    private String distributor;
    private double cost;
    private int releaseYear;
    private String certificate;
    private Timestamp availableStart;
    private Timestamp availableEnd;

    // Constructors
    public Film() {}

    public Film(int filmId, int runtime, String distributor, double cost, int releaseYear, String certificate, Timestamp availableStart, Timestamp availableEnd) {
        this.filmId = filmId;
        this.runtime = runtime;
        this.distributor = distributor;
        this.cost = cost;
        this.releaseYear = releaseYear;
        this.certificate = certificate;
        this.availableStart = availableStart;
        this.availableEnd = availableEnd;
    }

    // Getters and Setters
    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }

    public String getDistributor() { return distributor; }
    public void setDistributor(String distributor) { this.distributor = distributor; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getCertificate() { return certificate; }
    public void setCertificate(String certificate) { this.certificate = certificate; }

    public Timestamp getAvailableStart() { return availableStart; }
    public void setAvailableStart(Timestamp availableStart) { this.availableStart = availableStart; }

    public Timestamp getAvailableEnd() { return availableEnd; }
    public void setAvailableEnd(Timestamp availableEnd) { this.availableEnd = availableEnd; }
}
