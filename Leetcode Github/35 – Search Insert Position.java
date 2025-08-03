//Add beginner-friendly comments explaining each part.

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // 🎯 Target found
            } else if (nums[mid] < target) {
                low = mid + 1; // 🔍 Go right
            } else {
                high = mid - 1; // 🔍 Go left
            }
        }

        return low; // 📍 Target not found, return insertion index
    }
}
