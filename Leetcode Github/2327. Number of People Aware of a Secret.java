/* 🧠 Problem in simple words

On Day 1 → only 1 person knows the secret.

Each person can start telling others after delay days.

Each person will forget the secret after forget days.

You need to find → on Day n, how many people still remember the secret.

⚡ Important: Since the number can get huge, return the answer modulo 1,000,000,007.

🏃 Idea (step-by-step)

Let’s keep track of how many people learn the secret each day → dp[day].

Example: dp[3] = 5 means 5 new people learned the secret on Day 3.

Base case: On Day 1, dp[1] = 1.

For each new day:

People who became eligible to share today → add them to the “sharers” group.

People who forgot today → remove them from the “sharers” group.

The number of new learners today = total current sharers.

At the end, count everyone who hasn’t forgotten yet on Day n. */


public class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;

        // dp[day] = how many people learn secret on this day
        long[] dp = new long[n + 1];
        dp[1] = 1; // Day 1: one person knows the secret

        long sharers = 0; // number of people who can share the secret now

        for (int day = 2; day <= n; day++) {
            // People who now can start sharing
            int startSharing = day - delay;
            if (startSharing >= 1) {
                sharers = (sharers + dp[startSharing]) % MOD;
            }

            // People who forget today (they were sharing before)
            int stopSharing = day - forget;
            if (stopSharing >= 1) {
                sharers = (sharers - dp[stopSharing] + MOD) % MOD;
            }

            // New people learning the secret today
            dp[day] = sharers;
        }

        // Count how many still remember secret on day n
        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) ans = (ans + dp[day]) % MOD;
        }

        return (int) ans;
    }

    // Main function to test the code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        System.out.println(sol.peopleAwareOfSecret(6, 2, 4)); // Expected 5
        System.out.println(sol.peopleAwareOfSecret(4, 1, 3)); // Example check
        System.out.println(sol.peopleAwareOfSecret(10, 2, 5)); // Another check
    }
}

