class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int weeks = n / 7;
        int remainingDays = n % 7;

        // Money from complete weeks
        total += 28 * weeks + 7 * (weeks * (weeks - 1)) / 2;

        // Money from remaining days
        int start = weeks + 1;
        for (int i = 0; i < remainingDays; i++) {
            total += start + i;
        }

        return total;
    }
}
