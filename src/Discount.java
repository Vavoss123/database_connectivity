public class Discount {
    private int discountId;
    private String discountType;
    private double discountValue;
    private int groupSaleId;
    private int folId;

    // Constructors
    public Discount() {}

    public Discount(int discountId, String discountType, double discountValue, int groupSaleId, int folId) {
        this.discountId = discountId;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.groupSaleId = groupSaleId;
        this.folId = folId;
    }

    // Getters and Setters
    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public int getGroupSaleId() {
        return groupSaleId;
    }

    public void setGroupSaleId(int groupSaleId) {
        this.groupSaleId = groupSaleId;
    }

    public int getFolId() {
        return folId;
    }

    public void setFolId(int folId) {
        this.folId = folId;
    }
}
