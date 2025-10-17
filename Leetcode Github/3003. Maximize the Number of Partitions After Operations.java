import java.util.*;

public class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(s, 0, true, 0, k, memo) + 1;  // +1 for the initial partition
    }

    // dfs returns the maximum number of additional partitions from index i (not counting the current partition)
    private int dfs(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> memo) {
        int n = s.length();
        if (i == n) return 0;

        long key = (((long)i) << 32) | (((long)(canChange ? 1 : 0)) << 31) | (mask & 0x7FFFFFFFL);
        if (memo.containsKey(key)) return memo.get(key);

        int res = 0;
        // Option 1: keep the current character
        int bit = 1 << (s.charAt(i) - 'a');
        int newMask = mask | bit;
        if (Integer.bitCount(newMask) > k) {
            // Need to start a fresh partition here: count 1, new current mask becomes 'bit'
            res = Math.max(res, 1 + dfs(s, i + 1, canChange, bit, k, memo));
        } else {
            // Continue current partition
            res = Math.max(res, dfs(s, i + 1, canChange, newMask, k, memo));
        }

        // Option 2: change current char (if we still can)
        if (canChange) {
            for (int c = 0; c < 26; ++c) {
                int newBit = 1 << c;
                int m2 = mask | newBit;
                if (Integer.bitCount(m2) > k) {
                    res = Math.max(res, 1 + dfs(s, i + 1, false, newBit, k, memo));
                } else {
                    res = Math.max(res, dfs(s, i + 1, false, m2, k, memo));
                }
            }
        }

        memo.put(key, res);
        return res;
    }
}