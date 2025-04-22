import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Meeting {
    private int meetingId;
    private Timestamp schedule;
    private String organiser;
    private String purpose;
    private Date date;
    private Time startTime;
    private int showId;
    private String clientId;
    private String room;

    public Meeting() {}

    public Meeting(int meetingId, Timestamp schedule, String organiser, String purpose,
                   Date date, Time startTime, int showId, String clientId, String room) {
        this.meetingId = meetingId;
        this.schedule = schedule;
        this.organiser = organiser;
        this.purpose = purpose;
        this.date = date;
        this.startTime = startTime;
        this.showId = showId;
        this.clientId = clientId;
        this.room = room;
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

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Time getStartTime() { return startTime; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }
}