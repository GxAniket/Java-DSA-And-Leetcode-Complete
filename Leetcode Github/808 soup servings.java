class Solution {

    private Double[][] memo;

    public double soupServings(int n) {
        int N = (n + 24) / 25;  // normalize to units of 25 ml
        if (N >= 200) return 1.0; // cutoff for large n
        memo = new Double[N + 1][N + 1];
        return dfs(N, N);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (memo[a][b] != null) return memo[a][b];

        double res = 0.25 * dfs(a - 4, b)
                   + 0.25 * dfs(a - 3, b - 1)
                   + 0.25 * dfs(a - 2, b - 2)
                   + 0.25 * dfs(a - 1, b - 3);

        memo[a][b] = res;
        return res;
    }
}