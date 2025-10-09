class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] time = new long[n];

        for (int x : mana) {
            time[0] = time[0] + 1L * skill[0] * x;
            for (int i = 1; i < n; i++) {
                time[i] = Math.max(time[i], time[i - 1]) + 1L * skill[i] * x;
            }
            for (int i = n - 2; i >= 0; i--) {
                time[i] = time[i + 1] - 1L * skill[i + 1] * x;
            }
        }
        return time[n - 1];
    }
}
