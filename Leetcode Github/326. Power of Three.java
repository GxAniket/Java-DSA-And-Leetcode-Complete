class Solution {
    public boolean isPowerOfThree(int n) {
        // Base case: powers of 3 are positive
        if (n <= 0) return false;
        
        // Keep dividing by 3 while divisible
        while (n % 3 == 0) {
            n /= 3;
        }
        
        // If we end at 1, it was a power of 3
        return n == 1;
    }
}
