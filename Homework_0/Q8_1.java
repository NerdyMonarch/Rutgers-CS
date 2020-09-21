package Homework_0;

/**
 * Question:
 * Write a program that reads an arbitrary number of integers that are in 
 * the range 0 to 50 inclusive and counts how many occurrences of each
 * are entered. Indicate the end of the input by a value outside of the
 * range. After all inputs have been processed, print all of the values (with
 * the number of occurrences) that were entered one or more times.
 * Author: Nikhil Pandey
 * Date: September 11th, 2020
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Q8_1 {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(true) {
            int num = input.nextInt();
            if(num < 0 || num > 50) {
                // Stops inputting if input out of range
                break;
            }
            else {
                // Adds number to arraylist
                nums.add(num);
            }
        }
        // Closes scanner to avoid memory leak
        input.close();
        
        // Runs method with obtained arraylist
        count_repeats(nums);
    }

    public static void count_repeats(ArrayList<Integer> nums) {
        // No occurences if no nums are in arraylist
        if(nums.size() < 1) {
            return;
        }

        // Clones and sorts new arraylist
        ArrayList<Integer> n = new ArrayList<Integer>(nums);
        Collections.sort(n);

        // Sets up variables by reading first number in arraylist
        int index = 1;
        int current = n.get(0);
        int count = 1;

        // Loops through all numbers in arraylist
        while(index < n.size()) {
            // Current number that is being looked at
            int num = n.get(index);
            if(current == num) { 
                // If number is same as last, increases counter
                count++;
            }
            else { 
                // Prints out number and occurences and resets current and count
                System.out.println("The Number " + current + " had " + count + " occurrences!");
                current = num;
                count = 1;
            }
            // Updates index to look at next number
            index++;
        }
        
        // Prints last numbers total occurrence
        System.out.println("The Number " + current + " had " + count + " occurrences!");
    }
}