import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input = "({[]})"; // Try changing this to "[({)]}"
        boolean isValid = isValid(input);

        if (isValid) {
            System.out.println(input + " → Valid ✅");
        } else {
            System.out.println(input + " → Invalid ❌");
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
