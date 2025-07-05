import converters.CurrencyConverter;
import converters.DistanceConverter;
import converters.TimeConverter;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Converter Application ===");
            System.out.println("1. Currency Converter");
            System.out.println("2. Distance Converter");
            System.out.println("3. Time Converter");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Currency Converter:");
                    System.out.println("1. Dollar to INR");
                    System.out.println("2. INR to Dollar");
                    System.out.println("3. Euro to INR");
                    System.out.println("4. INR to Euro");
                    System.out.println("5. Yen to INR");
                    System.out.println("6. INR to Yen");
                    System.out.print("Enter your option: ");
                    int currencyChoice = scanner.nextInt();
                    System.out.print("Enter the amount: ");
                    double amount = scanner.nextDouble();

                    switch (currencyChoice) {
                        case 1 -> System.out.println("Result: " + CurrencyConverter.convertDollarToINR(amount) + " INR");
                        case 2 -> System.out.println("Result: " + CurrencyConverter.convertINRToDollar(amount) + " USD");
                        case 3 -> System.out.println("Result: " + CurrencyConverter.convertEuroToINR(amount) + " INR");
                        case 4 -> System.out.println("Result: " + CurrencyConverter.convertINRToEuro(amount) + " EUR");
                        case 5 -> System.out.println("Result: " + CurrencyConverter.convertYenToINR(amount) + " INR");
                        case 6 -> System.out.println("Result: " + CurrencyConverter.convertINRToYen(amount) + " YEN");
                        default -> System.out.println("Invalid option.");
                    }
                    break;

                case 2:
                    System.out.println("Distance Converter:");
                    System.out.println("1. Meter to KM");
                    System.out.println("2. KM to Meter");
                    System.out.println("3. Miles to KM");
                    System.out.println("4. KM to Miles");
                    System.out.print("Enter your option: ");
                    int distanceChoice = scanner.nextInt();
                    System.out.print("Enter the distance: ");
                    double distance = scanner.nextDouble();

                    switch (distanceChoice) {
                        case 1 -> System.out.println("Result: " + DistanceConverter.convertMeterToKM(distance) + " KM");
                        case 2 -> System.out.println("Result: " + DistanceConverter.convertKMToMeter(distance) + " Meter");
                        case 3 -> System.out.println("Result: " + DistanceConverter.convertMilesToKM(distance) + " KM");
                        case 4 -> System.out.println("Result: " + DistanceConverter.convertKMToMiles(distance) + " Miles");
                        default -> System.out.println("Invalid option.");
                    }
                    break;

                case 3:
                    System.out.println("Time Converter:");
                    System.out.println("1. Hours to Minutes");
                    System.out.println("2. Hours to Seconds");
                    System.out.println("3. Minutes to Hours");
                    System.out.println("4. Seconds to Hours");
                    System.out.print("Enter your option: ");
                    int timeChoice = scanner.nextInt();
                    System.out.print("Enter the time: ");
                    int time = scanner.nextInt();

                    switch (timeChoice) {
                        case 1 -> System.out.println("Result: " + TimeConverter.convertHoursToMinutes(time) + " Minutes");
                        case 2 -> System.out.println("Result: " + TimeConverter.convertHoursToSeconds(time) + " Seconds");
                        case 3 -> System.out.println("Result: " + TimeConverter.convertMinutesToHours(time) + " Hours");
                        case 4 -> System.out.println("Result: " + TimeConverter.convertSecondsToHours(time) + " Hours");
                        default -> System.out.println("Invalid option.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
