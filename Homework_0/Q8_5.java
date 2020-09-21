package Homework_0;

/**
 * Question: Write a program that computes and prints the mean and standard
 * deviation of a list of integers x_1 to x_n. Assume that there will be no more
 * than 50 input values. Compute both the mean and standard deviation as
 * floating point values. Author: Nikhil Pandey Date: September 11th, 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class Q8_5 {
    public static void main(String[] args) {
        // Generates random length for list
        Random rand = new Random();
        int len = rand.nextInt(25) + 1;
        
        // Generates a list of random numbers
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < len; i++) {
            nums.add(rand.nextInt(99));
        }

        // Prints out list of nums, its mean, and its standard deviation
        System.out.println("Nums: " + nums);
        System.out.println("Mean: " + mean(nums));
        System.out.println("Standard Deviation: " + sd(nums));
    }

    public static float mean(ArrayList<Integer> nums) {
        // Starts sum at 0
        int sum = 0;
        // Sums up all nums in list
        for(int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }

        // Returns mean using sum
        return ((float) sum) / nums.size();
    }

    public static float sd(ArrayList<Integer> nums) {
        // Gets mean
        float mean = mean(nums);
        float sum = 0;
        // Gets Summation of (x_i - mean) squared
        for(int i = 0; i < nums.size(); i++) {
            sum = (float) Math.pow((double) (nums.get(i) - mean), 2);
        }
        // Returns Standard Deviation
        return (float) Math.sqrt((double) sum);
    }
}
