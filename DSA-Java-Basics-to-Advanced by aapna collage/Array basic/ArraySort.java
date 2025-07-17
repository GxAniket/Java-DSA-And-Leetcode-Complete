import java.util.Arrays;

public class ArraySort{
    public static void main (String[]args){
        int[]arr={10,52,30,40};
        System.out.println("Original list :");
        for(int i: arr) System.out.print(i+ " ");
        System.out.println();
        Arrays.sort(arr);
        System.out.println("Sorted listed are :");
        for(int i: arr) System.out.print(i+ " ");
    }
}

