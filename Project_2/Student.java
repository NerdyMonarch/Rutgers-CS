package Project_2;

public class Student {
    // Field
    private int[] grades;
    private static double[] weights = {0.2, 0.3, 0.3, 0.2};
    public static final int numOfGrades = 4;

    // Constructor
    public Student(int[] grades) {
        this.grades = grades;
    }

    // Obtains Average
    public double average() {
        int sum = 0;
        for(int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return ((double) sum) / grades.length;
    }

    // Obtains Weighted Average
    public double weighted() {
        double sum = 0;
        for(int i = 0; i < grades.length; i++) {
            sum += grades[i] * weights[i];
        }
        return sum;
    }

    // ToString to Make Printing Grades Easier
    public String toString() {
        String report = "";
        for(int i = 0; i < grades.length; i++) {
            report += grades[i] + "\t";
        }
        report += String.format("%.2f", average()) + "\t";
        report += String.format("%.1f", weighted());
        return report;
    }
}
