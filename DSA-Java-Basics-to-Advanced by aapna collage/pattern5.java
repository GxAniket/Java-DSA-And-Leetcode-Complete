public class pattern5 {
    public static void main(String[] args) {
        int n = 5;
        // outer loop from n to 1
        for (int i = 1; i <=5; i++) {
            // inner loop for printing space
            for (int j = 1; j <= n-i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
