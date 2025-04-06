import java.sql.Date;

/**
 * Represents a Friend of the Library (FoL) member with their membership details.
 */
public class FoL {
    private int folId;
    private Date joinDate;
    private String membershipType;
    private String name;
    private String address;
    private String email;

    /**
     * Default constructor for FoL.
     */
    public FoL() {}

    /**
     * Constructs a new FoL object with all details.
     *
     * @param folId           The unique ID of the FoL member.
     * @param joinDate        The date the member joined.
     * @param membershipType  The type of membership held.
     * @param name            The full name of the member.
     * @param address         The address of the member.
     * @param email           The email address of the member.
     */
    public FoL(int folId, Date joinDate, String membershipType, String name, String address, String email) {
        this.folId = folId;
        this.joinDate = joinDate;
        this.membershipType = membershipType;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    /**
     * Gets the unique ID of the FoL member.
     *
     * @return The FoL ID.
     */
    public int getFolId() {
        return folId;
    }

    /**
     * Sets the unique ID of the FoL member.
     *
     * @param folId The FoL ID to set.
     */
    public void setFolId(int folId) {
        this.folId = folId;
    }

    /**
     * Gets the date the member joined.
     *
     * @return The join date.
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * Sets the date the member joined.
     *
     * @param joinDate The join date to set.
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * Gets the type of membership held by the member.
     *
     * @return The membership type.
     */
    public String getMembershipType() {
        return membershipType;
    }

    /**
     * Sets the type of membership.
     *
     * @param membershipType The membership type to set.
     */
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    /**
     * Gets the name of the FoL member.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the FoL member.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the FoL member.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the FoL member.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the email of the FoL member.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the FoL member.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
