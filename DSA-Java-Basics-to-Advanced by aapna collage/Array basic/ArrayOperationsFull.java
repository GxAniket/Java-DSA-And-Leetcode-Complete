import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperationsFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // for user input

        // 1. INPUT array size and elements
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\n✅ Original Array:");
        printArray(arr);

        // 2. INSERT
        System.out.print("\nEnter value to insert at the end: ");
        int insertVal = sc.nextInt();
        arr = insertElement(arr, insertVal);
        System.out.println("✅ After Inserting " + insertVal + ":");
        printArray(arr);

        // 3. UPDATE
        System.out.print("\nEnter index to update: ");
        int updateIndex = sc.nextInt();
        System.out.print("Enter new value: ");
        int newValue = sc.nextInt();

        if (updateIndex >= 0 && updateIndex < arr.length) {
            arr[updateIndex] = newValue;
            System.out.println("✅ After Updating index " + updateIndex + " to " + newValue + ":");
            printArray(arr);
        } else {
            System.out.println("❌ Invalid index");
        }

        // 4. DELETE
        System.out.print("\nEnter value to delete: ");
        int deleteVal = sc.nextInt();
        arr = deleteElement(arr, deleteVal);
        System.out.println("✅ After Deleting " + deleteVal + ":");
        printArray(arr);

        // 5. SEARCH
        System.out.print("\nEnter value to search: ");
        int searchVal = sc.nextInt();
        int index = searchElement(arr, searchVal);
        if (index != -1) {
            System.out.println("✅ Found at index: " + index);
        } else {
            System.out.println("❌ Not found");
        }

        // 6. MAX and MIN
        System.out.println("\n✅ Max value: " + findMax(arr));
        System.out.println("✅ Min value: " + findMin(arr));

        // 7. REVERSE
        reverseArray(arr);
        System.out.println("\n✅ After Reversing:");
        printArray(arr);

        // 8. SORT
        Arrays.sort(arr);
        System.out.println("✅ After Sorting:");
        printArray(arr);

        // 9. LENGTH
        System.out.println("✅ Array Length: " + arr.length);

        sc.close(); // CLOSE the Scanner
    }

    // 🔁 PRINT
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // ➕ INSERT
    public static int[] insertElement(int[] arr, int value) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = value;
        return newArr;
    }

    // ❌ DELETE
    public static int[] deleteElement(int[] arr, int value) {
        int index = searchElement(arr, value);
        if (index == -1) return arr;

        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    // 🔍 SEARCH
    public static int searchElement(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    // 🔼 MAX
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (val > max) max = val;
        }
        return max;
    }

    // 🔽 MIN
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
        }
        return min;
    }

    // 🔄 REVERSE
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
