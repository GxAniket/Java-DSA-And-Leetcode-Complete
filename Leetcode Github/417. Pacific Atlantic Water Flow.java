import java.util.*;

public class PacificAtlanticWaterFlow {
    static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();

        // Start DFS from Pacific and Atlantic borders
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]);
        }

        // Find cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Out of bounds or invalid height
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;

        for (int[] dir : directions) {
            dfs(heights, visited, i + dir[0], j + dir[1], heights[i][j]);
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        List<List<Integer>> res = pacificAtlantic(heights);
        System.out.println("Cells where water can flow to both oceans:");
        for (List<Integer> cell : res) {
            System.out.println(cell);
        }
    }
}