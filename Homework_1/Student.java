package Homework_1;

public class Student {
    
    // Fields
    private String name;
    private double totalScore;
    private int totalQuizzes;

    // Constructor
    public Student(String name) {
        this.name = name;
        totalScore = 0;
        totalQuizzes = 0;
    }

    // Returns student's name
    public String getName() {
        return name;
    }

    //  Add a quiz score
    public void addQuiz(String grade) {
        totalScore += new Grade(grade).getNumGrade();
        totalQuizzes++;
    }

    // Returns total score
    public double getTotalScore() {
        return totalScore;
    }

    // Averages scores
    public double getGPA() {
        return ((double) totalScore) / totalQuizzes;
    } 
}
