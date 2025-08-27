You are given a 2D integer matrix grid of size n x m, where each element is either 0, 1, or 2.

A V-shaped diagonal segment is defined as:

The segment starts with 1.
The subsequent elements follow this infinite sequence: 2, 0, 2, 0, ....
The segment:
Starts along a diagonal direction (top-left to bottom-right, bottom-right to top-left, top-right to bottom-left, or bottom-left to top-right).
Continues the sequence in the same diagonal direction.
Makes at most one clockwise 90-degree turn to another diagonal direction while maintaining the sequence.


Return the length of the longest V-shaped diagonal segment. If no valid segment exists, return 0.

 

Example 1:

Input: grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]

Output: 5

Explanation:



The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,2) → (1,3) → (2,4), takes a 90-degree clockwise turn at (2,4), and continues as (3,3) → (4,2).

Example 2:

Input: grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]

Output: 4

Explanation:



The longest V-shaped diagonal segment has a length of 4 and follows these coordinates: (2,3) → (3,2), takes a 90-degree clockwise turn at (3,2), and continues as (2,1) → (1,0).

Example 3:

Input: grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]

Output: 5

Explanation:



The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,0) → (1,1) → (2,2) → (3,3) → (4,4).

Example 4:

Input: grid = [[1]]

Output: 1

Explanation:

The longest V-shaped diagonal segment has a length of 1 and follows these coordinates: (0,0).

 

Constraints:

n == grid.length
m == grid[i].length
1 <= n, m <= 500
grid[i][j] is either 0, 1 or 2.

Code:


Approach 1:

Recursion: (NO MEMO -ABLE TO PASS)

class Solution {
    //4 diagonal Directions : bottom-right, bottom -left, top -left, top -right
    private static final int[][] DIRS = {
            { 1, 1 }, //BOTTOM -RIGHT
            { 1, -1 }, //BOTTOM-LEFT
            { -1, -1 }, //TOP-LEFT
            { -1, 1 } //TOP-RIGHT
    };
    private int[][] grid;
    private int rows, cols;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        int longest = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols; j++){
                if(grid[i][j] == 1){
                    for(int dir = 0;dir < 4; dir++){
                        //start walking diagonally
                        //sequence starts from 1, so next expected value is 2
                        longest = Math.max(longest, dfs(i,j,dir, true,2) + 1);
                    }
                }
            }
        }
        return longest;
    }
    
    private int dfs(int x, int y, int dir, boolean canTurn, int target){
        int nx = x + DIRS[dir][0];
        int ny = y + DIRS[dir][1];

        //If out of bounds or value doesn't match target, stop here
        if(nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] != target){
            return 0;
        }

        //case 1: keep going straight in the same direction

        int maxSteps = dfs(nx,ny, dir, canTurn, 2- target);

        //case 2: Take one clockwise turn (only if we still can)

        if(canTurn){
            int newDir = (dir + 1 ) % 4 ; //clockwise turn
            maxSteps = Math.max(maxSteps, dfs(nx, ny, newDir, false, 2 - target));
        }

        return maxSteps + 1;


    }
    
}


Approach 2:


Recursion + Memoization:

class Solution {
    // 4 diagonal directions: bottom-right, bottom-left, top-left, top-right
    private static final int[][] DIRS = {
        { 1, 1 },   // bottom-right
        { 1, -1 },  // bottom-left
        { -1, -1 }, // top-left
        { -1, 1 }   // top-right
    };
    private int[][] grid;
    private int rows, cols;
    // Memoization cache: dp[x][y][dir][turnUsed]
    private int[][][][] memo;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        // Initialize memo with -1 (means not computed yet)
        this.memo = new int[rows][cols][4][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    Arrays.fill(memo[i][j][dir], -1);
                }
            }
        }

        int longest = 0;

        // Start DFS only from cells that are "1"
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        // Start walking diagonally
                        // sequence starts from 1, so next expected value is 2
                        longest = Math.max(longest, dfs(i, j, dir, true, 2) + 1);
                    }
                }
            }
        }

        return longest;
    }

    private int dfs(int x, int y, int dir, boolean canTurn, int target) {
        int nx = x + DIRS[dir][0];
        int ny = y + DIRS[dir][1];

        // If out of bounds or value doesn't match target, stop here
        if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] != target) {
            return 0;
        }

        int turnUsed = canTurn ? 1 : 0;
        if (memo[nx][ny][dir][turnUsed] != -1) {
            return memo[nx][ny][dir][turnUsed];
        }

        // Case 1: Keep going straight in the same direction
        int maxSteps = dfs(nx, ny, dir, canTurn, 2 - target);

        // Case 2: Take one clockwise turn (only if we still can)
        if (canTurn) {
            int newDir = (dir + 1) % 4; // clockwise turn
            maxSteps = Math.max(maxSteps, dfs(nx, ny, newDir, false, 2 - target));
        }

        // Include this cell in the path
        return memo[nx][ny][dir][turnUsed] = maxSteps + 1;
    }
}
