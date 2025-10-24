class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBalanced(num)) return num;
            num++;
        }
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];
        char[] digits = String.valueOf(num).toCharArray();

        for (char c : digits) {
            count[c - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            if (count[i] != 0 && count[i] != i) return false;
        }

        return true;
    }
}