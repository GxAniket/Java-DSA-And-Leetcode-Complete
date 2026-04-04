import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter food item (Burger/Pizza/Sandwich): ");
        String orderedFood = sc.nextLine();

        switch (orderedFood) {
            case "Burger":
                System.out.println("You have ordered Burger. Unit price: $10");
                break;

            case "Pizza":
                System.out.println("You have ordered Pizza. Unit price: $15");
                break;

            case "Sandwich":
                System.out.println("You have ordered Sandwich. Unit price: $8");
                break;

            default:
                System.out.println("Invalid selection");
        }

        sc.close();
    }
}
