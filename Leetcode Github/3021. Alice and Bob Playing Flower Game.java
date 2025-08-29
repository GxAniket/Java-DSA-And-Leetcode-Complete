public class Main {
    // Solution class with flowerGame method
    static class Solution {
        public long flowerGame(int n, int m) {
            long oddN = (n + 1) / 2;
            long evenN = n / 2;
            long oddM = (m + 1) / 2;
            long evenM = m / 2;
            return oddN * evenM + evenN * oddM;
        }
    }

    // Main function for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 3, m1 = 2;
        System.out.println("Result for n=3, m=2: " + sol.flowerGame(n1, m1)); // Output: 3

        int n2 = 1, m2 = 1;
        System.out.println("Result for n=1, m=1: " + sol.flowerGame(n2, m2)); // Output: 0
    }
}
