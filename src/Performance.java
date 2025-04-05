import java.sql.Timestamp;

public class Performance {
    private int performanceId;
    private String title;
    private String description;
    private String performanceType;
    private Timestamp startDatetime;
    private Timestamp endDatetime;
    private int venueId;

    // Constructors
    public Performance() {}

    public Performance(int performanceId, String title, String description, String performanceType,
                       Timestamp startDatetime, Timestamp endDatetime, int venueId) {
        this.performanceId = performanceId;
        this.title = title;
        this.description = description;
        this.performanceType = performanceType;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.venueId = venueId;
    }

    // Getters and Setters
    public int getPerformanceId() { return performanceId; }
    public void setPerformanceId(int performanceId) { this.performanceId = performanceId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPerformanceType() { return performanceType; }
    public void setPerformanceType(String performanceType) { this.performanceType = performanceType; }

    public Timestamp getStartDatetime() { return startDatetime; }
    public void setStartDatetime(Timestamp startDatetime) { this.startDatetime = startDatetime; }

    public Timestamp getEndDatetime() { return endDatetime; }
    public void setEndDatetime(Timestamp endDatetime) { this.endDatetime = endDatetime; }

    public int getVenueId() { return venueId; }
    public void setVenueId(int venueId) { this.venueId = venueId; }
}
