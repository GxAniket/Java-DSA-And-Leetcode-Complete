package converters;

public class CurrencyConverter {
    private static final double DOLLAR_TO_INR = 82.5;
    private static final double EURO_TO_INR = 89.0;
    private static final double YEN_TO_INR = 0.61;

    public static double convertDollarToINR(double dollar) {
        return dollar * DOLLAR_TO_INR;
    }

    public static double convertINRToDollar(double inr) {
        return inr / DOLLAR_TO_INR;
    }

    public static double convertEuroToINR(double euro) {
        return euro * EURO_TO_INR;
    }

    public static double convertINRToEuro(double inr) {
        return inr / EURO_TO_INR;
    }

    public static double convertYenToINR(double yen) {
        return yen * YEN_TO_INR;
    }

    public static double convertINRToYen(double inr) {
        return inr / YEN_TO_INR;
    }
}
