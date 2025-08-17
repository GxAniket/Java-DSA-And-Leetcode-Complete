class Solution:
    def new21Game(self, n, k, maxPts):
        # Edge case: if k = 0 (never draws), or n large enough that overflow is impossible
        if k == 0 or n >= k - 1 + maxPts:
            return 1.0

        dp = [0.0] * (n + 1)
        dp[0] = 1.0
        window_sum = 1.0
        ans = 0.0

        for i in range(1, n + 1):
            dp[i] = window_sum / maxPts
            if i < k:
                window_sum += dp[i]
            else:
                ans += dp[i]
            if i - maxPts >= 0:
                window_sum -= dp[i - maxPts]

        return ans
