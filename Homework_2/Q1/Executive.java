package Homework_2.Q1;

public class Executive extends Manager {
    // Constructor
    public Executive(String name, double salary, String department) {
        super(name, salary, department);
    }

    // toString overridden
    public String toString() {
        return "Executive Manager\n" +
                "Name: " + this.name + "\n" +
                "Department: " + this.department + "\n" +
                "Salary: " + this.salary + "\n";
    }
}
