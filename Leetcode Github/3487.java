import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        // To store the maximum value in case all elements are non-positive
        int max = Integer.MIN_VALUE;

        // To keep track of unique positive elements
        Set<Integer> seen = new HashSet<>();
        int sum = 0;

        // Iterate through each number in the array
        for (int num : nums) {
            // Update max with the highest number seen so far
            max = Math.max(max, num);

            // If it's a positive number and not already included
            if (num > 0 && !seen.contains(num)) {
                sum += num;        // Add to total sum
                seen.add(num);     // Mark as seen to avoid duplication
            }
        }

        // If sum is greater than 0, return it; otherwise return the max (handles all non-positive case)
        return sum > 0 ? sum : max;
    }
}
