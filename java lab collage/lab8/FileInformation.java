import java.io.File;
import java.util.Scanner;

public class FileInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the file name from the user
        System.out.print("Enter the file name (with path if not in current directory): ");
        String fileName = scanner.nextLine();

        // Create a File object
        File file = new File(fileName);

        // Display file information
        if (file.exists()) {
            System.out.println("File exists: Yes");
            System.out.println("Readable: " + (file.canRead() ? "Yes" : "No"));
            System.out.println("Writable: " + (file.canWrite() ? "Yes" : "No"));
            System.out.println("File Type: " + getFileExtension(file));
            System.out.println("Length: " + file.length() + " bytes");
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }

    // Helper method to get the file extension/type
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex > 0 && lastIndex < fileName.length() - 1) {
            return fileName.substring(lastIndex + 1);
        } else {
            return "Unknown";
        }
    }
}
