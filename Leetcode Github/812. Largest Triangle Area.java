public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test case
        int[][] points = {
            {0, 0},
            {0, 1},
            {1, 0},
            {0, 2},
            {2, 0}
        };

        double result = sol.largestTriangleArea(points);
        System.out.println("Largest Triangle Area = " + result);
    }
}

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = area(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private double area(int[] a, int[] b, int[] c) {
        return Math.abs(
                a[0] * (b[1] - c[1]) +
                b[0] * (c[1] - a[1]) +
                c[0] * (a[1] - b[1])
        ) / 2.0;
    }
}
