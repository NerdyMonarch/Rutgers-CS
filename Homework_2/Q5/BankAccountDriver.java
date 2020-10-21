package Homework_2.Q5;

public class BankAccountDriver {
    public static void main(String[] args) {
        Checking john = new Checking("John", 500);
        Savings bob = new Savings("Bob", 1500);
        Savings charlie = new Savings("Charlie", 400);
        System.out.println(john);
        System.out.println(bob);
        System.out.println(charlie);
        charlie.deposit(15);
        bob.withdraw(100);
        john.withdraw(600);
        john.nonMemberDeposit(5);
        System.out.println();
        System.out.println(john);
        System.out.println(bob);
        System.out.println(charlie);
    }
}
