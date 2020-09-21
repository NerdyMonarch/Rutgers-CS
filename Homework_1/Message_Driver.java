package Homework_1;

public class Message_Driver {
    public static void main(String[] args) {
        Message msg = new Message("Nikhil Pandey", "Bob");
        msg.appendText("Greetings Bob,");
        msg.appendText("I just wanted to say hello man!");
        msg.appendText("");
        msg.appendText("Yours Truly,");
        msg.appendText("Nikhil Pandey");
        System.out.println(msg);
    }
}
