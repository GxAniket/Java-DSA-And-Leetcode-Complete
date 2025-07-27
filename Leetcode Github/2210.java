import java.util.*;

public class Main {

    // Method to count hills and valleys
    public static int countHillValley(int[] nums) {
        // Step 1: Remove adjacent duplicates
        List<Integer> filtered = new ArrayList<>();
        filtered.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                filtered.add(nums[i]);
            }
        }

        // Step 2: Count hills and valleys
        int count = 0;
        for (int i = 1; i < filtered.size() - 1; i++) {
            int prev = filtered.get(i - 1);
            int curr = filtered.get(i);
            int next = filtered.get(i + 1);

            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {2, 4, 1, 1, 6, 5};

        // Call the function and print result
        int result = countHillValley(nums);
        System.out.println("Number of hills and valleys: " + result);
    }
}
