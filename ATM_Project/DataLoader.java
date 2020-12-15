package ATM_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DataLoader {

    private static final String filePath = "bankdata.txt";
    private HashMap<String, BankAccount> accounts;

    public static void main(String[] args) {
        DataLoader data = new DataLoader();
        System.out.println(data.getAccounts().get("Nolan Reynolds").deposit(2));
        data.update();
    }

    public DataLoader() {
        this.accounts = loadAccounts();
        for(String name: accounts.keySet()) {
            System.out.println(accounts.get(name).getCardNumber());
        }
    }

    // Getter for accounts
    public HashMap<String, BankAccount> getAccounts() {
        return accounts;
    }
    
    private HashMap<String, BankAccount> loadAccounts() {
        // Hashmap to remove
        HashMap<String, BankAccount> accounts = new HashMap<String, BankAccount>();
        
        // Reads file
        Scanner reader = readFile(this.getClass().getResource(filePath).getPath());

        // Goes through every line in file
        while(reader.hasNextLine()) {
            // Gets name
            String userName = reader.nextLine();

            // Gets credit card
            int[] cardNumber = new int[4];
            Scanner temp = new Scanner(reader.nextLine());
            for(int i = 0; i < 4; i++) {
                cardNumber[i] = temp.nextInt();
            }

            // Gets remaining data fields
            int pin = Integer.parseInt(reader.nextLine());
            String accountType = reader.nextLine();
            int balance = Integer.parseInt(reader.nextLine());

            // Puts all into map
            accounts.put(userName, new BankAccount(userName, cardNumber, pin, accountType, balance));
        }
        
        // Avoid memory leak
        reader.close();

        // Returns all accounts in list
        return accounts;
    }

    private Scanner readFile(String path) {
        // Cursor for file reading (initialized to avoid compiler warning)
        Scanner reader = new Scanner(System.in);

        // Incase the file cannot be read
        try {
            // Tries opening the file and setting it to the reader
            File file = new File(path);
            reader = new Scanner(file);
        }
        catch(FileNotFoundException e) {
            // Throws error
            System.out.println("File Could Not Be Read!");
            e.printStackTrace();
        }

        // Returns the cursor
        return reader;
    }

    public void update(BankAccount account) {
        // Updates accounts field
        this.accounts.put(account.getUserName(), account);

        // Updates database
        update(this.accounts);
    }

    public void update() {
        // Updates database
        update(this.accounts);
    }

    private void update(HashMap<String, BankAccount> accounts) {
        try {
            // Writer for bank data
            String path = this.getClass().getResource(filePath).getPath();
            System.out.println(path);
            FileWriter myWriter = new FileWriter(path);

            // Loops through all accounts
            String fileData = "";
            for(String key: accounts.keySet()) {
                // Gets users bank account
                BankAccount act = accounts.get(key);

                // New line for new accounts
                if(fileData.length() > 0) {
                    fileData += "\n";
                }

                // Enters account name
                fileData += act.getUserName() + "\n";

                // Enters credit card which is formatted properly
                int[] card = act.getCardArray();
                String cardNum = "";
                for(int i = 0; i < card.length; i++) {
                    // Converts credit card to string
                    String num = Integer.toString(card[i]);

                    // Adds any missing zeros in numbers
                    while(num.length() < 4) {
                        num += "0";
                    }

                    // Space between each part
                    cardNum += num + " ";
                }

                // Enters and ignores last space
                fileData += cardNum.substring(0, cardNum.length() - 1) + "\n";

                // Enters remaining data
                fileData += act.getPin() + "\n";
                fileData += act.getAccountType() + "\n";
                fileData += act.getBalance();
            }

            // Writes all the data into file
            myWriter.write(fileData);

            // Closes file to avoid memory leak
            myWriter.close();

            System.out.println("FILE WRITTEN");
            System.out.println(fileData);
        } 
        catch (IOException e) {
            System.out.println("File Could Not Be Written To!");
            e.printStackTrace();
        }
    }
}
