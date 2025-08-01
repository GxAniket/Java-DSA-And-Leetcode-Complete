public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 121; // You can change this value to test
        boolean isPalindrome = isPalindrome(number);

        if (isPalindrome) {
            System.out.println(number + " is a Palindrome ✅");
        } else {
            System.out.println(number + " is NOT a Palindrome ❌");
        }
    }

    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow (very large numbers)
            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                return false;
            }

            reversed = reversed * 10 + digit;
            x = x / 10;
        }

        // Check if reversed number equals the original
        return original == reversed;
    }
}
