public class pattern {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;

        for (int i = 1; i<=n; i++) {
            //inner loop
            for (int j = 1; j <= m; j++) {
                //inner lopp
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
