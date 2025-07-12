public class SolidRhombus {
    public static void main(String[] args) {
        int n = 5; // Number of rows

        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print 5 stars
            for (int j = 1; j <= 5; j++) {
                System.out.print("* ");
            }

            // Move to next line
            System.out.println();
        }
    }
}
