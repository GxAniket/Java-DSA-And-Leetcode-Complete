class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int idx = 0;
        // If n is odd, put 0 first
        if (n % 2 == 1) {
            ans[idx++] = 0;
        }
        // Add pairs +i and -i
        for (int i = 1; idx < n; i++) {
            ans[idx++] = i;
            if (idx < n) ans[idx++] = -i;
        }
        return ans;
    }
}
