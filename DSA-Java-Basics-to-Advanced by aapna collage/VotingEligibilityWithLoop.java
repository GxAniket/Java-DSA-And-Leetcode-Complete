import java.util.Scanner;

public class VotingEligibilityWithLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char again = 'y';                     // sentinel to control the loop
        while (again == 'y' || again == 'Y') {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            if (age >= 18) {
                System.out.println("You are eligible to vote.");
            } else if (age >= 0) {            // basic input validation
                System.out.println("You are NOT eligible to vote.");
            } else {
                System.out.println("Please enter a non‑negative age.");
            }

            // ask the user whether they want to check another age
            System.out.print("Do you want to check another age? (y/n): ");
            again = scanner.next().charAt(0);
            System.out.println();             // blank line for readability
        }

        System.out.println("Program ended. Goodbye!");
        scanner.close();
    }
}
