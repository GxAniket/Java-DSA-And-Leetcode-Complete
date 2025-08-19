class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;    // Stores the total count of zero-filled subarrays
        long count = 0;  // Tracks the current number of consecutive zeros

        for (int num : nums) {
            if (num == 0) {
                // Each new zero increases the current streak,
                // and every member of the streak forms a new subarray
                count++;     
                ans += count;
            } else {
                // Reset the zero streak if a non-zero is encountered
                count = 0;
            }
        }

        return ans;  // Return the total number of zero-filled subarrays
    }
}
