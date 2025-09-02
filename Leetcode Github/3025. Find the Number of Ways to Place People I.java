import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort by x ascending, then y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int n = points.length;
        int count = 0;

        // For each left point i, check right points j
        for (int i = 0; i < n; i++) {
            int yi = points[i][1];
            int maxY = Integer.MIN_VALUE; // Track largest y so far on right side <= yi

            for (int j = i + 1; j < n; j++) {
                int yj = points[j][1];
                if (yi >= yj && yj > maxY) {
                    count++;
                    maxY = yj; // update for next
                }
            }
        }
        return count;
    }
}
