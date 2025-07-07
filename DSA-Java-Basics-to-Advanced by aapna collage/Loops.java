//wap to print sum of first n natural number
import java.util.*;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            // sum=+1;
        }

        System.out.println("Sum = " + sum);
        sc.close();
    }
}
