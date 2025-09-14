import java.util.*;

public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String lower = w.toLowerCase();
            caseMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(lower.replaceAll("[aeiou]", "*"), w);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    ans[i] = caseMap.get(lower);
                } else {
                    ans[i] = vowelMap.getOrDefault(lower.replaceAll("[aeiou]", "*"), "");
                }
            }
        }
        return ans;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","keti","keto"};

        System.out.println(Arrays.toString(sol.spellchecker(wordlist, queries)));
        // Output: [kite, KiTe, KiTe, Hare, hare, "", KiTe, ""]
    }
}
