/**
 * Represents a discount applied to a booking or transaction.
 * This class holds details about the type, value, and associations to group sales and FOL (Friends of London).
 */
public class Discount {
    private int discountId;
    private String discountType;
    private double discountValue;
    private int groupSaleId;
    private int folId;

    /**
     * Default constructor.
     */
    public Discount() {}

    /**
     * Constructs a new Discount object with all fields.
     *
     * @param discountId     Unique identifier for the discount
     * @param discountType   The type/category of discount (e.g., "Percentage", "Fixed")
     * @param discountValue  The value of the discount
     * @param groupSaleId    Associated group sale ID (if applicable)
     * @param folId          Associated FOL (Friends of London) ID (if applicable)
     */
    public Discount(int discountId, String discountType, double discountValue, int groupSaleId, int folId) {
        this.discountId = discountId;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.groupSaleId = groupSaleId;
        this.folId = folId;
    }

    /**
     * Gets the discount ID.
     *
     * @return the discount ID
     */
    public int getDiscountId() {
        return discountId;
    }

    /**
     * Sets the discount ID.
     *
     * @param discountId the discount ID to set
     */
    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    /**
     * Gets the type of the discount.
     *
     * @return the discount type
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Sets the type of the discount.
     *
     * @param discountType the discount type to set
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * Gets the value of the discount.
     *
     * @return the discount value
     */
    public double getDiscountValue() {
        return discountValue;
    }

    /**
     * Sets the value of the discount.
     *
     * @param discountValue the discount value to set
     */
    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    /**
     * Gets the group sale ID associated with the discount.
     *
     * @return the group sale ID
     */
    public int getGroupSaleId() {
        return groupSaleId;
    }

    /**
     * Sets the group sale ID associated with the discount.
     *
     * @param groupSaleId the group sale ID to set
     */
    public void setGroupSaleId(int groupSaleId) {
        this.groupSaleId = groupSaleId;
    }

    /**
     * Gets the Friends of London (FOL) ID associated with the discount.
     *
     * @return the FOL ID
     */
    public int getFolId() {
        return folId;
    }

    /**
     * Sets the Friends of London (FOL) ID associated with the discount.
     *
     * @param folId the FOL ID to set
     */
    public void setFolId(int folId) {
        this.folId = folId;
    }
}
