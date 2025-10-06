import java.util.*;

public class Main {

    static class Cell {
        int x, y, height;
        Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        pq.offer(new Cell(0, 0, grid[0][0]));
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int maxTime = 0;

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int i = curr.x, j = curr.y;
            maxTime = Math.max(maxTime, curr.height);

            if (i == n - 1 && j == n - 1) return maxTime;
            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj]) {
                    pq.offer(new Cell(ni, nj, grid[ni][nj]));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 2},
            {1, 3}
        };

        System.out.println("Minimum time to swim: " + swimInWater(grid));
    }
}
