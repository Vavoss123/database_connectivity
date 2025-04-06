import java.sql.Date;

public class Invoice {
    private int invoiceId;
    private Date issueDate;
    private Date dueDate;
    private String clientId;
    private int meetingId;

    // Constructors
    public Invoice() {}

    public Invoice(int invoiceId, Date issueDate, Date dueDate, String clientId, int meetingId) {
        this.invoiceId = invoiceId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.clientId = clientId;
        this.meetingId = meetingId;
    }

    // Getters and Setters
    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public int getMeetingId() { return meetingId; }
    public void setMeetingId(int meetingId) { this.meetingId = meetingId; }
}
