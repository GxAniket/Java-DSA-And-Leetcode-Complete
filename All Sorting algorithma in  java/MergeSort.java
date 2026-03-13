// 4. Merge Sort (Divide & Conquer)

// Idea:
// Divide the array → sort both halves → merge them.

// Time Complexity

// Best: O(n log n)
// Average: O(n log n)
// Worst: O(n log n)

public class MergeSort {

    static void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;i++)
            L[i] = arr[l+i];

        for(int j=0;j<n2;j++)
            R[j] = arr[m+1+j];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2){

            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while(i<n1){
            arr[k++] = L[i++];
        }

        while(j<n2){
            arr[k++] = R[j++];
        }

    }

    static void mergeSort(int arr[], int l, int r){

        if(l < r){

            int m = (l+r)/2;

            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr,l,m,r);
        }

    }

    public static void main(String[] args) {

        int arr[] = {38,27,43,3,9,82,10};

        mergeSort(arr,0,arr.length-1);

        System.out.println("Sorted Array:");

        for(int num : arr)
            System.out.print(num+" ");

    }
}