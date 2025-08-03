class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target
            } else if (nums[mid] < target) {
                low = mid + 1; // Go right
            } else {
                high = mid - 1; // Go left
            }
        }

        return -1; // Target not found
    }
}

//Second 

//class Solution {
   // public int search(int[] nums, int target) {
       //  int num=0;
       // for(int i=0;i <nums.length;i++){
        //    if(nums[i]==target){
             //   return i;

           //}

     //   }
   //     return -1;
        
 //   }
//}
