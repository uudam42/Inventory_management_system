# # Warehouse Inventory Management System

A Java-based  Inventory Management System that supports managing items, locations, and inventory records through a CLI.

# Features

- Add predefined items to the warehouse
- Increase stock
- Decrease stock
- Display current inventory
- Add new items dynamically through the CLI
- Export inventory data to CSV file (`inventory.csv`)
- Operation logging system 
- Object-oriented design using:
    - `Item`
    - `FragileItem`
    - `Location`
    - `InventoryRecord`
    - `Warehouse`

## Design Highlights

- Uses inheritance: `FragileItem` extends `Item`
- Encapsulates warehouse logic in `Warehouse` (maps for items, locations, and records)
- Separates UI (CLI) from business logic:
    - `Driver` handles user interaction (Scanner, menu, prompts)
    - `Warehouse` provides methods to manage inventory
- Simple logging handled by a separate `Logger` class


## Design Overview

- `Item`: basic product information (ID, name, unit, price)
- `FragileItem`: extends `Item`, adds `fragileLevel`
- `Location`: represents a storage area (Description + locationID)
- `InventoryRecord`: links `itemID` and `locationID` with current quantity
- `Warehouse`:
    - Manages `Map<String, Item> items`
    - Manages `Map<String, Location> locations`
    - Manages `Map<String, InventoryRecord> records`
    - Provides methods to increase/decrease stock, print inventory, export CSV
- `Driver`: CLI handles user interaction and menu
- `Logger`: records all operations to log file


# Project Structure
```
src/
├── Driver.java
├── FragileItem.java
├── InventoryRecord.java
├── Item.java
├── Location.java
├── Logger.java
└── Warehouse.java
```
## How to Run
1. Compile all `.java` files;
2. Run the program:

# CLI Menu Preview
```
======= Warehouse Menu =======

1.Increase stock

2.Decrease stock

3.Show inventory

4.Export to CSV and Exit

5.Add new item

Choose an option:

```

## Example
```
Enter itemID: CH001
Enter locationID: A01
Enter amount: 10
Stock updated successfully!
```
## Future Improvements

- Support deleting items and locations
- Input validation and better error handling
- Load initial data from a file (e.g., CSV) instead of hard-coding
- Add search functions (search by item name, location, etc.)
- GUI version using JavaFX or Swing
- Link to Database


