import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;

        // Frequency of exact numbers
        HashMap<Integer, Integer> count = new HashMap<>(n * 2);
        // Sweep line events: start +1, end+1 -1
        HashMap<Long, Integer> line = new HashMap<>(n * 2);
        // Candidate positions to check
        HashSet<Long> candidates = new HashSet<>(n * 3);

        for (int v : nums) {
            count.put(v, count.getOrDefault(v, 0) + 1);

            long start = (long) v - k;
            long endPlusOne = (long) v + k + 1L;
            line.put(start, line.getOrDefault(start, 0) + 1);
            line.put(endPlusOne, line.getOrDefault(endPlusOne, 0) - 1);

            candidates.add((long) v - k);
            candidates.add((long) v);
            candidates.add((long) v + k);
        }

        // Merge all important coordinates
        TreeSet<Long> keys = new TreeSet<>();
        keys.addAll(line.keySet());
        keys.addAll(candidates);

        int adjustable = 0;
        int ans = 1;

        for (long key : keys) {
            adjustable += line.getOrDefault(key, 0);

            if (candidates.contains(key)) {
                int equal = count.getOrDefault((int) key, 0);
                int canChange = Math.max(0, adjustable - equal);
                int possible = equal + Math.min(numOperations, canChange);
                ans = Math.max(ans, possible);
            }
        }

        return ans;
    }
}
