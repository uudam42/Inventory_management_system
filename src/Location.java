public class Location {
    private String localID;
    private String description;

    // constructor
    public Location () {
        this.setDescription("None");
        this.setLocalID("None");
    }

    public Location (String description, String localID) {
        this.setLocalID(localID);
        this.setDescription(description);
    }

    // getters
    public String getDescription() {
        return this.description;
    }

    public String getLocalID() {
        return this.localID;
    }

    // setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    // toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Location: [ID=").append(this.getLocalID())
                .append(", Desc=").append(this.getDescription())
                .append("]");
        return sb.toString();
    }
}
