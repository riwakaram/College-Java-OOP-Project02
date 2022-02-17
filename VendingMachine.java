package Project_02;

/**
 *
 * @author riwakaram
 *
 * List of the methods in this class:
 * 1. No-arg constructor: creates a reference to items and to each ArrayList in
 * the array items
 * 2. getItems: getter for the data field items
 * 3. getTotalSellings: (static) getter for the data field totalSellings
 * 4. addItem: adds an object of type Item in the correct ArrayList in the array
 * items
 * 5. buyItem: adds the price of the item to totalSellings and removes the item 
 * from the correct ArrayList only if that item exists in items
 * 6. toString: returns all the items in the vending machine with their 
 * description
 * 
 * List of the data fields in this class:
 * 1. items: array of ArrayLists containing all the items, distributed by type, 
 * in the vending machine
 * 2. totalSellings: (static) integer representing the amount of money in the 
 * vending machine
 *
 */
import java.util.ArrayList;

public class VendingMachine {

    private ArrayList[] items;
    private static int totalSellings;

    public VendingMachine() {
        items = new ArrayList[4];
        for (int i = 0; i < items.length; i++) {
            items[i] = new ArrayList();
        }
    }

    public ArrayList[] getItems() {
        return items;
    }

    public static int getTotalSellings() {
        int sellings = totalSellings;
        totalSellings = 0;
        //the admin will retrieve all the money from the vending machine
        return sellings;
    }

    public void addItem(Item item) {
        if (item instanceof Chocolate) {
            items[0].add(item); //the first ArrayList contains Chocolate items
        } else if (item instanceof Chips) {
            items[1].add(item); //the second ArrayList contains Chips items
        } else if (item instanceof SoftDrink) {
            items[2].add(item); //the third ArrayList contains SoftDrink items
        } else if (item instanceof Water) {
            items[3].add(item); //the fourth ArrayList contains Water items
        }
    }

    public boolean buyItem(int type) {
        //type is from 1 to 4 and items is from 0 to 3 so we decrement by 1 to
        //get the correct ArrayList in items of class type
        if (!items[type - 1].isEmpty()) {
            totalSellings += ((Item) (items[type - 1].get(0))).getItemPrice();
            items[type - 1].remove(0);
            return true;
        } else {
            return false;
            //no more items of class (type - 1) available in the vending machine
        }
    }

    public String toString() {
        String item = "";
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].size(); j++) {
                item += (items[i].get(j)).toString() + "\n";
            }
        }
        return item;
    }

}
