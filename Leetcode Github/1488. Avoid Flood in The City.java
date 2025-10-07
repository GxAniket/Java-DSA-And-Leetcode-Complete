import java.util.*;

public class Main {

    public static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];

        // Map to store which lake was last filled (lake → day index)
        Map<Integer, Integer> lakeFull = new HashMap<>();

        // TreeSet to store all available dry days (sorted order)
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            // Case 1: It’s a dry day (rains[i] == 0)
            if (rains[i] == 0) {
                // Add this day to dryDays list — can be used later
                dryDays.add(i);
                ans[i] = 1; // temporarily mark as 1 (will replace later if we decide which lake to dry)
            } 
            // Case 2: It’s raining on lake rains[i]
            else {
                int lake = rains[i];

                // If lake is already full, we must find a dry day after its last fill
                if (lakeFull.containsKey(lake)) {
                    // Find the next available dry day *after* the last time this lake was filled
                    Integer dryDay = dryDays.higher(lakeFull.get(lake));

                    // If no such dry day exists → flood occurs → return empty array
                    if (dryDay == null) {
                        return new int[0];
                    }

                    // On that dry day, we dry this lake
                    ans[dryDay] = lake;

                    // Remove that day from available dry days
                    dryDays.remove(dryDay);
                }

                // Update the day this lake got filled
                lakeFull.put(lake, i);

                // On rain days, we always put -1 as per problem statement
                ans[i] = -1;
            }
        }

        // Return the final array
        return ans;
    }

    public static void main(String[] args) {
        // Example input
        int[] rains = {1, 2, 0, 0, 2, 1};

        // Call the function
        int[] result = avoidFlood(rains);

        // If result is empty (means flood occurred), print "[]"
        if (result.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(result));
        }
    }
}
