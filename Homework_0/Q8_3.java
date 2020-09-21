package Homework_0;

/**
 * Question:
 * Write a program that creates a histogram that allows you to visually
 * inspect the frequency distribution of a set of values. The program
 * should read in an arbitrary number of integers from a text input file
 * that are in the range 1 to 100 inclusive; then produce a chart similar to
 * the one below that indicates how many input values fell in the range 1
 * to 10, 11, 20, and so on. Print one asterisk for each value entered.
 * 
 * 1 - 10    | *****
 * 11 - 20   | ***
 * 21 - 30   | ********
 * 31 - 40   | ****
 * 41 - 50   | **
 * 51 - 60   | *
 * 60 - 70   |
 * 71 - 80   | **
 * 81 - 90   | *
 * 91 - 100  | *****
 * 
 * Author: Nikhil Pandey
 * Date: September 11th, 2020
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q8_3 {
    public static void main(String[] args) {
        // Sends filepath to method
        get_nums("Q8_3.txt");
    }

    public static void get_nums(String path) {
        // Gets file that holds the numbers
        File f = new File(path);
        // Prepares scanner for try and catch
        Scanner input = null;
        try {
            // Tries to load file into scanner
            input = new Scanner(f);
        } catch(FileNotFoundException e) {
            // Throws error if file could not be loaded
            e.printStackTrace();
        }

        // Array that holds number of occurrences
        int[] count = new int[10];
        
        // Loops through all integers in file
        while(input.hasNextInt()) {
            // Gets integer
            int num = input.nextInt();
            // Uses (int) 0.1x + 0.1 to find the histogram group to update it
            count[(int)(num * 0.1 - 0.1)]++;
        }

        // Loops through each histogram group
        for(int i = 1; i < 100; i += 10) {
            // Prints out histogram label
            System.out.print("   " + i + "\t-   " + (i + 9) + "\t|");
            // Prints number of occurrences
            for(int j = 0; j < count[(i - 1) / 10]; j++) {
                System.out.print("*");
            }
            // Enters newline for next histogram group
            System.out.println();
        }
    }
}
