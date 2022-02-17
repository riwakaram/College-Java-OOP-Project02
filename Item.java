package Project_02;

/**
 *
 * @author riwakaram
 * 
 * This class is the superclass for the four types of snacks in the vending
 * machine.
 *
 * List of the methods in this class:
 * 1. No-arg constructor: sets the data fields to their default values
 * 2. With-arg constructor: sets the item with the corresponding values
 * 3. setItem: calls the setters to set the data fields correspondingly
 * 4. setItemCompanyName: setter for the data field itemCompanyName
 * 5. setItemPrice: setter for the data field itemPrice
 * 6. getItemCompanyName: getter for the data field itemCompanyName
 * 7. getItemPrice: getter for the data field itemPrice
 * 8. toString: returns the description of the item as a string
 *
 * List of the data fields in this class:
 * 1. itemCompanyName: String for the company name of the item
 * 2. itemPrice: integer for the price of the item
 */
public class Item {

    private String itemCompanyName;
    private int itemPrice;

    public Item() {
        this("", 0); //calls the with-arg constructor
    }

    public Item(String itemCompanyName, int itemPrice) {
        setItem(itemCompanyName, itemPrice); //calls the setters
    }

    public void setItem(String itemCompanyName, int itemPrice) {
        setItemCompanyName(itemCompanyName);
        setItemPrice(itemPrice);
    }

    public void setItemCompanyName(String itemCompanyName) {
        this.itemCompanyName = itemCompanyName;
    }

    public void setItemPrice(int itemPrice) {
        if (itemPrice >= 0) {           //a price can't be negative
            this.itemPrice = itemPrice;
        } else {
            this.itemPrice = 0;         //set to default value otherwise
        }
    }

    public String getItemCompanyName() {
        return itemCompanyName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return "Price: " + itemPrice + "LBP, Company Name: " + itemCompanyName;
    }

}
