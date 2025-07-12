public class PalindromicPattern {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            // Print decreasing numbers (i to 1)
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            // Print increasing numbers (2 to i)
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }

            // Next line
            System.out.println();
        }
    }
}
