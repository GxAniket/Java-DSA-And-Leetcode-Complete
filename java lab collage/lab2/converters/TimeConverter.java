package converters;

public class TimeConverter {
    public static int convertHoursToMinutes(int hours) {
        return hours * 60;
    }

    public static int convertHoursToSeconds(int hours) {
        return hours * 3600;
    }

    public static double convertMinutesToHours(int minutes) {
        return minutes / 60.0;
    }

    public static double convertSecondsToHours(int seconds) {
        return seconds / 3600.0;
    }
}
