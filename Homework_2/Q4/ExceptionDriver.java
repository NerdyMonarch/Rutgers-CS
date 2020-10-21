package Homework_2.Q4;

public class ExceptionDriver {
    public static void main(String[] args) throws InvalidDocumentCodeException {
        String[] documents = {
            "UA",
            "UT",
            "PQ",
            "CT",
            "ON",
            "PP",
            "CC"
        };

        for(String designation: documents) {
            char prefix = designation.charAt(0);
            if(prefix != 'U' && prefix != 'C' && prefix != 'P') {
                throw new InvalidDocumentCodeException(designation + " Not Valid Designation!");
            }
        }
    }
}
