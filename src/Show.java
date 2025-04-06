public class Show {
    private int showId;
    private int duration;
    private String title;
    private String description;
    private String type;

    // Constructors
    public Show() {}

    public Show(int showId, int duration, String title, String description, String type) {
        this.showId = showId;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    // Getters and Setters
    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
