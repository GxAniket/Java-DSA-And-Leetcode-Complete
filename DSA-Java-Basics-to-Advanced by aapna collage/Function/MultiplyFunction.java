import java.util.Scanner;

public class MultiplyFunction {

    // Function to multiply two numbers and return the product
    public static int multiply(int a, int b) {
        int product = a * b;
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Call multiply function
        int result = multiply(num1, num2);

        // Display result
        System.out.println("Product = " + result);

        sc.close();
    }
}
