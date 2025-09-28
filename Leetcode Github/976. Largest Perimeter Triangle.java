import java.util.Arrays;
import java.util.Scanner;

public class LargestPerimeterTriangle {
    public static int findLargestPerimeter(int[] arr) {
        Arrays.sort(arr);  // sort in ascending order
        for (int i = arr.length - 1; i >= 2; i--) {
            if (arr[i-2] + arr[i-1] > arr[i]) {
                return arr[i-2] + arr[i-1] + arr[i];
            }
        }
        return 0;  // no valid triangle
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of sticks: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter stick lengths: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findLargestPerimeter(arr);
        if (result == 0) {
            System.out.println("No triangle can be formed.");
        } else {
            System.out.println("Largest Perimeter = " + result);
        }
    }
}
