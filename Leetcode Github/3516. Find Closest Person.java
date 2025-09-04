public class Main {
    public static int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z); // distance of person 1
        int d2 = Math.abs(y - z); // distance of person 2

        if (d1 == d2) {
            return 0; // tie
        }
        return d1 < d2 ? 1 : 2; // closer person wins
    }

    public static void main(String[] args) {
        // Example test cases
        System.out.println(findClosest(2, 5, 4)); // Output: 2
        System.out.println(findClosest(3, 6, 4)); // Output: 1
        System.out.println(findClosest(1, 7, 4)); // Output: 0
    }
}
