package Homework_1;

public class Grade {

    // Fields
    private String alphaGrade;
    private double numGrade;

    // Constructor
    public Grade(String alphaGrade) {
        this.alphaGrade = alphaGrade;
        numGrade = alphaToNum(alphaGrade);
    }

    private static double alphaToNum(String alphaGrade) {
        char letter = alphaGrade.toUpperCase().charAt(0);
        double num = 'E' - letter;
        if(alphaGrade.length() > 1) {
            letter = alphaGrade.charAt(1);
            if(letter == '+') {
                num += 0.3;
            }
            else if(letter == '-') {
                num -= 0.3;
            }
        }
        return Math.max(Math.min(4.0, num), 0.0);
    }

    public String getAlphaGrade() {
        return alphaGrade;
    }

    public double getNumGrade() {
        return numGrade;
    }
}
