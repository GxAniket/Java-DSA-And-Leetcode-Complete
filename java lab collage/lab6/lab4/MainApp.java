import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the stack:");
        int size = scanner.nextInt();

        Stack<Integer> stack = new ArrayStack<>(size);

        while (true) {
            System.out.println("\n--- Stack Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter an integer to push: ");
                        int value = scanner.nextInt();
                        stack.push(value);
                        System.out.println(value + " pushed to stack.");
                        break;
                    case 2:
                        int poppedValue = stack.pop();
                        System.out.println("Popped value: " + poppedValue);
                        break;
                    case 3:
                        int topValue = stack.peek();
                        System.out.println("Top value: " + topValue);
                        break;
                    case 4:
                        System.out.println("Is stack empty? " + stack.isEmpty());
                        break;
                    case 5:
                        System.out.println("Is stack full? " + stack.isFull());
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (StackOverflowException | StackUnderflowException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
