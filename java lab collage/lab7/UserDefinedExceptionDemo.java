// User-defined exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Main class
public class UserDefinedExceptionDemo {
    // Method to check age
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote.");
        } else {
            System.out.println("Age is valid. You are eligible to vote.");
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] testAges = {5, 10, 12, 30};

        for (int age : testAges) {
            try {
                System.out.println("Checking age: " + age);
                checkAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
