import java.util.Scanner;

public class Loops2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {   // auto‑closes the scanner
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            // Print the multiplication table from 1 to 10
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " × " + i + " = " + (n * i));
            }
        }
    }
}
