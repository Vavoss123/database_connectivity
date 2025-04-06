import java.sql.Date;

public class GroupSale {
    private int groupSaleId;
    private Date saleDate;
    private double totalCost;
    private int groupId;
    private int showId;

    // Constructors
    public GroupSale() {}

    public GroupSale(int groupSaleId, Date saleDate, double totalCost, int groupId, int showId) {
        this.groupSaleId = groupSaleId;
        this.saleDate = saleDate;
        this.totalCost = totalCost;
        this.groupId = groupId;
        this.showId = showId;
    }

    // Getters and Setters
    public int getGroupSaleId() { return groupSaleId; }
    public void setGroupSaleId(int groupSaleId) { this.groupSaleId = groupSaleId; }

    public Date getSaleDate() { return saleDate; }
    public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public int getGroupId() { return groupId; }
    public void setGroupId(int groupId) { this.groupId = groupId; }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }
}
