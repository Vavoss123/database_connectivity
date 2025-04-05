import java.sql.Date;

public class Discount {
    private int discountId;
    private String discountName;
    private double discountRate;
    private Date validFrom;
    private Date validTo;

    // Constructors
    public Discount() {}

    public Discount(int discountId, String discountName, double discountRate, Date validFrom, Date validTo) {
        this.discountId = discountId;
        this.discountName = discountName;
        this.discountRate = discountRate;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    // Getters and Setters
    public int getDiscountId() { return discountId; }
    public void setDiscountId(int discountId) { this.discountId = discountId; }

    public String getDiscountName() { return discountName; }
    public void setDiscountName(String discountName) { this.discountName = discountName; }

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    public Date getValidFrom() { return validFrom; }
    public void setValidFrom(Date validFrom) { this.validFrom = validFrom; }

    public Date getValidTo() { return validTo; }
    public void setValidTo(Date validTo) { this.validTo = validTo; }
}
