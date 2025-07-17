package converters;

public class DistanceConverter {
    private static final double METER_TO_KM = 0.001;
    private static final double MILES_TO_KM = 1.60934;

    public static double convertMeterToKM(double meter) {
        return meter * METER_TO_KM;
    }

    public static double convertKMToMeter(double km) {
        return km / METER_TO_KM;
    }

    public static double convertMilesToKM(double miles) {
        return miles * MILES_TO_KM;
    }

    public static double convertKMToMiles(double km) {
        return km / MILES_TO_KM;
    }
}
