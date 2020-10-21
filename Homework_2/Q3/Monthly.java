package Homework_2.Q3;

public class Monthly extends Appointment {
    // Constructor
    public Monthly(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    // Returns if it occurs on the day given
    public boolean occursOn(int year, int month, int day) {
        return this.day == day;
    }

    // toString overriden
    public String toString() {
        return this.description + " occurs every month on day " +
                this.day;
    }
}
