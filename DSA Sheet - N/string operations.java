1. Compare Two Strings using compareTo()
public class CompareToExample {
    public static void main(String[] args) {

        String s1 = "Apple";
        String s2 = "Banana";

        int result = s1.compareTo(s2);

        if (result == 0)
            System.out.println("Strings are equal");
        else if (result > 0)
            System.out.println("s1 is greater than s2");
        else
            System.out.println("s1 is smaller than s2");
    }
}
2. Find a Character using Loop
public class FindCharacter {
    public static void main(String[] args) {

        String str = "Programming";
        char ch = 'g';

        boolean found = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                System.out.println("Character found at index " + i);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Character not found");
    }
}
3. Check Palindrome (Without StringBuilder)
public class PalindromeCheck {
    public static void main(String[] args) {

        String str = "madam";
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        if (str.equals(rev))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
4. Check Anagram (Simple Method)
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if (Arrays.equals(a, b))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");
    }
}