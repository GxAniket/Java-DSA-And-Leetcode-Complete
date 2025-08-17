class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Edge case: Alice never draws, or n is large enough that she always wins
        if (k == 0 || n >= k - 1 + maxPts) {
            return 1.0;
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0; // running sum of last maxPts probabilities
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                windowSum += dp[i]; // Alice can keep drawing
            } else {
                result += dp[i];    // Alice stops, add to result
            }

            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts]; // Slide window
            }
        }

        return result;
    }
}
