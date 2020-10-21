package Homework_2.Q2;

public class PersonDriver {
    public static void main(String[] args) {
        Person john = new Person("John", 2000);
        Student bob = new Student("Bob", 2002, "Mathematics");
        Instructor charlie = new Instructor("Charlie", 1978, 95000);
        System.out.println(john);
        System.out.println(bob);
        System.out.println(charlie);
    }   
}
