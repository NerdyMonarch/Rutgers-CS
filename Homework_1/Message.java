package Homework_1;

public class Message {
    
    // Fields
    private String recipient;
    private String sender;
    private String text;

    public Message(String recipient, String sender) {
        this.recipient = recipient;
        this.sender = sender;
        text = "";
    }

    public void appendText(String text) {
        this.text += text + "\n";
    }

    public String toString() {
        String header = "From: " + sender + "\n";
        header += "To: " + recipient + "\n\n";
        return header + text;
    }
}
