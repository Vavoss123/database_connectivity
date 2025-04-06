import java.sql.Date;

public class TicketSales {
    private int ticketSalesId;
    private int quantity;
    private Date saleDate;
    private int ticketId;
    private int tourId;

    // Constructors
    public TicketSales() {}

    public TicketSales(int ticketSalesId, int quantity, Date saleDate, int ticketId, int tourId) {
        this.ticketSalesId = ticketSalesId;
        this.quantity = quantity;
        this.saleDate = saleDate;
        this.ticketId = ticketId;
        this.tourId = tourId;
    }

    // Getters and Setters
    public int getTicketSalesId() { return ticketSalesId; }
    public void setTicketSalesId(int ticketSalesId) { this.ticketSalesId = ticketSalesId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Date getSaleDate() { return saleDate; }
    public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }

    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public int getTourId() { return tourId; }
    public void setTourId(int tourId) { this.tourId = tourId; }
}
