import java.sql.Timestamp;

/**
 * Represents a Film Order entry in the system.
 * Each order includes the film being ordered, the time span for which it is booked,
 * its price, and optional notes.
 */
public class FilmOrder {
    private int orderId;
    private int filmId;
    private Timestamp startDate;
    private Timestamp endDate;
    private double price;
    private String notes;

    /**
     * Default constructor.
     */
    public FilmOrder() {}

    /**
     * Constructs a FilmOrder object with all fields.
     *
     * @param orderId the unique ID of the order
     * @param filmId the ID of the associated film
     * @param startDate the start datetime of the film booking
     * @param endDate the end datetime of the film booking
     * @param price the price of the film order
     * @param notes additional notes or remarks
     */
    public FilmOrder(int orderId, int filmId, Timestamp startDate, Timestamp endDate, double price, String notes) {
        this.orderId = orderId;
        this.filmId = filmId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.notes = notes;
    }

    /**
     * @return the order ID
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID.
     * @param orderId the unique identifier for the order
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the film ID
     */
    public int getFilmId() {
        return filmId;
    }

    /**
     * Sets the film ID.
     * @param filmId the identifier for the related film
     */
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    /**
     * @return the start datetime of the film order
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * Sets the start datetime.
     * @param startDate the starting timestamp of the order
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the end datetime of the film order
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * Sets the end datetime.
     * @param endDate the ending timestamp of the order
     */
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the price of the film order
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     * @param price the total cost of the film order
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return notes associated with the film order
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes.
     * @param notes any comments or information related to the order
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}