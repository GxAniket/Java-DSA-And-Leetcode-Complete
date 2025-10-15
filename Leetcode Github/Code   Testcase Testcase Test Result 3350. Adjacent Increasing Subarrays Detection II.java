import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        int pre = 0;
        int cur = 0;

        for (int i = 0; i < n; i++) {
            cur++;
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                ans = Math.max(ans, cur / 2);
                ans = Math.max(ans, Math.min(pre, cur));
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }
}
