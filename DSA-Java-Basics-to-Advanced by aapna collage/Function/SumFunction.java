import java.util.Scanner;

public class SumFunction {

    // Function to return the sum of two numbers
    public static int getSum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Call function and store result
        int result = getSum(num1, num2);

        // Output
        System.out.println("Sum = " + result);

        sc.close();
    }
}
