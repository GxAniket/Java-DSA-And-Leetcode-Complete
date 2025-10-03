import java.util.*;

public class TrappingRainWaterII {
    private static class Cell {
        int row, col, height;
        Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));

        // Add boundary cells to priority queue
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int maxBoundary = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            maxBoundary = Math.max(maxBoundary, cell.height);

            for (int[] d : dirs) {
                int r = cell.row + d[0], c = cell.col + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    if (heightMap[r][c] < maxBoundary) {
                        totalWater += maxBoundary - heightMap[r][c];
                    }
                    pq.offer(new Cell(r, c, heightMap[r][c]));
                }
            }
        }
        return totalWater;
    }

    // Main function for testing
    public static void main(String[] args) {
        TrappingRainWaterII solver = new TrappingRainWaterII();

        // Example input
        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };

        int result = solver.trapRainWater(heightMap);
        System.out.println("Total trapped rain water: " + result);
    }
}