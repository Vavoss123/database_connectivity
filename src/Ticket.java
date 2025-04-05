import java.sql.Timestamp;

public class Ticket {
    private int ticketId;
    private int bookingId;
    private int seatId;
    private double price;
    private int discountId;
    private Timestamp purchaseDatetime;

    // Constructors
    public Ticket() {}

    public Ticket(int ticketId, int bookingId, int seatId, double price, int discountId, Timestamp purchaseDatetime) {
        this.ticketId = ticketId;
        this.bookingId = bookingId;
        this.seatId = seatId;
        this.price = price;
        this.discountId = discountId;
        this.purchaseDatetime = purchaseDatetime;
    }

    // Getters and Setters
    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getSeatId() { return seatId; }
    public void setSeatId(int seatId) { this.seatId = seatId; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getDiscountId() { return discountId; }
    public void setDiscountId(int discountId) { this.discountId = discountId; }

    public Timestamp getPurchaseDatetime() { return purchaseDatetime; }
    public void setPurchaseDatetime(Timestamp purchaseDatetime) { this.purchaseDatetime = purchaseDatetime; }
}
