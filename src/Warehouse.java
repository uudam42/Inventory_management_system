import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class Warehouse {
    // Warehouse: using for organize and assemble Item, Location and InventoryRecord classes

    // data attributes, we declare three empty map to store different objects
    private Map<String, Item> items; // create a dictionary named items, key is string type, get value from Item class
    private Map<String, Location> locations; // create a dictionary named locations, key is string type, get value from Location class
    private Map<String, InventoryRecord> records; // create a dictionary named records, key is string type, get value from InventoryRecord class

    // constructor
    public Warehouse() {
        // initialize map and create new object in heap
        this.setItems(new HashMap<String, Item>());
        this.setRecords(new HashMap<String, InventoryRecord>());
        this.setLocations(new HashMap<String, Location>());

    }

    // helpers
    // output format function
    public String formatOutput(String text, int length) {
        StringBuilder sb = new StringBuilder(text); // sb = text
        while (sb.length() < length) {
            sb.append(" "); // append space to match the length
        }
        return sb.toString();
    }

    // a function allow user to increase stock in InventoryRecord
    public void increaseStock(String itemID, String locationID, int amount) {
        InventoryRecord rec = getRecord(itemID + "|" + locationID); // get data from records map by composite key
        if (rec != null) { // check if the key exist
            rec.increase(amount); // call increase function in InventoryRecord to change quantity
            // record increaseStock behavior to log
            Logger.log("Increase stock: [itemID: " + rec.getItemID() + "| locationID: " + rec.getLocalID() + "| amount: " + amount + "]");
        } else {
            System.out.println("\nError: record not found for itemID: " + itemID + " at location: " + locationID + "\n"); // prompt user if ID is incorrect.
            // record Error behavior
            Logger.log("Increase FAILED for: [itemID: " + itemID + "| locationID: " + locationID + " | amount: " + amount + "| reason: Record not found]");
        }
    }

    // a function allow user to decrease stock in InventoryRecord
    public void decreaseStock(String itemID, String locationID, int amount) {
        InventoryRecord rec = getRecord(itemID + "|" + locationID); // get data from records map by composite key
        if (rec != null) { // check if the key exist
            // record decreaseStock behavior to log
            rec.decrease(amount); // call decrease function in InventoryRecord to change quantity
            Logger.log("Decrease stock: [itemID: " + rec.getItemID() + "| locationID: " + rec.getLocalID() + "| amount: " + amount + "]");
        } else {
            System.out.println("\nError: record not found for itemID: " + itemID + " at location: " + locationID + "\n"); // prompt user if ID is incorrect.
            // record Error behavior
            Logger.log("Decrease FAILED for: [itemID: " + itemID + "| locationID: " + locationID + " | amount: " + amount + "| reason: Record not found]");
        }
    }


    // export all inventory records to csv file
    public void exportInventoryToCsv(String fileName) {
        // Create FileWriter to open/overwrite the csv file
        // Create PrintWriter, using println to write data into file
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {

            // header line
            pw.println("itemID,itemName,locationID,quantity");

            // write each record as one csv row
            for (InventoryRecord rec : records.values()) { // iterate rec = value in records
                Item item = items.get(rec.getItemID());
                String itemName;
                if (item != null) {
                    itemName = item.getItemName();
                } else {
                    itemName = "N/A";
                }

                // concatenate data by sequence in header
                pw.println(rec.getItemID() + ","
                        + itemName + ","
                        + rec.getLocalID() + ","
                        + rec.getQuantity());
            }

            // prompt user successfully uploaded
            System.out.println("\nInventory Record successfully exported to " + fileName);
            Logger.log("Export InventoryRecord to CSV:" + fileName);
        } catch (IOException e) {
            // getMessage() : return the details error message of the exception
            System.out.println("\nError exporting inventory to CSV: " + e.getMessage());
            Logger.log("Export InventoryRecord to CSV FAILED:" + e.getMessage());
        }
    }


    public void addItem(Item item) { // create void function to add data into items map
        items.put(item.getItemID(), item); // key = itemID, value = Item object
    }

    public void addLocation(Location location) {
        locations.put(location.getLocalID(), location); // key = localID, value = Location object
    }

    public void addRecord(InventoryRecord record) {
        String recID = record.getItemID() + "|" + record.getLocalID(); // combine two id as composite key
        records.put(recID, record);  // key = recID, value = InventoryRecord object
        Logger.log("Add inventory record: [itemID: " + record.getItemID() // write new record to log
                + ", locationID: " + record.getLocalID()
                + ", quantity: " + record.getQuantity() + "]");
    }

    // getters, allow user take data out from map
    public Item getItem(String itemID) { // encapsulate object, only allow user take object by using key
        return items.get(itemID); // return Item object
    }

    public Location getLocation(String localID) { // encapsulate object, only allow user take object by using key
        return locations.get(localID); // return Location object
    }

    public InventoryRecord getRecord(String recID) { // encapsulate object, only allow user take object by using key
        return records.get(recID); // return InventoryRecord object
    }

    // setters
    public void setLocations(Map<String, Location> locations) {
        this.locations = locations;
    }

    public void setRecords(Map<String, InventoryRecord> records) {
        this.records = records;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }


    // toString
    public void printInventory() {
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("ItemID     Item Name           Location     Quantity");
        System.out.println("---------------------------------------------------------------");

        for (InventoryRecord rec : records.values()) { // assign value in records to rec
            Item item = items.get(rec.getItemID()); // // using ItemID to search item from items map
            String itemName;
            if (item != null) {
                itemName = item.getItemName();
            } else {
                itemName = "N/A";
            }

            String line = formatOutput(rec.getItemID(), 12)
                    + formatOutput(itemName, 20)
                    + formatOutput(rec.getLocalID(), 12)
                    + formatOutput(String.valueOf(rec.getQuantity()), 20); // convert int to string

            System.out.println(line);

        } // traversed all records
        System.out.println("---------------------------------------------------------------");


    }

}

