class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles; // pehle se milne wali bottles

        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int remBottles = numBottles % numExchange; 
            ans += newBottles;           
            numBottles = newBottles + remBottles;   
        }

        return ans;
    }

    // Simple test harness
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numWaterBottles(9, 3));  // expected 13
        System.out.println(s.numWaterBottles(15, 4)); // expected 18
    }
}
