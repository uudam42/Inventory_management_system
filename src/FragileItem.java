// inherit from Item
public class FragileItem extends Item{
    private String fragileLevel;

    public FragileItem () {
        super("None","None","None",-1);
        this.setFragileLevel("None");
    }

    public FragileItem (String itemID, String itemName, String itemUnit, double itemPrice, String fragileLevel) {
        super(itemID, itemName, itemUnit, itemPrice);
        this.setFragileLevel(fragileLevel);
    }

    // getters
    public String getFragileLevel() {
        return this.fragileLevel;
    }

    // setters
    public void setFragileLevel(String fragileLevel) {
        this.fragileLevel = fragileLevel;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String superString = super.toString().substring(0);
        sb.append(superString).append("--[Fragile:").append("FragLevel=").append(this.fragileLevel).append("]");
        return sb.toString();
    }
}
