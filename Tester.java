package Project_02;

/**
 *
 * Title of the Project: Vending Machine
 *
 * Date: Saturday, April 18, 2021
 *
 * @author riwakaram
 *
 * This main class is a tester for the classes: Item, SoftDrink, Chocolate,
 * Chips, Water and VendingMachine
 *
 */
import java.io.*;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        //Step 1:
        VendingMachine vm = new VendingMachine();
        String pass = "OOP123";

        //Step 2:
        File file = new File("/Users/riwakaram/NetBeansProjects/CSIS215"
                + "/src/main/java/vending.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                Scanner s = new Scanner(sc.nextLine());
                String item = s.next();
                if (item.equals("SoftDrinks")) {
                    String SDName = s.next();
                    int SDPrice = s.nextInt();
                    boolean SDDiet = s.nextBoolean();
                    Item sDrink = new SoftDrink(SDName, SDPrice, SDDiet);
                    vm.addItem(sDrink);
                } else if (item.equals("Chocolate")) {
                    String ChocName = s.next();
                    int ChocPrice = s.nextInt();
                    int ChocWeight = s.nextInt();
                    Item choc = new Chocolate(ChocName, ChocPrice, ChocWeight);
                    vm.addItem(choc);
                } else if (item.equals("Chips")) {
                    String ChipsName = s.next();
                    int ChipsPrice = s.nextInt();
                    boolean ChipsDiet = s.nextBoolean();
                    int ChipsSize = s.nextInt();
                    Item chips = new Chips(ChipsName, ChipsPrice, ChipsDiet,
                            ChipsSize);
                    vm.addItem(chips);
                } else if (item.equals("Water")) {
                    String wName = s.next();
                    int wPrice = s.nextInt();
                    int wSize = s.nextInt();
                    Item water = new Water(wName, wPrice, wSize);
                    vm.addItem(water);
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        //Step 3:
        do {
            System.out.println("Welcome to the OOP Vending Machine!"
                    + "\nAre you an admin or a customer? Pick an option below:"
                    + "\n1. Admin"
                    + "\n2. Customer"
                    + "\n3. Quit");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the ADMIN password: ");
                    String passGuess = input.next();
                    if (passGuess.equals(pass)) {
                        do {
                            System.out.println("ADMIN MENU - Pick an option "
                                    + "below:"
                                    + "\n1. Get the total sellings"
                                    + "\n2. Add item"
                                    + "\n3. Exit");
                            int adminChoice = input.nextInt();
                            switch (adminChoice) {
                                case 1:
                                    System.out.println("The total sellings are: "
                                            + VendingMachine.getTotalSellings()
                                            + "LBP");
                                    break;
                                case 2:
                                    System.out.println("Enter the type of item "
                                            + "you want to add: (Make sure the "
                                            + "type is either Chocolate, Chips,"
                                            + " SoftDrink or Water)");
                                    String itemChoice = input.next();
                                    switch (itemChoice) {
                                        case "Chocolate":
                                            System.out.println("Enter the "
                                                    + "company name, the price "
                                                    + "and the weight of the "
                                                    + "chocolate: ");
                                            String chocName = input.next();
                                            int chocPrice = input.nextInt();
                                            int chocWeight = input.nextInt();
                                            Item choc = new Chocolate(chocName,
                                                    chocPrice, chocWeight);
                                            vm.addItem(choc);
                                            break;
                                        case "Chips":
                                            System.out.println("Enter the "
                                                    + "company name, the price,"
                                                    + " true or false for "
                                                    + "whether the chips "
                                                    + "bag is diet or not, and "
                                                    + "the size (1 for small, 2"
                                                    + " for medium and 3 for "
                                                    + "large): ");
                                            String chipsName = input.next();
                                            int chipsPrice = input.nextInt();
                                            boolean chipsDiet
                                                    = input.nextBoolean();
                                            int chipsSize = input.nextInt();
                                            Item chipsBag = new Chips(chipsName,
                                                    chipsPrice, chipsDiet,
                                                    chipsSize);
                                            vm.addItem(chipsBag);
                                            break;
                                        case "SoftDrink":
                                            System.out.println("Enter the "
                                                    + "company name, the price "
                                                    + "and true or false for "
                                                    + "whether the soft drink "
                                                    + "is diet or not: ");
                                            String drinkName = input.next();
                                            int drinkPrice = input.nextInt();
                                            boolean drinkDiet
                                                    = input.nextBoolean();
                                            Item drink = new SoftDrink(drinkName,
                                                    drinkPrice, drinkDiet);
                                            vm.addItem(drink);
                                            break;
                                        case "Water":
                                            System.out.println("Enter the "
                                                    + "company name, the price "
                                                    + "and the size of the "
                                                    + "water bottle (250, 333, "
                                                    + "500 or 1000 mL): ");
                                            String waterName = input.next();
                                            int waterPrice = input.nextInt();
                                            int waterSize = input.nextInt();
                                            Item wBottle = new Water(waterName,
                                                    waterPrice, waterSize);
                                            vm.addItem(wBottle);
                                            break;
                                        default:
                                            System.out.println("Wrong input. "
                                                    + "Try again.");
                                            break;
                                    }
                                    break;
                                case 3:
                                    System.out.println("You exited the "
                                            + "ADMIN MENU.");
                                    break;
                                default:
                                    System.out.println("Wrong input. "
                                            + "Try again.");
                            }
                            if (adminChoice == 3) {
                                break;
                            }
                        } while (true);
                    } else {
                        System.out.println("Wrong password.");
                        break;
                    }
                    break;
                case 2:
                    do {
                        System.out.println("OOP Vending Machine Items:");
                        System.out.println(vm.toString());
                        System.out.println("CUSTOMER MENU - Pick an option "
                                + "below:"
                                + "\n1. Buy an item"
                                + "\n2. Exit");
                        int custChoice = input.nextInt();
                        switch (custChoice) {
                            case 1:
                                System.out.println("Enter the number of the "
                                        + "item you would like to buy: (1 for "
                                        + "chocolate, 2 for Chips, 3 for Soft "
                                        + "Drink and 4 for Water)");
                                int itemToBuy = input.nextInt();
                                boolean buy = vm.buyItem(itemToBuy);
                                if (buy) {
                                    System.out.println("Enjoy your snack!");
                                } else {
                                    System.out.println("Snack not available.");
                                }
                                break;
                            case 2:
                                System.out.println("You exited the CUSTOMER "
                                        + "MENU.");
                                break;
                            default:
                                System.out.println("Wrong input. Try again.");
                                break;
                        }
                        if (custChoice == 2) {
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    System.out.println("You exited the main menu.");
                    break;
                default:
                    System.out.println("Wrong input. Try again.");
                    break;
            }
            if (option == 3) {
                break;
            }
        } while (true);
    }
}
