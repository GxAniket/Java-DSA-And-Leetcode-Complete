class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) {
            nums.add((double) c);
        }

        return helper(nums);
    }

    // 10 / 3 = 3.333 = 3.333333333....

    private boolean helper(List<Double> nums) {
        int n = nums.size();

        if (n == 1) {
            return Math.abs((nums.get(0) - 24.0)) < 0.000001;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums.get(i);
                double b = nums.get(j);

                List<Double> operations = calOperations(a, b);

                List<Double> nextRound = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        nextRound.add(nums.get(k));
                    }
                }

                for (Double o : operations) {
                    nextRound.add(o);
                    if (helper(nextRound)) {
                        return true;
                    }
                    nextRound.remove(nextRound.size() - 1);
                }
            }
        }

        return false;
    }

    private List<Double> calOperations(double a, double b) {
        List<Double> result = new ArrayList<>();

        result.add(a + b);
        result.add(a - b);
        result.add(b - a);
        result.add(a * b);
        result.add(a / b);
        result.add(b / a);

        return result;
    }

}
