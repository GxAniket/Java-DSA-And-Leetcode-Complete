import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Step 1: Sort points by x ascending, then y descending
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int ans = 0;
        int n = points.length;

        // Step 2: For each point, check valid pairs
        for (int i = 0; i < n; i++) {
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                // If point j is below or on same height as i and above maxY
                if (points[j][1] <= points[i][1] && points[j][1] > maxY) {
                    ans++;
                    maxY = points[j][1];  // Update boundary
                }
            }
        }
        return ans;
    }

    // Main function to test locally
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] points1 = {{1, 3}, {2, 2}, {3, 1}};
        System.out.println("Output 1: " + sol.numberOfPairs(points1)); // Expected: 3

        int[][] points2 = {{1, 2}, {1, 1}, {2, 2}, {2, 1}};
        System.out.println("Output 2: " + sol.numberOfPairs(points2)); // Expected: 4
    }
}
