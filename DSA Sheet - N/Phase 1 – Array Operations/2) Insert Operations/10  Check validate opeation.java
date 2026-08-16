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
