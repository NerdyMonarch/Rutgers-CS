package Homework_2.Q1;

public class Manager extends Employee {
    // Fields
    protected String department;

    // Constructor
    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // toString overridden
    public String toString() {
        return "Manager\n" +
                "Name: " + this.name + "\n" +
                "Department: " + this.department + "\n" +
                "Salary: " + this.salary + "\n";
    }
}
