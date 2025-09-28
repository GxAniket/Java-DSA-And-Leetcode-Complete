import java.util.Arrays;

public class ValidTriangleNumber {

    // Function to count valid triangles
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int count = 0;
        int n = nums.length;

        // Step 2: Fix the largest side nums[k] and use two pointers for the other two sides
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // If nums[i] + nums[j] > nums[k], all pairs between i and j are valid
                    count += (j - i);
                    j--; // Move the right pointer left
                } else {
                    i++; // Move the left pointer right
                }
            }
        }

        return count;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4}; // Example input
        int result = triangleNumber(nums); // Call the function
        System.out.println("Number of valid triangles: " + result); // Output the result
    }
}
