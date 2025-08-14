class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        
        // Start from index 2 so we can check the last 3 chars at once
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                String candidate = num.substring(i - 2, i + 1);
                if (ans.isEmpty() || candidate.compareTo(ans) > 0) {
                    ans = candidate;
                }
            }
        }
        return ans;
    }
}
