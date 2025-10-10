class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int maxEnergy = Integer.MIN_VALUE;

        // Traverse each group of indices modulo k
        for (int start = n - 1; start >= n - k; start--) {
            for (int i = start; i >= 0; i -= k) {
                dp[i] = energy[i];
                if (i + k < n) {
                    dp[i] += dp[i + k];
                }
                maxEnergy = Math.max(maxEnergy, dp[i]);
            }
        }

        return maxEnergy;
    }
}