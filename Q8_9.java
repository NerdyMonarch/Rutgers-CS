/**
 * Write a program that reads a sequence of up to 25 pairs of names and postal
 * (ZIP) codes for individuals. Store the data in an object designed to store a
 * first name (string), last name (string), and postal code (integer). Assume
 * each line of input will contain two strings followed by an integer value,
 * each seperated by a tab character. Then, after the input has been read in,
 * print the list in an appropriate format to the screen.
 * 
 * Modify the program you create to accomplish the following: - Support the
 * storing of additional user information: street addresss (string), city
 * (string), state (string), and 10-digit phone number (long integer, contains
 * area code and does not include special characters such as '(', ')', or '-') -
 * Store the data in an ArrayList object Author: Nikhil Pandey Date: September
 * 12th, 2020
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q8_9 {
    public static void main(String[] args) {
        // Gets a list of all individuals
        ArrayList<Individual> individuals = getData();
        // Prints formatted data of individuals
        printData(individuals);
    }

    public static ArrayList<Individual> getData() {
        // List for all individuals found
        ArrayList<Individual> individuals = new ArrayList<Individual>();

        // For obtaining user data
        Scanner input = new Scanner(System.in);
        String data = "";
        System.out.println("FirstName LastName PostalCode");

        // Loops through all lines of data
        while(!data.equals("QUIT")) {
            // Each line contains one individuals data
            data = input.nextLine();

            // Gets individual info from line
            String firstName = data.substring(0, data.indexOf(" "));
            data = data.substring(data.indexOf(" ") + 1);
            String lastName = data.substring(0, data.indexOf(" "));
            data = data.substring(data.indexOf(" ") + 1);
            int postalCode = Integer.parseInt(data);

            // List obtains additional information
            ArrayList<String> moreInfo = new ArrayList<String>();
            System.out.println("Street Address");
            moreInfo.add(input.nextLine());
            System.out.println("City State");
            String line = input.nextLine();
            moreInfo.add(line.substring(0, line.lastIndexOf(" ")));
            moreInfo.add(line.substring(line.lastIndexOf(" ") + 1));

            // Gets phone number and formats it
            System.out.println("PhoneNumber");
            String phone = input.nextLine();
            phone = phone.replace("(", "");
            phone = phone.replace(")", "");
            phone = phone.replace("-", "");
            
            // Adds phone number to moreInfo
            moreInfo.add(phone);

            // Creates individual and adds to list
            individuals.add(new Individual(firstName, lastName, postalCode, moreInfo));

            // Options
            System.out.println("QUIT? Type QUIT to quit or Anything else to skip!");
            data = input.nextLine();
        }

        // Closes input to avoid memory leak
        input.close();

        // Returns list of individuals
        return individuals;
    }

    public static void printData(ArrayList<Individual> individuals) {
        System.out.println("Index\tFirst Name\t\tLast Name\t\tPostal Code\t\tAdditional Info");
        for(int i = 0; i < individuals.size(); i++) {
            Individual person = individuals.get(i);
            System.out.print(i + "\t" + person.getFirstName() + "\t\t\t");
            System.out.print(person.getLastName() + "\t\t\t");
            System.out.print(String.format("%05d", person.getPostalCode()) +"\t\t\t");
            System.out.print(person.getAdditionalInfo());
        }
    }
}
