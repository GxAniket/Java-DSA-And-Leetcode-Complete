import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Collect each diagonal into a list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i - j, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        // Step 2: Sort each diagonal
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> diag = entry.getValue();
            int key = entry.getKey();
            if (key >= 0) { // bottom-left → descending
                diag.sort(Collections.reverseOrder());
            } else {        // top-right → ascending
                Collections.sort(diag);
            }
        }

        // Step 3: Write back sorted values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> diag = map.get(i - j);
                grid[i][j] = diag.remove(0);
            }
        }

        return grid;
    }
}
