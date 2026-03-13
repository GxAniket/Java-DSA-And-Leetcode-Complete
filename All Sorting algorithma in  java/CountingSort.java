// 6. Counting Sort (Non-comparison)

// Used when numbers are small range

// Time Complexity

// O(n + k)

public class CountingSort {

    static void countingSort(int arr[]){

        int max = arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i] > max)
                max = arr[i];
        }

        int count[] = new int[max+1];

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        int index = 0;

        for(int i=0;i<count.length;i++){

            while(count[i] > 0){

                arr[index] = i;
                index++;
                count[i]--;

            }

        }

    }

    public static void main(String[] args) {

        int arr[] = {4,2,2,8,3,3,1};

        countingSort(arr);

        System.out.println("Sorted Array:");

        for(int num : arr)
            System.out.print(num+" ");

    }
}