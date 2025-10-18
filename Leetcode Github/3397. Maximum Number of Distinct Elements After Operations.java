class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        long occupied = Long.MIN_VALUE;  // use long just in case of very small / large bounds
        
        for (int x : nums) {
            if (occupied < (long)x + k) {
                // we can assign a new distinct value
                long candidate = Math.max(occupied + 1, (long)x - k);
                // candidate is guaranteed ≤ x+k (since occupied < x+k → occupied+1 ≤ x+k+1)
                // so it's within allowed range
                occupied = candidate;
                ans++;
            }
            // else: if occupied >= x+k, then this element's entire [x-k, x+k] range is
            // <= occupied, so you cannot pick a new distinct > occupied; skip it.
        }
        
        return ans;
    }
}