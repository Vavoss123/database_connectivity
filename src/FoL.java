import java.sql.Date;

public class FoL {
    private int folId;
    private Date joinDate;
    private String membershipType;
    private String name;
    private String address;
    private String email;

    // Constructors
    public FoL() {}

    public FoL(int folId, Date joinDate, String membershipType, String name, String address, String email) {
        this.folId = folId;
        this.joinDate = joinDate;
        this.membershipType = membershipType;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    // Getters and Setters
    public int getFolId() { return folId; }
    public void setFolId(int folId) { this.folId = folId; }

    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
