import Exceptions.IllegalTimeFormatException;

public class Time {

    private int min;
    private int hour;

    public Time(int min, int hour) throws IllegalTimeFormatException {
        if ((min < 0 || min > 60) && (hour < 0 || hour > 24)) {
            throw new IllegalTimeFormatException("Mistake! Time must be between 0-60 for minutes and 0-24 for hours!");
        } else {
            //todo this.setMin(min);
            //     this.setHour(hour);
            this.min = min;
            this.hour = hour;
        }
    }

    public static Time endTime(Time startTime, Time duration) throws IllegalTimeFormatException {
        int min = startTime.getMin() + duration.getMin();
        int hour = startTime.getHour() + duration.getHour();

        if (min > 60) {
            hour++;
            min = 0;
        } else if (hour > 24) {
            hour = 1;
        }

        return new Time(min, hour);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
