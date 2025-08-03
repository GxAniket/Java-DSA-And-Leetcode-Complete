class Solution {
    // Main function to calculate the maximum fruits that can be collected
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int res = 0;     // Stores the maximum number of fruits collected
        int sum = 0;     // Running total of fruits in the current window
        int left = 0;    // Left pointer of the sliding window

        // Iterate over fruits with the right pointer
        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit's amount to the running sum
            sum += fruits[right][1];

            // While the total steps needed to go from startPos to the current window [left, right] exceeds k,
            // shrink the window from the left
            while (left <= right && steps(fruits[left][0], fruits[right][0], startPos) > k)
                sum -= fruits[left++][1];  // Subtract fruit at 'left' and move 'left' forward

            // Update result if current window has more fruits
            res = Math.max(res, sum);
        }
        return res;  // Return the maximum fruits collected within k steps
    }

    // Helper function to calculate minimum steps needed to cover range [l, r] from startPos
    private int steps(int l, int r, int s) {
        // Two movement strategies:
        // 1. Go to left end first, then to right end: abs(s - l) + (r - l)
        // 2. Go to right end first, then to left end: abs(s - r) + (r - l)
        return Math.min(Math.abs(s - l) + (r - l), Math.abs(s - r) + (r - l));
    }
}
