import java.sql.Date;
import java.sql.Time;

public class Screening {
    private int screeningId;
    private Date screeningDate;
    private Time startTime;
    private int filmId;
    private double price;
    private int venueId;

    // Constructors
    public Screening() {}

    public Screening(int screeningId, Date screeningDate, Time startTime, int filmId, double price, int venueId) {
        this.screeningId = screeningId;
        this.screeningDate = screeningDate;
        this.startTime = startTime;
        this.filmId = filmId;
        this.price = price;
        this.venueId = venueId;
    }

    // Getters and Setters
    public int getScreeningId() { return screeningId; }
    public void setScreeningId(int screeningId) { this.screeningId = screeningId; }

    public Date getScreeningDate() { return screeningDate; }
    public void setScreeningDate(Date screeningDate) { this.screeningDate = screeningDate; }

    public Time getStartTime() { return startTime; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getVenueId() { return venueId; }
    public void setVenueId(int venueId) { this.venueId = venueId; }
}
