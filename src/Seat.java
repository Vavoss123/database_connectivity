public class Seat {
    private int seatId;
    private int venueId;
    private String rowLabel;
    private int seatNumber;
    private boolean isWheelchairAccessible;

    // Constructors
    public Seat() {}

    public Seat(int seatId, int venueId, String rowLabel, int seatNumber, boolean isWheelchairAccessible) {
        this.seatId = seatId;
        this.venueId = venueId;
        this.rowLabel = rowLabel;
        this.seatNumber = seatNumber;
        this.isWheelchairAccessible = isWheelchairAccessible;
    }

    // Getters and Setters
    public int getSeatId() { return seatId; }
    public void setSeatId(int seatId) { this.seatId = seatId; }

    public int getVenueId() { return venueId; }
    public void setVenueId(int venueId) { this.venueId = venueId; }

    public String getRowLabel() { return rowLabel; }
    public void setRowLabel(String rowLabel) { this.rowLabel = rowLabel; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public boolean isWheelchairAccessible() { return isWheelchairAccessible; }
    public void setWheelchairAccessible(boolean wheelchairAccessible) { isWheelchairAccessible = wheelchairAccessible; }
}
