package Homework_2.Q3;

public abstract class Appointment {
    // Fields
    protected String description;
    protected int year;
    protected int month;
    protected int day;

    // Constructor
    public Appointment(String description, int year, int month, int day) {
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Abstract Method
    public abstract boolean occursOn(int year, int month, int day);

    // toString overriden
    public String toString() {
        return this.description + " occurs on " +
                this.month + "/" + this.day + "/" + this.year;
    }
}
