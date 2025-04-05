import java.sql.Timestamp;

public class Revenue {
    private int revenueId;
    private int bookingId;
    private double totalAmount;
    private Timestamp revenueDate;

    public Revenue() {}

    public Revenue(int revenueId, int bookingId, double totalAmount, Timestamp revenueDate) {
        this.revenueId = revenueId;
        this.bookingId = bookingId;
        this.totalAmount = totalAmount;
        this.revenueDate = revenueDate;
    }

    public int getRevenueId() { return revenueId; }
    public void setRevenueId(int revenueId) { this.revenueId = revenueId; }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public Timestamp getRevenueDate() { return revenueDate; }
    public void setRevenueDate(Timestamp revenueDate) { this.revenueDate = revenueDate; }
}
