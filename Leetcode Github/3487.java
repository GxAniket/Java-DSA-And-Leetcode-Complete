//3487. Maximum Unique Subarray Sum After Deletion
import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> seen = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            if (num > 0 && !seen.contains(num)) {
                sum += num;
                seen.add(num);
            }
        }

        // If all elements are non-positive
        return sum > 0 ? sum : max;
    }
}
