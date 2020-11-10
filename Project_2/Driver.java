package Project_2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Creates Scanner Object for Input
        Scanner input = new Scanner(System.in);

        // Obtains Number of Students
        System.out.print("Enter the number of students: ");
        int numOfStudents = input.nextInt();
        System.out.println();

        // Gets Grades for each Student
        Student[] students = new Student[numOfStudents];
        // Loops for Each Student
        for(int i = 1; i <= students.length; i++) {
            System.out.println("Enter the grade for Student " + i + ":");
            int[] grades = new int[Student.numOfGrades];
            // Loops for Each Grade
            for(int j = 1; j <= Student.numOfGrades; j++) {
                System.out.print("Grade " + j + ": ");
                grades[j - 1] = input.nextInt();
            }
            // Uses Data to Create Student
            students[i - 1] = new Student(grades);
            System.out.println();
        }
        // Closes Input to Avoid Memory Leak
        input.close();

        // Prints Data
        System.out.println(report(students));
    }

    public static String report(Student[] students) {
        // Creates Heading for Report
        String heading = "Student #\t";
        for(int i = 1; i <= Student.numOfGrades; i++) {
            heading += "Grade" + i + "\t";
        }
        heading += "Average\tWeighted\n\n";

        // Formats Grades for Each Student
        String report = "";
        for(int i = 1; i <= students.length; i++) {
            report += i + "\t\t" + students[i - 1] + "\n";
        }
        return heading + report;
    }
}