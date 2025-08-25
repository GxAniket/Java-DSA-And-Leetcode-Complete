class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0, dir = 1; // dir = 1 → up-right, dir = -1 → down-left

        for (int i = 0; i < m * n; i++) {
            res[i] = mat[row][col];
            
            // Moving up-right
            if (dir == 1) {
                if (col == n - 1) { row++; dir = -1; } // right edge
                else if (row == 0) { col++; dir = -1; } // top edge
                else { row--; col++; } // normal up-right
            } 
            // Moving down-left
            else {
                if (row == m - 1) { col++; dir = 1; } // bottom edge
                else if (col == 0) { row++; dir = 1; } // left edge
                else { row++; col--; } // normal down-left
            }
        }
        return res;
    }
}
