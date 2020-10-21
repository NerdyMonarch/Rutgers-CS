package Homework_2.Q1;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee john = new Employee("John", 40000);
        Manager bob = new Manager("Bob", 70000, "Research and Development");
        Executive charlie = new Executive("Charlie", 100000, "Finance");
        System.out.println(john);
        System.out.println(bob);
        System.out.println(charlie);
    }
}
