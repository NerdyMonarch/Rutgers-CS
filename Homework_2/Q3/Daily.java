package Homework_2.Q3;

public class Daily extends Appointment {
    // Constructor
    public Daily(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    // Returns if it occurs on the day given
    public boolean occursOn(int year, int month, int day) {
        return true;
    }

    // toString overriden
    public String toString() {
        return this.description + " occurs everyday!";
    }
}
