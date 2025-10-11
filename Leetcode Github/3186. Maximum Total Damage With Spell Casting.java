import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Count frequency of each spell damage
        Map<Integer, Long> count = new HashMap<>();
        for (int val : power) {
            count.put(val, count.getOrDefault(val, 0L) + 1);
        }

        // Store distinct values and their total damages
        int n = count.size();
        int[] vals = new int[n];
        long[] total = new long[n];
        int idx = 0;

        for (int key : count.keySet()) vals[idx++] = key;
        Arrays.sort(vals);

        for (int i = 0; i < n; i++) {
            total[i] = (long) vals[i] * count.get(vals[i]);
        }

        // Find next valid index (first index where vals[j] > vals[i] + 2)
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int target = vals[i] + 2;
            next[i] = upperBound(vals, target);
        }

        // DP: choose or skip each damage value
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long skip = dp[i + 1];
            long take = total[i] + (next[i] < n ? dp[next[i]] : 0);
            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }

    // Binary search: first index where arr[j] > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
