package ATM_Project;

import java.util.Random;

public class BankAccount {
    // Fields
    private String userName;
    private int[] cardNumber;
    private int pin;
    private String accountType;
    private int balance;

    // Constructor
    public BankAccount(String userName, int[] cardNumber, int pin, String accountType, int balance) {
        this.userName = userName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Secondary Constructor
    public BankAccount(String userName, int pin, String accountType) {
        this.userName = userName;
        this.cardNumber = new int[4];
        Random rand = new Random();
        for(int i = 0; i < 4; i++) {
            int num = 0;
            for(int j = 0; j < 4; j++) {
                num = (num * 10) + rand.nextInt(10);
            }
            cardNumber[i] = num;
        }
        this.accountType = accountType;
        this.balance = 0;
    }

    // Method to withdraw
    public boolean withdraw(double amt) {
        int withdraw = (int) (amt * 100);
        if(withdraw <= balance) {
            balance -= withdraw;
            return true;
        }
        return false;
    }

    // Method to deposit
    public boolean deposit(double amt) {
        int deposit = (int) amt * 100;
        balance += deposit;
        return true;
    }

    // Checks if pin is correct
    public boolean isValidPin(int pin) {
        return this.pin == pin;
    }

    // Getter for name
    public String getUserName() {
        return userName;
    }

    // Getter for card number
    public long getCardNumber() {
        long num = 0;
        for(int i = 0; i < cardNumber.length; i++) {
            num = (num * 10000) + cardNumber[i];
        }
        return num;
    }

    public int[] getCardArray() {
        return this.cardNumber;
    }

    // Getter for balance
    public int getBalance() {
        return balance;
    }

    // Getter for account type
    public String getAccountType() {
        return accountType;
    }

    // Getter for pin
    public int getPin() {
        return pin;
    }
}
