public class Clients {
    private String companyId;
    private String companyName;
    private String contactName;
    private String contactEmail;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String postcode;
    private String billingName;
    private String billingEmail;

    public Clients(String companyId, String companyName, String contactName, String contactEmail, String phoneNumber,
                   String streetAddress, String city, String postcode, String billingName, String billingEmail) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.billingName = billingName;
        this.billingEmail = billingEmail;
    }

    // Getters
    public String getCompanyId() { return companyId; }
    public String getCompanyName() { return companyName; }
    public String getContactName() { return contactName; }
    public String getContactEmail() { return contactEmail; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getPostcode() { return postcode; }
    public String getBillingName() { return billingName; }
    public String getBillingEmail() { return billingEmail; }

    // Setters
    public void setCompanyId(String companyId) { this.companyId = companyId; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setBillingName(String billingName) { this.billingName = billingName; }
    public void setBillingEmail(String billingEmail) { this.billingEmail = billingEmail; }
}
