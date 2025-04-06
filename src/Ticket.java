public class Ticket {
    private int ticketId;
    private double price;
    private int filmId;

    // Constructors
    public Ticket() {}

    public Ticket(int ticketId, double price, int filmId) {
        this.ticketId = ticketId;
        this.price = price;
        this.filmId = filmId;
    }

    // Getters and Setters
    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }
}
