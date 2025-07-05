import java.util.ArrayList;
import java.util.Scanner;

public class StringOperations {
    private ArrayList<String> stringList;

    public StringOperations() {
        stringList = new ArrayList<>();
    }

    // a. Append - Add at end
    public void append(String str) {
        stringList.add(str);
        System.out.println("'" + str + "' added at the end.");
    }

    // b. Insert - Add at a particular index
    public void insert(int index, String str) {
        if (index >= 0 && index <= stringList.size()) {
            stringList.add(index, str);
            System.out.println("'" + str + "' added at index " + index + ".");
        } else {
            System.out.println("Invalid index! Please try again.");
        }
    }

    // c. Search for a string
    public void search(String str) {
        if (stringList.contains(str)) {
            System.out.println("'" + str + "' found at index " + stringList.indexOf(str) + ".");
        } else {
            System.out.println("'" + str + "' not found in the list.");
        }
    }

    // d. List all strings that start with a given letter
    public void listStartsWith(char letter) {
        System.out.println("Strings starting with '" + letter + "':");
        boolean found = false;
        for (String str : stringList) {
            if (str.toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
                System.out.println(str);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No strings found starting with '" + letter + "'.");
        }
    }

    // Display all strings
    public void displayAll() {
        System.out.println("Current List: " + stringList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringOperations operations = new StringOperations();

        while (true) {
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. Append (Add at end)");
            System.out.println("2. Insert (Add at particular index)");
            System.out.println("3. Search");
            System.out.println("4. List all strings that start with a given letter");
            System.out.println("5. Display all strings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Append
                    System.out.print("Enter string to append: ");
                    String appendStr = scanner.nextLine();
                    operations.append(appendStr);
                    break;
                case 2: // Insert
                    System.out.print("Enter index to insert at: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter string to insert: ");
                    String insertStr = scanner.nextLine();
                    operations.insert(index, insertStr);
                    break;
                case 3: // Search
                    System.out.print("Enter string to search: ");
                    String searchStr = scanner.nextLine();
                    operations.search(searchStr);
                    break;
                case 4: // List strings starting with a given letter
                    System.out.print("Enter the starting letter: ");
                    char letter = scanner.next().charAt(0);
                    operations.listStartsWith(letter);
                    break;
                case 5: // Display all strings
                    operations.displayAll();
                    break;
                case 6: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
