public class Clients {
    private String clientId;
    private String companyName;
    private String contactName;
    private String contactEmail;
    private String contactNumber;
    private String streetAddress;
    private String city;
    private String postCode;
    private String billingName;
    private String billingEmail;

    public Clients() {}

    public Clients(String clientId, String companyName, String contactName, String contactEmail, String contactNumber,
                   String streetAddress, String city, String postCode, String billingName, String billingEmail) {
        this.clientId = clientId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postCode = postCode;
        this.billingName = billingName;
        this.billingEmail = billingEmail;
    }

    // Getters
    public String getClientId() { return clientId; }
    public String getCompanyName() { return companyName; }
    public String getContactName() { return contactName; }
    public String getContactEmail() { return contactEmail; }
    public String getContactNumber() { return contactNumber; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getPostCode() { return postCode; }
    public String getBillingName() { return billingName; }
    public String getBillingEmail() { return billingEmail; }

    // Setters
    public void setClientId(String clientId) { this.clientId = clientId; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setPostCode(String postCode) { this.postCode = postCode; }
    public void setBillingName(String billingName) { this.billingName = billingName; }
    public void setBillingEmail(String billingEmail) { this.billingEmail = billingEmail; }
}
