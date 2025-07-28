class Solution {
    int maxOR = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currentOR){
        if (index == nums.length) {
            if (currentOR == maxOR){
            count++;
        } else if (currentOR > maxOR) {
            maxOR = currentOR;
            count =1;
        }
        return;
        }
       dfs(nums, index + 1, currentOR | nums[index]);

       dfs(nums, index + 1 , currentOR);
    }

}
