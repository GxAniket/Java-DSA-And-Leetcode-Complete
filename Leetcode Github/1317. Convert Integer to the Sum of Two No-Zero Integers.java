public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 1010; // try different values
        int[] result = sol.getNoZeroIntegers(n);

        System.out.println("Input: " + n);
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
}

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = n - i;
            if (!hasZero(a) && !hasZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{1, n - 1}; // fallback (always valid)
    }

    private boolean hasZero(int x) {
        while (x > 0) {
            if (x % 10 == 0) return true;
            x /= 10;
        }
        return false;
    }
}
