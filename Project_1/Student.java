package Project_1;

public class Student {
    // Fields
    private int[] nums;

    // Constructor
    public Student(int[] nums) {
        this.nums = nums;
    }

    // Overrides toString
    public String toString() {
        String results = "";
        for(int i: nums) {
            results += i + "\t";
        }
        return results;
    }
}