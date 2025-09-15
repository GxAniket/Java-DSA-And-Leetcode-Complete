public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;

        for (String word : words) {
            boolean canType = true;
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) { // contains broken letter
                    canType = false;
                    break;
                }
            }
            if (canType) count++;
        }

        return count; // inside the method
    }
} // <-- THIS was missing
