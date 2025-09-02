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











// for interview question 





import java.util.*;

public class Main {
    // LeetCode-style signature
    static class Solution {
        public int numberOfPairs(int[][] points) {
            // 1) sort by x asc, y desc
            Arrays.sort(points, Comparator
                    .comparingInt((int[] p) -> p[0])
                    .thenComparingInt((int[] p) -> -p[1]));

            int n = points.length;
            int ans = 0;

            // 2) sweep: for each left point i, scan right points
            for (int i = 0; i < n; i++) {
                int yi = points[i][1];
                // best (largest) y found so far to the right, but still <= yi
                int maxY = Integer.MIN_VALUE;

                for (int j = i + 1; j < n; j++) {
                    int yj = points[j][1];
                    // upper-left condition: yi >= yj
                    // "empty rectangle" condition: yj must strictly exceed all previous candidates
                    if (yi >= yj && yj > maxY) {
                        ans++;
                        maxY = yj;
                    }
                }
            }
            return ans;
        }
    }

    // Quick runner with sample tests
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] p1 = {{1,1},{2,2},{3,3}}; // strictly diagonal up-right: 0
        System.out.println(s.numberOfPairs(p1)); // 0

        int[][] p2 = {{1,3},{2,2},{3,1}}; // all valid chain: (1,3)-(2,2), (1,3)-(3,1), (2,2)-(3,1) -> 3
        System.out.println(s.numberOfPairs(p2)); // 3

        int[][] p3 = {{1,4},{2,3},{2,2},{3,2},{4,1}}; // mixed x-ties handled by y desc
        System.out.println(s.numberOfPairs(p3));
    }
}


