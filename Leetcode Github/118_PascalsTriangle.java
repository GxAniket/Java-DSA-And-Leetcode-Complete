import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5; // You can change this
        List<List<Integer>> triangle = generate(numRows);

        // Print the triangle
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First or last element in row is always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Inner value = sum of 2 values above
                    int aboveLeft = triangle.get(i - 1).get(j - 1);
                    int aboveRight = triangle.get(i - 1).get(j);
                    row.add(aboveLeft + aboveRight);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
