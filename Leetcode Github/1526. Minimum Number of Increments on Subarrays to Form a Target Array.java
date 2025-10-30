class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int res = 0;
        int prev = 0;

        for (int i = 0; i < n; i++) {
            int curr = target[i];
            if (curr > prev) {
                res += (curr - prev);
            }
            prev = curr;
        }

        return res;
    }
}
