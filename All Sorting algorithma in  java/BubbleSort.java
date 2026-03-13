//1.Bubble Sort

// Idea: Repeatedly swap adjacent elements if they are in the wrong order.

// Time Complexity

// Best: O(n)
// Average: O(n²)
// Worst: O(n²)

public class BubbleSort {

    public static void bubbleSort(int arr[]) {
        int n = arr.length;

        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {

                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 1, 4, 2, 8};

        bubbleSort(arr);

        System.out.println("Sorted Array:");

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}