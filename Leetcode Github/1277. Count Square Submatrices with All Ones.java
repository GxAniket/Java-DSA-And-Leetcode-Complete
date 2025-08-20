class Solution {
    // Function to count square submatrices with all 1s
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;

        // Traverse each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell has 1 and it's not in the first row/col
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    // Update this cell with the size of the largest square ending here
                    matrix[i][j] = 1 + Math.min(
                        matrix[i-1][j],          // top
                        Math.min(matrix[i][j-1], // left
                                 matrix[i-1][j-1]) // top-left
                    );
                }
                // Add the square count at this cell to the total
                count += matrix[i][j];
            }
        }
        return count;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        int result = sol.countSquares(matrix);
        System.out.println("Total square submatrices with all ones = " + result);
        // Expected Output: 15
    }
}
