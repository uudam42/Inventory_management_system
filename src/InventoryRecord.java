public class InventoryRecord {
    private String itemID;
    private String localID;
    private int quantity;

    // constructor
    public InventoryRecord () {
        this.setItemID("None");
        this.setLocalID("None");
        this.setQuantity(0);
    }

    public InventoryRecord (String itemID, String localID, int quantity) {
        this.setItemID(itemID);
        this.setLocalID(localID);
        this.setQuantity(quantity);
    }

    // helpers
    public void increase (int amount) { // increase function to update item quantity
        if (amount <= 0) {
            System.out.println("\nError: amount must be positive"); // prompt user input must be positive
            return;
        }
        int new_quant = this.getQuantity() + amount;
        this.setQuantity(new_quant);
        System.out.println("\nStock Increased.");
    }

    public void decrease (int amount) { // decrease function to update item quantity
        if (amount <= 0) {
            System.out.println("\nError: amount must be positive"); // prompt user input must be positive
            return;
        }
        int new_quant = this.getQuantity() - amount; // count new item quantity
        if (new_quant < 0) { // prevent to record negative quantity
            System.out.println("\nError: Not enough stock to decrease\n");
            return;
        }
        this.setQuantity(new_quant);
        System.out.println("\nStock Decreased.");
    }

    // getters
    public String getLocalID() {
        return this.localID;
    }

    public String getItemID() {
        return this.itemID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    // setters
    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InventoryRecord: [Item ID: ")
                .append(this.getItemID())
                .append("\t|\tLocationID: ")
                .append(this.getLocalID())
                .append("\t|\tQuantity: ")
                .append(this.getQuantity())
                .append("]");
        return sb.toString();
    }
}
