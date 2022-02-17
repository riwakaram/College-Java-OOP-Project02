package Project_02;

/**
 *
 * @author riwakaram
 *
 * This class is a subclass of the superclass Item
 *
 * List of the methods in this class:
 * 1. No-arg constructor: sets the data fields to their default values
 * 2. With-arg constructor: sets the chocolate item with the corresponding values
 * 3. setWeight: setter for the data field weight
 * 4. getWeight: getter for the data field weight
 * 5. getQuantity: (static) getter for the data field quantity
 * 6. toString: returns the description of the chocolate item as a string
 *
 * List of the data fields in this class:
 * 1. weight: integer representing the weight of the chocolate bar
 * 2. quantity: (static) integer representing the quantity of chocolate bars in
 * the memory
 */
public class Chocolate extends Item {

    private int weight;
    private static int quantity = 0;

    public Chocolate() {
        this("", 0, 50);            //calls the with-arg constructor
    }

    public Chocolate(String itemCompanyName, int itemPrice, int weight) {
        super(itemCompanyName, itemPrice);
        setWeight(weight);
        quantity++; //incrementing the quantity each time an object is created
    }

    public void setWeight(int weight) {
        if (weight > 0) {           //weight can't be negative or zero
            this.weight = weight;
        } else {
            this.weight = 50;       //set to default value otherwise
        }
    }

    public int getWeight() {
        return weight;
    }

    public static int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Chocolate -> " + super.toString() + ", Net Weight: "
                + weight + "gr.";
    }

}
