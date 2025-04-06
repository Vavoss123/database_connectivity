import java.sql.Date;

public class Tour {
    private int tourId;
    private String title;
    private String description;
    private Date date;
    private String venues;
    private int showId;

    // Constructors
    public Tour() {}

    public Tour(int tourId, String title, String description, Date date, String venues, int showId) {
        this.tourId = tourId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.venues = venues;
        this.showId = showId;
    }

    // Getters and Setters
    public int getTourId() { return tourId; }
    public void setTourId(int tourId) { this.tourId = tourId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getVenues() { return venues; }
    public void setVenues(String venues) { this.venues = venues; }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }
}
