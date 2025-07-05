import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Employee ID:");
        String id = scanner.nextLine();

        System.out.println("Enter Employee Address:");
        String address = scanner.nextLine();

        System.out.println("Enter Employee Mail ID:");
        String mailId = scanner.nextLine();

        System.out.println("Enter Employee Mobile No:");
        String mobileNo = scanner.nextLine();

        System.out.println("Enter Basic Pay:");
        double basicPay = scanner.nextDouble();

        System.out.println("\nChoose Designation:\n1. Programmer\n2. Assistant Professor\n3. Associate Professor\n4. Professor");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> new Programmer(name, id, address, mailId, mobileNo, basicPay).generatePaySlip();
            case 2 -> new AssistantProfessor(name, id, address, mailId, mobileNo, basicPay).generatePaySlip();
            case 3 -> new AssociateProfessor(name, id, address, mailId, mobileNo, basicPay).generatePaySlip();
            case 4 -> new Professor(name, id, address, mailId, mobileNo, basicPay).generatePaySlip();
            default -> System.out.println("Invalid choice.");
        }

        System.out.println("\nProgrammer Name: Rajat Chauhan");
        System.out.println("Roll No. : 35");

        scanner.close();
    }
}
