public class pattern4 {
    public static void main(String[] args) {
        int n = 5;
        // outer loop from n to 1
        for (int i = n; i >= 1; i--) {
            // inner loop for printing stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
