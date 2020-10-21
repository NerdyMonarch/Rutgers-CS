package Homework_2.Q3;

import java.util.Scanner;

public class AppointmentDriver {
    public static void main(String[] args) {
        // Mixture of appointments
        Appointment[] appointments = {
            new Daily("Sleep", 2020, 10, 20),
            new Daily("Go to School", 2020, 10, 20),
            new Monthly("Go to Dentist", 2020, 5, 13),
            new Onetime("Go to Amusement Park", 2020, 5, 1),
            new Onetime("Explore the Park", 2020, 10, 20),
            new Monthly("Study", 2020, 6, 20)
        };
        
        // For user input
        Scanner input = new Scanner(System.in);
        System.out.print("Year: ");
        int year = input.nextInt();
        System.out.print("Month: ");
        int month = input.nextInt();
        System.out.print("Day: ");
        int day = input.nextInt();
        input.close();

        // Prints all appointments that occur this day
        for(Appointment event: appointments) {
            if(event.occursOn(year, month, day)) {
                System.out.println(event);
            }
        }
    }
}
