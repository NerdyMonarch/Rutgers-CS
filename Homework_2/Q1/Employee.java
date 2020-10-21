package Homework_2.Q1;

public class Employee {
    // Fields
    protected String name;
    protected double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Salary
    public double getSalary() {
        return salary;
    }

    // toString overridden
    public String toString() {
        return "Employee\n" +
                "Name: " + this.name + "\n" +
                "Salary: " + this.salary + "\n";
    }
}
