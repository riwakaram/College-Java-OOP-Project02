package Project_02;

/**
 *
 * @author riwakaram
 *
 * This class is a subclass of the superclass Item
 *
 * List of the methods in this class:
 * 1. No-arg constructor: sets the data fields to their default values
 * 2. With-arg constructor: sets the chips item with the corresponding values
 * 3. setChips: calls the setters to set the data fields correspondingly
 * 4. setDiet: setter for the data field diet
 * 5. setSize: setter for the data field size
 * 6. getDiet: getter for the data field diet
 * 7. getSize: getter for the data field size
 * 8. getQuantity: (static) getter for the data field quantity
 * 9. toString: returns the description of the chips item as a string
 *
 * List of the data fields in this class:
 * 1. diet: boolean representing if the chips bag is diet or not
 * 2. size: integer representing the size of the chips bag
 * (can only be 1 (small), 2 (medium) or 3 (large))
 * 3. quantity: (static) integer representing the quantity of chips bags in
 * the memory
 */
public class Chips extends Item {

    private boolean diet;
    private int size;
    private static int quantity = 0;

    public Chips() {
        this("", 0, false, 1);          //calls the with-arg constructor
    }

    public Chips(String itemCompanyName, int itemPrice, boolean diet, int size) {
        super(itemCompanyName, itemPrice);
        setChips(diet, size);
        quantity++; //incrementing the quantity each time an object is created
    }

    public void setChips(boolean diet, int size) {
        setDiet(diet);
        setSize(size);
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    public void setSize(int size) {
        if (size == 1 || size == 2 || size == 3) {      //can only be 1, 2 or 3
            this.size = size;
        } else {
            this.size = 1;          //set to default value otherwise
        }
    }

    public boolean getDiet() {
        return diet;
    }

    public int getSize() {
        return size;
    }

    public static int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Chips -> " + super.toString() + ", "
                + (diet ? "Diet" : "Regular") + ", Size: "
                + (size == 1 ? "Small" : size == 2 ? "Medium" : "Large");
    }

}
