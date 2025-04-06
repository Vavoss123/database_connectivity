/**
 * Represents a client with company and billing information.
 */
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

    /**
     * Default constructor.
     */
    public Clients() {}

    /**
     * Constructs a client with the specified details.
     *
     * @param clientId the unique client ID
     * @param companyName the name of the client's company
     * @param contactName the contact person's name
     * @param contactEmail the contact person's email address
     * @param contactNumber the contact phone number
     * @param streetAddress the street address of the client
     * @param city the city where the client is located
     * @param postCode the postal code of the client
     * @param billingName the name for billing purposes
     * @param billingEmail the email used for billing
     */
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

    /** @return the client ID */
    public String getClientId() { return clientId; }

    /** @return the company name */
    public String getCompanyName() { return companyName; }

    /** @return the contact name */
    public String getContactName() { return contactName; }

    /** @return the contact email */
    public String getContactEmail() { return contactEmail; }

    /** @return the contact number */
    public String getContactNumber() { return contactNumber; }

    /** @return the street address */
    public String getStreetAddress() { return streetAddress; }

    /** @return the city */
    public String getCity() { return city; }

    /** @return the postal code */
    public String getPostCode() { return postCode; }

    /** @return the billing name */
    public String getBillingName() { return billingName; }

    /** @return the billing email */
    public String getBillingEmail() { return billingEmail; }

    /** @param clientId sets the client ID */
    public void setClientId(String clientId) { this.clientId = clientId; }

    /** @param companyName sets the company name */
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    /** @param contactName sets the contact name */
    public void setContactName(String contactName) { this.contactName = contactName; }

    /** @param contactEmail sets the contact email */
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    /** @param contactNumber sets the contact number */
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    /** @param streetAddress sets the street address */
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    /** @param city sets the city */
    public void setCity(String city) { this.city = city; }

    /** @param postCode sets the postal code */
    public void setPostCode(String postCode) { this.postCode = postCode; }

    /** @param billingName sets the billing name */
    public void setBillingName(String billingName) { this.billingName = billingName; }

    /** @param billingEmail sets the billing email */
    public void setBillingEmail(String billingEmail) { this.billingEmail = billingEmail; }
}
