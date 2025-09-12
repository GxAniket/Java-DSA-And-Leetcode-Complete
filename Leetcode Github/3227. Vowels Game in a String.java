class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                return true; // Alice wins if any vowel exists
            }
        }
        return false; // Bob wins if no vowel exists
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
