class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int a = 1; Math.pow(a, x) <= n; ++a) {
            int power = (int) Math.pow(a, x);
            for (int i = n; i >= power; --i) {
                dp[i] = (dp[i] + dp[i - power]) % MOD;
            }
        }
        return dp[n];
    }
}
