package Homework_2.Q4;

public class InvalidDocumentCodeException extends Exception {
    // Serializes this class
    private static final long serialVersionUID = 1L;

    // Constructor
    public InvalidDocumentCodeException(String message) {
        super(message);
    }
}
