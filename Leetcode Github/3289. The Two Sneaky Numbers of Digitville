class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int[] result = new int[2];
        boolean firstFound = false;

        for (int n : nums) {
            if (!uniqueNumbers.add(n)) {
                if (firstFound) {
                    result[1] = n;
                    return result;
                } else {
                    firstFound = true;
                    result[0] = n;
                }
            }
        }

        return result;
    }
}
