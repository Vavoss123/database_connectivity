import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Screening {
    private int screeningId;
    private Date date;
    private int screenNumber;
    private String venue;
    private int orderId;
    private Time startTime;
    private BigDecimal price;

    // Constructors
    public Screening() {}

    public Screening(int screeningId, Date date, int screenNumber, String venue, int orderId, Time startTime, BigDecimal price) {
        this.screeningId = screeningId;
        this.date = date;
        this.screenNumber = screenNumber;
        this.venue = venue;
        this.orderId = orderId;
        this.startTime = startTime;
        this.price = price;
    }

    // Getters and Setters
    public int getScreeningId() { return screeningId; }
    public void setScreeningId(int screeningId) { this.screeningId = screeningId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public int getScreenNumber() { return screenNumber; }
    public void setScreenNumber(int screenNumber) { this.screenNumber = screenNumber; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Time getStartTime() { return startTime; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
