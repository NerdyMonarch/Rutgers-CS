package Homework_2.Q5;

import java.util.Random;

public abstract class BankAccount {
    // Fields
    protected String accountName;
    protected int accountNumber;
    protected int startingBalance;
    protected int numOfTransactions;
    protected int totalDebit;
    protected double interestEarned;
    protected int accountAddress;
    protected String accountType;
    protected int endingBalance;
    protected int serviceCharge;
    protected int totalCredit;

    // Constructor
    public BankAccount(String accountName, String accountType, double balance) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.startingBalance = (int) (balance * 100);
        this.endingBalance = this.startingBalance;

        Random rand = new Random();
        this.accountNumber = (int) (rand.nextDouble()  * 100000000);
        this.accountAddress = (int) (rand.nextDouble()  * 1000000);

        this.totalDebit = 0;
        this.numOfTransactions = 0;
        this.interestEarned = 0;
        this.serviceCharge = 0;
        this.totalCredit = 0;
    }

    // Method for basic withdrawal
    public boolean withdraw(double amount) {
        int withdraw = (int) amount * 100;
        if(withdraw <= endingBalance) {
            endingBalance -= withdraw;
            System.out.println("Withdrawn $" + amount + " Successfully!");
            this.numOfTransactions++;
            return true;
        }
        else {
            System.out.println("Not Enough Funds Avaliable for Withdrawal!");
            return false;
        }
    }

    // Method for basic non-member withdrawal
    public boolean nonMemberWithdrawal(double amount) {
        if(((int) amount * 100) + 4 <= endingBalance) {
            withdraw(amount + 4);
            System.out.println("Service Charge of $4.00 for using Non-Member ATM!");
            return true;
        }
        else {
            System.out.println("Not Enough Funds Avaliable for Withdrawal!");
            return false;
        }
    }

    // Method for basic deposit
    public boolean deposit(double amount) {
        int deposit = (int) amount * 100;
        endingBalance += deposit;
        System.out.println("Deposited $" + amount + " Successfully!");
        this.numOfTransactions++;
        return true;
    }

    // Method for basic non-member withdrawal
    public boolean nonMemberDeposit(double amount) {
        if(4 <= endingBalance) {
            deposit(amount - 4);
            System.out.println("Service Charge of $4.00 for using Non-Member ATM!");
            return true;
        }
        else {
            System.out.println("Not Enough Funds Avaliable for Service Charge!");
            return false;
        }
    }

    // Resets for new month
    public void reset() {
        numOfTransactions = 0;
        endingBalance -= serviceCharge;
        startingBalance = endingBalance;
    }

    // toString overridden
    public String toString() {
        String report = "";
        report += "Account Name: " + this.accountName + "\n";
        report += "Account Number: " + this.accountNumber + "\n";
        report += "Starting Balance: $" + this.startingBalance / 100.0 + "\n";
        report += "Number of Transactions: " + this.numOfTransactions + "\n";
        report += "Total Debit: $" + this.totalDebit / 100.0 + "\n";
        report += "Interest Earned: " + this.interestEarned + "%\n";
        report += "Account Address: " + this.accountAddress + "\n";
        report += "Account Type: " + this.accountType + "\n";
        report += "Ending Balance: $" + this.endingBalance / 100.0 + "\n";
        report += "Service Charge: $" + this.serviceCharge + "\n";
        report += "Total Credit: $" + this.totalCredit / 100.0 + "\n";
        return report;

    }
}
