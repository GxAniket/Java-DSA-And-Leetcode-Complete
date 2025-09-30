import java.util.*;

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        // Keep reducing until only one element remains
        for (int size = n; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        
        return nums[0];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Triangular Sum: " + sol.triangularSum(nums1)); 
        // Expected Output: 8

        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("Triangular Sum: " + sol.triangularSum(nums2)); 
        // Expected Output: 4

        int[] nums3 = {9};
        System.out.println("Triangular Sum: " + sol.triangularSum(nums3)); 
        // Expected Output: 9
    }
}