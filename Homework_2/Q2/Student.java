package Homework_2.Q2;

public class Student extends Person {
    // Fields
    protected String major;

    // Constructor
    public Student(String name, int yearOfBirth, String major) {
        super(name, yearOfBirth);
        this.major = major;
    }

    // Getter for major
    public String getMajor() {
        return major;
    }

    // toString overriden
    public String toString() {
        return "Student\n" +
                "Name: " + this.name + "\n" +
                "Year Of Birth: " + this.yearOfBirth + "\n" +
                "Major: " + this.major + "\n";
    }
}
