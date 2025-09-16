class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            // Keep merging while the last number and current num are non-coprime
            while (!result.isEmpty()) {
                int prev = result.get(result.size() - 1);
                int g = gcd(prev, num);

                if (g == 1) {
                    break; // coprime → no merging needed
                }

                // Remove last element and merge with current
                result.remove(result.size() - 1);
                long lcm = (long) prev / g * num; // avoid overflow
                num = (int) lcm; // new merged number becomes our "current"
            }
            result.add(num); // push into result
        }

        return result;
    }

    // Euclidean algorithm to find gcd
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
