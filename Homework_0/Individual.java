package Homework_0;

import java.util.ArrayList;

public class Individual {
    // Properties of individual
    private String firstName;
    private String lastName;
    private int postalCode;
    private ArrayList<String> additionalInfo;

    public Individual(String firstName, String lastName, int postalCode, ArrayList<String> additionalInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.additionalInfo = additionalInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public ArrayList<String> getAdditionalInfo() {
        return additionalInfo;
    }
}
