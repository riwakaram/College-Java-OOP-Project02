package Project_02;

/**
 *
 * @author riwakaram
 *
 * This class is a subclass of the superclass Item
 *
 * List of the methods in this class:
 * 1. No-arg constructor: sets the data fields to their default values
 * 2. With-arg constructor: sets the water item with the corresponding values
 * 3. setSize: setter for the data field size
 * 4. getSize: getter for the data field size
 * 5. getQuantity: (static) getter for the data field quantity
 * 6. toString: returns the description of the water item as a string
 *
 * List of the data fields in this class:
 * 1. size: integer representing the size of the water bottle
 * (can only be 250, 333, 500 or 1000)
 * 2. quantity: (static) integer representing the quantity of water bottles in
 * the memory
 */
public class Water extends Item {

    private int size;
    private static int quantity = 0;

    public Water() {
        this("", 0, 250); //calls the with-arg constructor
    }

    public Water(String itemCompanyName, int itemPrice, int size) {
        super(itemCompanyName, itemPrice);
        setSize(size);
        quantity++; //incrementing the quantity each time an object is created
    }

    public void setSize(int size) {
        if (size == 250 || size == 333 || size == 500 || size == 1000) {
            //can only be 250, 333, 500 or 1000
            this.size = size;
        } else {
            this.size = 250;            //set to default value otherwise
        }
    }

    public int getSize() {
        return size;
    }

    public static int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Water -> " + super.toString() + ", Size: " + size + "mL.";
    }

}
