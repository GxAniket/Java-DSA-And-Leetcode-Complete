// 2. Selection Sort

// Idea: Find the minimum element and place it at the correct position.

// Time Complexity

// Best: O(n²)
// Average: O(n²)
// Worst: O(n²)




public class SelectionSort {

    public static void selectionSort(int arr[]) {

        int n = arr.length;

        for(int i = 0; i < n-1; i++) {

            int minIndex = i;

            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

    public static void main(String[] args) {

        int arr[] = {64, 25, 12, 22, 11};

        selectionSort(arr);

        System.out.println("Sorted Array:");

        for(int num : arr) {
            System.out.print(num + " ");
        }

    }
}