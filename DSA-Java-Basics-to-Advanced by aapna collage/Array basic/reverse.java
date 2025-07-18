public class Array {
    public static void main(String[] args) {
        
        int[] arr ={10,20,30,40};
        int left = 0, right = arr.length-1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right]= temp;
            left ++;
            right --;
        }
        System.out.println("reversed aerray : ");
        for(int i: arr) System.out.print(i+ " ");
    }
}
