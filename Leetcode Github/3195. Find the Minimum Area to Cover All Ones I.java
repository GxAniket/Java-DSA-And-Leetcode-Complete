import java.util.*;

public class MinimumAreaCoverOnes {

    // LeetCode function
    public static int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int minR = m, maxR = -1;
        int minC = n, maxC = -1;

        // Find bounding rectangle of all 1's
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    minR = Math.min(minR, r);
                    maxR = Math.max(maxR, r);
                    minC = Math.min(minC, c);
                    maxC = Math.max(maxC, c);
                }
            }
        }

        // If no 1s found, return 0
        if (maxR == -1) return 0;

        // Compute area: (rows) * (cols)
        return (maxR - minR + 1) * (maxC - minC + 1);
    }

    // Main function to test locally
    public static void main(String[] args) {
        // Test case 1
        int[][] grid1 = {
            {0,0,0,0},
            {0,1,0,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        System.out.println("Area: " + minimumArea(grid1)); // Expected: 4

        // Test case 2 - no 1s
        int[][] grid2 = {
            {0,0},
            {0,0}
        };
        System.out.println("Area: " + minimumArea(grid2)); // Expected: 0

        // Test case 3 - single 1
        int[][] grid3 = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println("Area: " + minimumArea(grid3)); // Expected: 1
    }
}
