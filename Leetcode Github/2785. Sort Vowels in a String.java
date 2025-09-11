class Solution {
    public String sortVowels(String s) {
        // put vowels in a list
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) >= 0) {
                list.add(c);
            }
        }

        // sort the vowels
        Collections.sort(list);

        // build final string
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) >= 0) {
                sb.append(list.get(j++)); // replace with sorted vowel
            } else {
                sb.append(c); // keep same
            }
        }
        return sb.toString();
    }
}
