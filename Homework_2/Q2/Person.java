package Homework_2.Q2;

public class Person {
    // Fields
    protected String name;
    protected int yearOfBirth;

    // Constructor
    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for yearOfBirth
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    // toString overriden
    public String toString() {
        return "Person\n" +
                "Name: " + this.name + "\n" +
                "Year Of Birth: " + this.yearOfBirth + "\n";
    }
}
