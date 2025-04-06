import java.sql.Timestamp;

public class Meeting {
    private int meetingId;
    private Timestamp schedule;
    private String organiser;
    private String purpose;
    private int showId;
    private String clientId;

    // Constructors
    public Meeting() {}

    public Meeting(int meetingId, Timestamp schedule, String organiser, String purpose, int showId, String clientId) {
        this.meetingId = meetingId;
        this.schedule = schedule;
        this.organiser = organiser;
        this.purpose = purpose;
        this.showId = showId;
        this.clientId = clientId;
    }

    // Getters and Setters
    public int getMeetingId() { return meetingId; }
    public void setMeetingId(int meetingId) { this.meetingId = meetingId; }

    public Timestamp getSchedule() { return schedule; }
    public void setSchedule(Timestamp schedule) { this.schedule = schedule; }

    public String getOrganiser() { return organiser; }
    public void setOrganiser(String organiser) { this.organiser = organiser; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }
}
