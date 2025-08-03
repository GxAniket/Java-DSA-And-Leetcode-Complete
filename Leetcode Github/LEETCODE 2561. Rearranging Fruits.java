import java.util.*;

public class RearrangingFruits {
    public static long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Count difference of fruits
        for (int n : basket1) map.put(n, map.getOrDefault(n, 0) + 1);
        for (int n : basket2) map.put(n, map.getOrDefault(n, 0) - 1);

        List<Integer> swaps = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val % 2 != 0) return -1; // Not possible
            min = Math.min(min, entry.getKey());

            for (int i = 0; i < Math.abs(val) / 2; ++i) {
                swaps.add(entry.getKey());
            }
        }

        Collections.sort(swaps);
        long res = 0;

        for (int i = 0; i < swaps.size() / 2; ++i) {
            res += Math.min(2 * min, swaps.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
      
        int[] basket1 = {4, 2, 2, 2};
        int[] basket2 = {1, 4, 1, 2};

        long result = minCost(basket1, basket2);
        System.out.println("Minimum cost to rearrange fruits: " + result);
    }
}
