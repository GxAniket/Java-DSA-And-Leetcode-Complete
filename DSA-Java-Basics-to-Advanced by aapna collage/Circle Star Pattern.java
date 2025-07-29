public class CirclePattern {
    public static void main(String[] args) {
        int radius = 10; // Radius of the circle

        for (int i = 0; i <= 2 * radius; i++) {
            for (int j = 0; j <= 2 * radius; j++) {
                // Calculate distance from the center
                double distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));

                // Draw the border of the circle
                if (distance >= radius - 0.5 && distance <= radius + 0.5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Move to next line
        }
    }
}
