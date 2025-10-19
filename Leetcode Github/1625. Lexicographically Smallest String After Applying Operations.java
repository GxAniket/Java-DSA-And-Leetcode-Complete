import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String smallest = s;

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            // Operation 1: add 'a' to digits at odd indices
            String added = addOperation(curr, a);
            if (visited.add(added)) {
                queue.add(added);
            }

            // Operation 2: rotate by 'b'
            String rotated = rotateOperation(curr, b);
            if (visited.add(rotated)) {
                queue.add(rotated);
            }
        }

        return smallest;
    }

    private String addOperation(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            int newVal = ((chars[i] - '0') + a) % 10;
            chars[i] = (char) ('0' + newVal);
        }
        return new String(chars);
    }

    private String rotateOperation(String s, int b) {
        int n = s.length();
        b %= n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
