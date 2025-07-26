import java.util.*;

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<List<Integer>> conflicts = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            conflicts.add(new ArrayList<>());
        }

        for (int[] pair : conflictingPairs) {
            int a = pair[0];
            int b = pair[1];
            conflicts.get(Math.max(a, b)).add(Math.min(a, b));
        }

        int maxLeft = 0, secondMaxLeft = 0;
        long valid = 0;
        long[] gains = new long[n + 1];

        for (int r = 1; r <= n; r++) {
            for (int l : conflicts.get(r)) {
                if (l > maxLeft) {
                    secondMaxLeft = maxLeft;
                    maxLeft = l;
                } else if (l > secondMaxLeft) {
                    secondMaxLeft = l;
                }
            }

            valid += r - maxLeft;
            gains[maxLeft] += maxLeft - secondMaxLeft;
        }

        long bestGain = 0;
        for (long gain : gains) {
            bestGain = Math.max(bestGain, gain);
        }

        return valid + bestGain;
    }
}
