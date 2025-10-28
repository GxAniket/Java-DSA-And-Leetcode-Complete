class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        int answer = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                leftSum += nums[i];
            } else {
                // nums[i] == 0, candidate start
                int rightSum = total - leftSum;
                if (leftSum == rightSum) {
                    answer += 2;
                } else if (Math.abs(leftSum - rightSum) == 1) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}