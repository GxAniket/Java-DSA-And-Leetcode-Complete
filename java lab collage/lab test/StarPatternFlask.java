public class StarPatternFlask {
    public static void main(String[] args) {
        int radius = 10; // Radius of the circular part
        int width = 2 * radius; // Width of the circle
        int neckHeight = 6; // Height of the flask neck
        int neckWidth = 6;  // Width of the flask neck
        int mid = width / 2;

        // Print the flask neck (rectangular center part)
        for (int i = 0; i < neckHeight; i++) {
            for (int j = 0; j < width; j++) {
                if (j >= mid - neckWidth / 2 && j <= mid + neckWidth / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Print the round bottom (full-circle shape)
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                double distance = Math.sqrt(i * i + j * j);
                if (distance < radius) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
