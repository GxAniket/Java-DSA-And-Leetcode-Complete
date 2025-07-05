import java.util.Random;

class NumberGenerator extends Thread {
    private SharedData sharedData;

    public NumberGenerator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int number = random.nextInt(100); // Generate random number between 0 and 99
            sharedData.setNumber(number);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("NumberGenerator interrupted");
            }
        }
    }
}

class SquareCalculator extends Thread {
    private SharedData sharedData;

    public SquareCalculator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            if (sharedData.isEven()) {
                int number = sharedData.getNumber();
                System.out.println("Square of " + number + " is " + (number * number));
                sharedData.reset(); // Reset the shared data
            }
        }
    }
}

class CubeCalculator extends Thread {
    private SharedData sharedData;

    public CubeCalculator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            if (!sharedData.isEven() && sharedData.getNumber() != -1) {
                int number = sharedData.getNumber();
                System.out.println("Cube of " + number + " is " + (number * number * number));
                sharedData.reset(); // Reset the shared data
            }
        }
    }
}

class SharedData {
    private int number = -1; // Initial invalid value

    public synchronized void setNumber(int number) {
        this.number = number;
    }

    public synchronized int getNumber() {
        return number;
    }

    public synchronized boolean isEven() {
        return number != -1 && number % 2 == 0;
    }

    public synchronized void reset() {
        number = -1;
    }
}

public class MultiThreadedApplication {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Create threads
        NumberGenerator numberGenerator = new NumberGenerator(sharedData);
        SquareCalculator squareCalculator = new SquareCalculator(sharedData);
        CubeCalculator cubeCalculator = new CubeCalculator(sharedData);

        // Start threads
        numberGenerator.start();
        squareCalculator.start();
        cubeCalculator.start();
    }
}


