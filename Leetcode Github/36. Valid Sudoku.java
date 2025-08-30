public class Main {
    public static void main(String[] args) {
        // Sample Sudoku board (valid)
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        Solution solution = new Solution();
        boolean isValid = solution.isValidSudoku(board);

        if (isValid) {
            System.out.println("The Sudoku board is valid!");
        } else {
            System.out.println("The Sudoku board is invalid!");
        }
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9], col = new int[9], box = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int bit = 1 << (ch - '1');
                int b = (r / 3) * 3 + (c / 3);

                if ((row[r] & bit) != 0 || (col[c] & bit) != 0 || (box[b] & bit) != 0) {
                    return false;
                }
                row[r] |= bit;
                col[c] |= bit;
                box[b] |= bit;
            }
        }
        return true;
    }
}
