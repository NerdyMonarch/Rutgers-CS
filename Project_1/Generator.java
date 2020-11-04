package Project_1;

import java.util.*;

public class Generator {
    // Generates a list of Unique Random Numbers
    public static int[] randNums(int amt) {
        // Sets up for Getting list of Random Integers
        Random rand = new Random();
        HashSet<Integer> set = new HashSet<Integer>();
        // Gets a Unique list of integers
        while(set.size() < amt) {
            set.add(rand.nextInt(99));
        }
        // Converting Set to List to Shuffling to Int Array
        return integerToint(shuffleList(setToList(set)));
    }

    // Shuffles List
    public static ArrayList<Integer> shuffleList(ArrayList<Integer> list) {
        Collections.shuffle(list);
        return list;
    }
    // Converts HashSet to Int Array
    public static ArrayList<Integer> setToList(HashSet<Integer> set) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < 99; i++) {
            if(set.contains(i)) {
                nums.add(i);
            }
        }
        return nums;
    }

    // Converts an ArrayList to Int Array
    public static int[] integerToint(ArrayList<Integer> list) {
        int[] nums = new int[list.size()];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static int[][] studentNums(int[] nums) {
        if(nums.length % 5 == 0) {
            int[][] res = new int[nums.length / 5][5];
            for(int i = 0; i < nums.length / 5; i++) {
                for(int j = 0; j < 5; j++) {
                    res[i][j] = nums[5 * i + j];
                }
            }
            return res;
        }
        return new int[0][0];
    }
}
