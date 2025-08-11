class Solution {
    static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Build the powers array from n's binary representation
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        for (int bit = 0; bit < 31; bit++) {
            if ((n & (1 << bit)) != 0) {
                powers.add(1 << bit);
            }
        }

        int m = queries.length;
        int[] result = new int[m];

        // Step 2: Process each query
        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long product = 1;

            for (int j = left; j <= right; j++) {
                product = (product * powers.get(j)) % MOD;
            }

            result[i] = (int) product;
        }

        return result;
    }
}
