public class CirclePattern {
    public static void main(String[] args) {
        int radius = 10;  // Radius of the circle

        // Loop through each row
        for (int i = 0; i <= 2 * radius; i++) {
            // Loop through each column
            for (int j = 0; j <= 2 * radius; j++) {
                // Calculate distance from center
                double distance = Math.sqrt((i - radius) * (i - radius) + (j - radius) * (j - radius));
                
                // Print star if distance is close to radius
                if (distance > radius - 0.5 && distance < radius + 0.5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Move to the next line
        }
    }
}
