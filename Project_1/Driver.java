package Project_1;

public class Driver {
    public static void main(String[] args) {
        // Array of Students and their Numbers
        int[][] randNums = Generator.studentNums(Generator.randNums(50));
        // Array of Students
        Student[] students = new Student[randNums.length];
        // Initializing Students with their Numbers and Printing out Results
        for(int i = 0; i < randNums.length; i++) {
            students[i] = new Student(randNums[i]);
            System.out.println("Student " + (i + 1) + ":\t" + students[i]);
        }
    }
}