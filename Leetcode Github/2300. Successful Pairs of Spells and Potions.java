import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // Sort potions for binary search
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            // Binary search for first potion where spell * potion >= success
            int left = 0, right = m - 1;
            int idx = m; // Default (if no potion is successful)
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) {
                    idx = mid;
                    right = mid - 1; // try to find smaller potion that still works
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - idx; // count of successful potions
        }

        return result;
    }
}
