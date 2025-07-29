import java.util.*;
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] bitPos = new int[32];
        Arrays.fill(bitPos, -1);

        for (int i = n - 1; i >= 0; i--){
            for (int b = 0; b < 32; b++){
                if (((nums[i] >> b) & 1)==1){
                    bitPos[b] = i;
                }
            }
            int maxLen = i;
            for (int b =0; b < 32; b++ ){
                if (bitPos[b] != -1) {
                    maxLen = Math.max(maxLen, bitPos[b]);
                }
            }

            res[i] = maxLen - i +1;
        }

        return res;
    }
}
