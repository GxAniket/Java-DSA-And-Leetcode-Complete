class Solution {
    // This method signature must match LeetCode's expected one
    public int maxFreqSum(String s) {
        s = s.toLowerCase();
        int[] freq = new int[26]; // count of all letters
        String vowels = "aeiou";

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        for (char v : vowels.toCharArray()) {
            maxVowel = Math.max(maxVowel, freq[v - 'a']);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!vowels.contains("" + c)) {
                maxConsonant = Math.max(maxConsonant, freq[c - 'a']);
            }
        }

        return maxVowel + maxConsonant; // Example: returning sum of max freq vowel + consonant
    }
}
