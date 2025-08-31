public class SudokuSolver {
    public static void main(String[] args) {
        // Initial Sudoku Board ('.' means empty cell)
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

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);  // Solve Sudoku

        // Print Solved Sudoku
        System.out.println("Solved Sudoku:");
        printBoard(board);
    }

    // Solve Sudoku using Backtracking
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid number → backtrack
                }
            }
        }
        return true; // Solved
    }

    // Check if it's safe to place the number
    private boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false; // Row check
            if (board[i][col] == num) return false; // Column check
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] == num) return false; // 3x3 box check
        }
        return true;
    }

    // Print the board
    private static void printBoard(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
