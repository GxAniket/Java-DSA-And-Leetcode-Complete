class Solution {
    public int minimumArea(int[][] grid, int sRow, int eRow, int sCol, int eCol) {
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = sRow; i <= eRow; i++) {
            for (int j = sCol; j <= eCol; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        if (top == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE / 3;
        }

        return (bottom - top + 1) * (right - left + 1);
    }
    
    public int minimumSum(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;

        int area = Integer.MAX_VALUE;

        // Horizontally
        for (int r1 = 0; r1 + 2 < rows; r1++) {
            for (int r2 = r1 + 1; r2 + 1 < rows; r2++) {
                int ans = minimumArea(grid, 0, r1, 0, colums - 1) + 
                minimumArea(grid, r1 + 1, r2, 0, colums - 1) + 
                minimumArea(grid, r2 + 1, rows - 1, 0, colums - 1); 

                area = Math.min(ans, area);
            }
        }

        // Vertically cuts
        for (int c1 = 0; c1 + 2 < colums; c1++) {
            for (int c2 = c1 + 1; c2 + 1 < colums; c2++) {
                int ans = minimumArea(grid, 0, rows - 1, 0, c1) + 
                minimumArea(grid, 0, rows - 1, c1 + 1, c2) + 
                minimumArea(grid, 0, rows - 1, c2 + 1, colums - 1);

                area = Math.min(ans, area);
            }
        }

        // Horizontally First
        for (int row = 0; row + 1 < rows; row++) {
            for (int col = 0; col + 1 < colums; col++) {
                int ans = minimumArea(grid, 0, row, 0, colums - 1) + 
                minimumArea(grid, row + 1, rows - 1, 0, col) + 
                minimumArea(grid, row + 1, rows - 1, col + 1, colums - 1);

                area = Math.min(ans, area);

                ans = minimumArea(grid, 0, row, 0, col) + 
                minimumArea(grid, 0, row, col + 1, colums - 1) + 
                minimumArea(grid, row + 1, rows - 1, 0, colums - 1);

                area = Math.min(ans, area);
            }
        }

        // First Vertically Cut
        for (int col = 0; col + 1 < colums; col++) {
            for (int row = 0; row + 1 < rows; row++) {
                int ans = minimumArea(grid, 0, rows - 1, 0, col) + 
                minimumArea(grid, 0, row, col + 1, colums - 1) + 
                minimumArea(grid, row + 1, rows - 1, col + 1, colums - 1);

                area = Math.min(ans, area);

                ans = minimumArea(grid, 0, row, 0, col) + 
                minimumArea(grid, row + 1, rows - 1, 0, col) + 
                minimumArea(grid, 0, rows - 1, col + 1, colums - 1);

                area = Math.min(ans, area);
            }
        }

        return area;
    }
}
