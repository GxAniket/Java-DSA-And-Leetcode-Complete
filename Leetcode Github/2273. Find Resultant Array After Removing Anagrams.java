import java.util.*;

public class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // If not same as previous sorted word, keep it
            if (!sorted.equals(prev)) {
                result.add(word);
                prev = sorted;
            }
        }
        return result;
    }
}