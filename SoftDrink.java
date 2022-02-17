package Project_02;

/**
 *
 * @author riwakaram
 *
 * This class is a subclass of the superclass Item
 *
 * List of the methods in this class:
 * 1. No-arg constructor: sets the data fields to their default values
 * 2. With-arg constructor: sets the soft drink item with the corresponding
 * values
 * 3. setDiet: setter for the data field diet
 * 4. getDiet: getter for the data field diet
 * 5. getQuantity: (static) getter for the data field quantity
 * 6. toString: returns the description of the soft drink item as a string
 *
 * List of the data fields in this class:
 * 1. diet: boolean representing whether a soft drink is diet or not
 * 2. quantity: (static) integer representing the quantity of soft drinks in
 * the memory
 */
public class SoftDrink extends Item {

    private boolean diet;
    private static int quantity = 0;

    public SoftDrink() {
        this("", 0, false);         //calls the with-arg constructor
    }

    public SoftDrink(String itemCompanyName, int itemPrice, boolean diet) {
        super(itemCompanyName, itemPrice);
        setDiet(diet);
        quantity++; //incrementing the quantity each time an object is created
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    public boolean getDiet() {
        return diet;
    }

    public static int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Soft Drink -> " + super.toString() + ", "
                + (diet ? "Diet" : "Regular") + ".";
    }

}
