import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericMaxValue {

    // Generic function to find the maximum value
    public static <T extends Comparable<T>> T findMax(T[] elements) {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        T max = elements[0];
        for (T element : elements) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Example with Integer
        Integer[] intArray = {10, 20, 30, 5, 15};
        System.out.println("Max value (Integer): " + findMax(intArray));

        // Example with Double
        Double[] doubleArray = {2.5, 3.7, 1.8, 4.9};
        System.out.println("Max value (Double): " + findMax(doubleArray));

        // Example with String
        String[] stringArray = {"apple", "orange", "banana", "grape"};
        System.out.println("Max value (String): " + findMax(stringArray));
    }
}
