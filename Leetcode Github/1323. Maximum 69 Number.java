class Solution {
    public int maximum69Number (int num) {
        // Convert number to string
        String numStr = String.valueOf(num);

        // Change first '6' to '9'
        numStr = numStr.replaceFirst("6", "9");

        // Convert back to integer
        return Integer.parseInt(numStr);
    }
}
