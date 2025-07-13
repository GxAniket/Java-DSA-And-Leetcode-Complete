import java.util.*;

public class function {
    public static void printMyName(String name) {
        System.out.println("Name: " + name);
        return;  // ✅ Explicit return for clarity
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        printMyName(name);
        sc.close();

    }
}
