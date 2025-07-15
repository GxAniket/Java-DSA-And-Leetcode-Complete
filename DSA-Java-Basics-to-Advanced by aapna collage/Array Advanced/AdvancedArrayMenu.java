import java.util.Arrays;
import java.util.Scanner;

public class AdvancedArrayMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array from user
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Menu-driven loop
        while (true) {
            System.out.println("\n🔘 MENU 🔘");
            System.out.println("1. Insert at index");
            System.out.println("2. Delete at index");
            System.out.println("3. Rotate Left");
            System.out.println("4. Count Frequency");
            System.out.println("5. Find Duplicates");
            System.out.println("6. Show Array");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1-7): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter index to insert: ");
                    int insertIndex = sc.nextInt();
                    System.out.print("Enter value to insert: ");
                    int insertVal = sc.nextInt();
                    arr = insertAtIndex(arr, insertIndex, insertVal);
                    break;

                case 2:
                    System.out.print("Enter index to delete: ");
                    int delIndex = sc.nextInt();
                    arr = deleteAtIndex(arr, delIndex);
                    break;

                case 3:
                    rotateLeft(arr);
                    System.out.println("✅ Rotated left by 1.");
                    break;

                case 4:
                    System.out.println("📊 Frequency of elements:");
                    countFrequency(arr);
                    break;

                case 5:
                    System.out.println("🔁 Duplicates in array:");
                    findDuplicates(arr);
                    break;

                case 6:
                    System.out.println("📌 Current Array:");
                    printArray(arr);
                    break;

                case 7:
                    System.out.println("👋 Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    // 🧾 Print
    public static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

    // ➕ Insert at index
    public static int[] insertAtIndex(int[] arr, int index, int value) {
        if (index < 0 || index > arr.length) {
            System.out.println("❌ Invalid index!");
            return arr;
        }

        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = arr[j++];
            }
        }

        System.out.println("✅ Inserted successfully.");
        return newArr;
    }

    // ❌ Delete at index
    public static int[] deleteAtIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("❌ Invalid index!");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }

        System.out.println("✅ Deleted successfully.");
        return newArr;
    }

    // 🔄 Rotate left by 1
    public static void rotateLeft(int[] arr) {
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    // 🔁 Count frequency
    public static void countFrequency(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " → " + count + " time(s)");
        }
    }

    // 🔂 Find duplicates
    public static void findDuplicates(int[] arr) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate: " + arr[i]);
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No duplicates found.");
    }
}
