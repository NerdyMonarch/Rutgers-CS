package Homework_2.Q3;

public class Onetime extends Appointment {
    // Constructor
    public Onetime(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    // Returns if it occurs on the day given
    public boolean occursOn(int year, int month, int day) {
        return this.year == year &&
                this.month == month &&
                this.day == day;
    }
}
