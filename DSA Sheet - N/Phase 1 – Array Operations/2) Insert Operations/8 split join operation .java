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
