public class HeldSeat {
    private int seatId;
    private int seatNumber;
    private String status;
    private int screeningId;
    private int groupId;
    private int folId;

    // Constructors
    public HeldSeat() {}

    public HeldSeat(int seatId, int seatNumber, String status, int screeningId, int groupId, int folId) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.status = status;
        this.screeningId = screeningId;
        this.groupId = groupId;
        this.folId = folId;
    }

    // Getters and Setters
    public int getSeatId() { return seatId; }
    public void setSeatId(int seatId) { this.seatId = seatId; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getScreeningId() { return screeningId; }
    public void setScreeningId(int screeningId) { this.screeningId = screeningId; }

    public int getGroupId() { return groupId; }
    public void setGroupId(int groupId) { this.groupId = groupId; }

    public int getFolId() { return folId; }
    public void setFolId(int folId) { this.folId = folId; }
}
