class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            int rem = ((num % value) + value) % value; // handle negative remainders
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }
        
        int x = 0;
        while (true) {
            int rem = x % value;
            if (!freq.containsKey(rem) || freq.get(rem) == 0) {
                return x;
            }
            freq.put(rem, freq.get(rem) - 1);
            x++;
        }
    }
}