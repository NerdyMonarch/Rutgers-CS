package Extra_Greenfly;

import java.util.Scanner;

public class Greenfly {
    public static void main(String[] args) {
        // Obtains Input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter # of days: ");
        int days = input.nextInt();
        input.close();

        // Calculates Population
        int flies = 1;
        int rateOfChange = 8;
        int rateChanger = 0;
        for(int i = 1; i <= days; i++) {
            // Updates Rate Changer
            if((i - 1) % 7 == 0 && i > 1) {
                rateChanger += (int) Math.pow(8, ((i - 1) / 7) + 1);
            }
            // Flies are Updated
            rateOfChange += rateChanger;
            flies += rateOfChange;
            // Prints Results
            System.out.println("After " + i + " days there are " + flies + " flies.");
        }
    }
}