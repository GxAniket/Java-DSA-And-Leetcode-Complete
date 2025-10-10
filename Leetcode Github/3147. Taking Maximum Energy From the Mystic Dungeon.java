class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = Integer.MIN_VALUE;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int i = start; i < n; i += k) {
                sum += energy[i];
            }
            maxEnergy = Math.max(maxEnergy, sum);
        }

        return maxEnergy;
    }
}