package Homework_2.Q5;

public class Savings extends BankAccount {
    // Constructor
    public Savings(String accountName, double balance) {
        super(accountName, "Savings", balance);
        this.interestEarned = 1.5;
        if(endingBalance < 100000) {
            serviceCharge = 15;
        }
    }
    
    // Override Withdrawal
    public boolean withdraw(double amount) {
        if(super.withdraw(amount)) {
            if(endingBalance < 100000) {
                serviceCharge = 15;
            }
            return true;
        }
        return false;
    }

    // Override Non Member Withdrawal
    public boolean nonMemberWithdrawal(double amount) {
        if(super.nonMemberWithdrawal(amount)) {
            if(endingBalance < 100000) {
                serviceCharge = 15;
            }
            return true;
        }
        return false;
    }

    // Override Deposit
    public boolean deposit(double amount) {
        if(super.deposit(amount)) {
            if(endingBalance >= 100000) {
                serviceCharge = 0;
            }
            return true;
        }
        return false;
    }

    // Override Non Member Deposit
    public boolean nonMemberDeposit(double amount) {
        if(super.nonMemberDeposit(amount)) {
            if(endingBalance >= 100000) {
                serviceCharge = 0;
            }
            return true;
        }
        return false;
    }
}
