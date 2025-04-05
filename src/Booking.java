import java.sql.Date;
import java.sql.Timestamp;

public class Booking {
    private int bookingId;
    private String companyId; // changed from int clientId
    private int performanceId;
    private Timestamp bookingDate;
    private Date startDate;
    private Date endDate;
    private double totalCost;
    private int numberOfSeats;

    public Booking(int bookingId, String companyId, int performanceId, Timestamp bookingDate,
                   Date startDate, Date endDate, double totalCost, int numberOfSeats) {
        this.bookingId = bookingId;
        this.companyId = companyId;
        this.performanceId = performanceId;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.numberOfSeats = numberOfSeats;
    }

    // Getters and setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public String getCompanyId() { return companyId; }
    public void setCompanyId(String companyId) { this.companyId = companyId; }

    public int getPerformanceId() { return performanceId; }
    public void setPerformanceId(int performanceId) { this.performanceId = performanceId; }

    public Timestamp getBookingDate() { return bookingDate; }
    public void setBookingDate(Timestamp bookingDate) { this.bookingDate = bookingDate; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public int getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
}
