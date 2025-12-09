import java.util.Scanner;

public class Driver {
    static void main() {

        // create warehouse
        Warehouse w = new Warehouse();

        // cli
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=======Warehouse Menu=======\n");
            System.out.println("1. Increase stock");
            System.out.println("2. Decrease stock");
            System.out.println("3. Show inventory");
            System.out.println("4. Add new item");
            System.out.println("5. Export to CSV and Exit");
            System.out.print("Choose an option: ");


            int choice;
            if(sc.hasNextInt()) {   // check user input is correct, only int are allowed
                choice = sc.nextInt();
                sc.nextLine();  // clean buffer
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;   // roll back to while loop
            }


            if (choice == 1) {
                System.out.print("Enter itemID:\t");
                String copyItemID = sc.nextLine();
                System.out.print("Enter locationID:\t");
                String copyLocationID = sc.nextLine();
                System.out.print("Enter amount:\t");
                int copyAmount = sc.nextInt();
                sc.nextLine();

                w.increaseStock(copyItemID, copyLocationID, copyAmount);

            } else if (choice == 2) {
                System.out.print("Enter itemID:\t");
                String copyItemID = sc.nextLine();
                System.out.print("Enter locationID:\t");
                String copyLocationID = sc.nextLine();
                System.out.print("Enter amount:\t");
                int copyAmount = sc.nextInt();
                sc.nextLine();

                w.decreaseStock(copyItemID, copyLocationID, copyAmount);


            } else if (choice == 3) {

                w.printInventory();


            } else if (choice == 4) {

                addNewItem(w, sc);

            } else if (choice == 5) {

                w.exportInventoryToCsv("inventory.csv");
                System.out.println("Bye!");
                running = false; // quit loop
            }


        }

    }

    // create new item and add item to warehouse
    public static void addNewItem (Warehouse w, Scanner sc) {
        String newItemID;
        String newItemName;
        String unit;
        double price;

        // determine item type by user
        System.out.print("Regular item or Fragile item ? type R or F:\t");
        String respond = sc.nextLine().toUpperCase(); // take user respond
        if (respond.equals("F")) {

            System.out.print("Enter new item name:\t");
            newItemName = sc.nextLine();

            System.out.print("Enter new itemID:\t");
            newItemID = sc.nextLine();

            System.out.print("Enter unit:\t");
            unit = sc.nextLine();

            System.out.print("Enter price:\t");
            price = sc.nextDouble();
            sc.nextLine(); // clean buffer

            System.out.print("Enter fragile level:\t");
            String fragileLevel = sc.nextLine();

            FragileItem item = new FragileItem(newItemID,newItemName,unit,price,fragileLevel);
            // add item to hashmap
            w.addItem(item);

        } else {

            System.out.print("Enter new item name:\t");
            newItemName = sc.nextLine();

            System.out.print("Enter new itemID:\t");
            newItemID = sc.nextLine();

            System.out.print("Enter unit:\t");
            unit = sc.nextLine();

            System.out.print("Enter price:\t");
            price = sc.nextDouble();
            sc.nextLine(); // clean buffer

            Item item = new Item(newItemID, newItemName, unit, price);
            // add item to hashmap
            w.addItem(item);
        }

        System.out.print("Enter location name:\t");
        String locName = sc.nextLine();

        System.out.print("Enter locationID:\t");
        String locId = sc.nextLine();

        Location location = new Location(locName, locId);
        // add location to hashmap
        w.addLocation(location);

        System.out.print("Enter initial amount:\t");
        int amount = sc.nextInt();
        sc.nextLine();

        InventoryRecord record = new InventoryRecord(newItemID, locId, amount);
        w.addRecord(record);

        System.out.println("\nNew item added successfully!");
    }

}

