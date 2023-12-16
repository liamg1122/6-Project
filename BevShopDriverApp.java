
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Shows functionality of program
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Liam Ghershony
*/



import java.util.Scanner;

public class BevShopDriverApp {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("Welcome to Liam's Beverage Shop!");

        // Enter customer details
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int customerAge = scanner.nextInt();
        
        if (customerAge < bevShop.getMinAgeForAlcohol()) {
            System.out.println("You are not eligible to order alcohol -- you're under 21.");
        } else {
            System.out.println("You are eligible to order alcohol.");
        }
        
        

        System.out.println("Enter the time 24-hour format (1-24) the shop is open from 8 to 23: ");
        int time = scanner.nextInt();
        
        if(!bevShop.isValidTime(time)) {
        	
        	System.out.println("Shop is closed!");
        	
        	System.exit(0);
        	
        }
        
        

        System.out.println("Enter the day (Monday, Tuesday, ...) : ");
        scanner.nextLine(); // Consume newline
        String dayString = scanner.nextLine().toUpperCase();
        Day day = Day.valueOf(dayString);

        bevShop.startNewOrder(time, day, customerName, customerAge);

        boolean ordering = true;
        while (ordering) {
        	
            System.out.println("Choose the type of beverage: COFFEE, ALCOHOL, SMOOTHIE");
            String beverageType = scanner.nextLine().toUpperCase();

            System.out.println("Choose the size: SMALL, MEDIUM, LARGE");
            String sizeString = scanner.nextLine().toUpperCase();
            Size size = Size.valueOf(sizeString);

            switch (beverageType) {
                case "COFFEE":
                	
                    System.out.println("Extra Shot for 50 cents? (Y/N):");
                    boolean coffeeShot = scanner.nextLine().equalsIgnoreCase("y");
                    System.out.println("Extra Syrup for 50 cents? (Y/N):");
                    boolean coffeeSyrup = scanner.nextLine().equalsIgnoreCase("y");

                    bevShop.processCoffeeOrder("Coffee", size, coffeeShot, coffeeSyrup);
                    
                    break;
                    
                case "ALCOHOL":
                	
                	
                	  if (customerAge >= bevShop.getMinAgeForAlcohol()) {
                          if (bevShop.getNumOfAlcoholDrink() < bevShop.getMaxOrderForAlcohol()) {
                              bevShop.processAlcoholOrder("Alcohol", size);
                          } else {
                              System.out.println("You have reached the maximum limit for alcohol beverages in this order.");
                          }
                      } else {
                          System.out.println("You are not eligible to order alcohol as you are under 21.");
                      }
                	  
                	  
                    break;
                    
                    
                case "SMOOTHIE":
                    System.out.println("Add protein for $1.50? (Y/N):");
                    boolean addProtein = scanner.nextLine().equalsIgnoreCase("y");
                    System.out.println("How many fruits do you want to mix (each is 50 cents) choose from 1-5:");
                    int addFruits = scanner.nextInt();
                    bevShop.processSmoothieOrder("Smoothie", size, addFruits, addProtein);
                    break;
                    
                    
                default:
                	
                    System.out.println("Invalid beverage type!");
            }

            System.out.println("Do you want to add another beverage? (Y/N)");
            ordering = scanner.nextLine().equalsIgnoreCase("y");
        }

        System.out.println("Your order details:");
        System.out.println(bevShop.getCurrentOrder().toString());

        scanner.close();
    }
}
