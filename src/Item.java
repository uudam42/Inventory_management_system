public class Item {
    // Item attributes
    private String itemID;
    private String itemName;
    private double itemPrice;
    private String itemUnit;

    // constructors
    public Item () {
        this.setItemID("None");
        this.setItemName("None");
        this.setItemPrice(-1);
        this.setItemUnit("None");
    }

    public Item(String itemID, String itemName, String itemUnit, double itemPrice){
        this.setItemPrice(itemPrice);
        this.setItemUnit(itemUnit);
        this.setItemName(itemName);
        this.setItemID(itemID);
    }

    // getters
    public String getItemID() {
        return this.itemID;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemUnit() {
        return this.itemUnit;
    }

    // setters
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    // toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item: [")
                .append("ID=").append(this.getItemID()).append(",")
                .append("Name=").append(this.getItemName()).append(",")
                .append("Unit=").append(this.getItemUnit()).append(",")
                .append("Price=").append(this.getItemPrice()).append("]");
        return sb.toString();
    }
}

