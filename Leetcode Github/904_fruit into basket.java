import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int left = 0, maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);

            while (countMap.size() > 2) {
                countMap.put(fruits[left], countMap.get(fruits[left]) - 1);
                if (countMap.get(fruits[left]) == 0) {
                    countMap.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
