import java.util.Scanner;

public class FactorialProgram {

    // Function to calculate factorial
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Handle negative input
        if (num < 0) {
            System.out.println("Factorial not defined for negative numbers.");
        } else {
            long result = factorial(num);
            System.out.println("Factorial of " + num + " is: " + result);
        }

        sc.close();
    }
}
