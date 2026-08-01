1) Basic Operations
public class BasicOperations {
    public static void main(String[] args) {
        String str = "Hello";

        System.out.println("Character at index 1: " + str.charAt(1));
        System.out.println("Length: " + str.length());

        System.out.print("Traverse: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }

        String str2 = "Hello";
        System.out.println("\nCompare: " + str.equals(str2));
    }
}
2) Insert Operations
public class InsertOperations {
    public static void main(String[] args) {
        String str = "World";

        // Append
        System.out.println(str + "!");

        // Insert at index
        String result = str.substring(0, 2) + "XYZ" + str.substring(2);
        System.out.println(result);

        // Prepend
        System.out.println("Hello " + str);
    }
}
3) Delete Operations
public class DeleteOperations {
    public static void main(String[] args) {
        String str = "HelloWorld";

        // Remove at index 4
        String removeIndex = str.substring(0, 4) + str.substring(5);
        System.out.println(removeIndex);

        // Remove substring
        System.out.println(str.replace("World", ""));

        // Remove all occurrences of character
        System.out.println(str.replace("l", ""));
    }
}
4) Search Operations
public class SearchOperations {
    public static void main(String[] args) {
        String str = "banana";

        System.out.println("Index of a: " + str.indexOf('a'));

        System.out.println("Index of ana: " + str.indexOf("ana"));

        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a')
                count++;
        }
        System.out.println("Count of a: " + count);

        int subCount = 0;
        String sub = "an";

        for (int i = 0; i <= str.length() - sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub))
                subCount++;
        }

        System.out.println("Count of an: " + subCount);
    }
}
5) Update / Replace Operations
public class ReplaceOperations {
    public static void main(String[] args) {
        String str = "banana";

        // Replace character at index
        String result = str.substring(0, 2) + "X" + str.substring(3);
        System.out.println(result);

        // Replace all occurrences
        System.out.println(str.replace("a", "A"));

        // Replace first occurrence
        System.out.println(str.replaceFirst("a", "A"));
    }
}
6) Reverse Operations
public class ReverseOperations {
    public static void main(String[] args) {
        String str = "Hello World";

        // Reverse full string
        String rev = new StringBuilder(str).reverse().toString();
        System.out.println(rev);

        // Reverse words
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }

        System.out.println();

        // Reverse each word
        for (String word : words) {
            System.out.print(new StringBuilder(word).reverse() + " ");
        }
    }
}
7) Case and Trim Operations
public class CaseTrimOperations {
    public static void main(String[] args) {
        String str = "  Hello World  ";

        System.out.println(str.toUpperCase());

        System.out.println(str.toLowerCase());

        System.out.println(str.trim());

        System.out.println(str.replace(" ", ""));
    }
}
8) Split / Join Operations
public class SplitJoinOperations {
    public static void main(String[] args) {
        String str = "Java,Python,C++";

        // Split
        String[] arr = str.split(",");

        for (String s : arr) {
            System.out.println(s);
        }

        // Join
        String joined = String.join("-", arr);
        System.out.println(joined);

        // Individual characters
        char[] chars = "Hello".toCharArray();

        for (char c : chars) {
            System.out.print(c + " ");
        }
    }
}
9) Substring / Slice Operations
public class SubstringOperations {
    public static void main(String[] args) {
        String str = "Programming";

        String sub = str.substring(3, 8);

        System.out.println(sub);
    }
}
10) Check / Validate Operations
public class CheckOperations {
    public static void main(String[] args) {
        String str = "Hello123";

        System.out.println("Palindrome: " +
                str.equals(new StringBuilder(str).reverse().toString()));

        System.out.println("Anagram: " +
                isAnagram("listen", "silent"));

        System.out.println("Starts with Hello: " +
                str.startsWith("Hello"));

        System.out.println("Ends with 123: " +
                str.endsWith("123"));

        System.out.println("Contains lo1: " +
                str.contains("lo1"));
    }

    static boolean isAnagram(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        return java.util.Arrays.equals(arr1, arr2);
    }
}