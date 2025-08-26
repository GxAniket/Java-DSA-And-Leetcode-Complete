public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example input: dimensions of rectangles [length, width]
        int[][] dimensions = {
            {9, 3},
            {8, 6},
            {5, 12},
            {10, 10}
        };

        // Calling the method
        int result = sol.areaOfMaxDiagonal(dimensions);

        // Printing the output
        System.out.println("Maximum area of rectangle with longest diagonal: " + result);
    }
}

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0, maxArea = 0;

        for (int[] d : dimensions) {
            int l = d[0], w = d[1];
            int diag = l * l + w * w;  // squared diagonal length
            int area = l * w;

            // Update if we find a longer diagonal or same diagonal with larger area
            if (diag > maxDiag || (diag == maxDiag && area > maxArea)) {
                maxDiag = diag;
                maxArea = area;
            }
        }
        return maxArea;
    }
}
