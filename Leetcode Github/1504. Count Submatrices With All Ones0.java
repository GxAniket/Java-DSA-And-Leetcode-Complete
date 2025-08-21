import java.util.*;

public class CountSubmatricesAllOnes {
    // LeetCode Solution Method
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] width = new int[m][n];
        int total = 0;

        // Step 1: Compute consecutive 1s to the left for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    width[i][j] = (j == 0 ? 1 : width[i][j - 1] + 1);
                }
            }
        }

        // Step 2: Count rectangles ending at (i, j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;

                int minWidth = width[i][j];
                // Move upwards
                for (int k = i; k >= 0; k--) {
                    if (width[k][j] == 0) break;
                    minWidth = Math.min(minWidth, width[k][j]);
                    total += minWidth; // count rectangles
                }
            }
        }

        return total;
    }

    // Main function for local testing
    public static void main(String[] args) {
        CountSubmatricesAllOnes solution = new CountSubmatricesAllOnes();

        int[][] mat = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };

        System.out.println("Total Submatrices with All Ones: " + solution.numSubmat(mat));
    }
}
