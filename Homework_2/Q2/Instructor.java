package Homework_2.Q2;

public class Instructor extends Person {
    // Fields
    protected double salary;

    // Constructor
    public Instructor(String name, int yearOfBirth, double salary) {
        super(name, yearOfBirth);
        this.salary = salary;
    }
    
    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // toString overriden
    public String toString() {
        return "Instructor\n" +
                "Name: " + this.name + "\n" +
                "Year Of Birth: " + this.yearOfBirth + "\n" +
                "Salary: " + this.salary + "\n";
    }
}
