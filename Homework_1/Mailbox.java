package Homework_1;

import java.util.ArrayList;

public class Mailbox {
    
    // Fields
    private ArrayList<Message> msgs;

    // Constructor
    public Mailbox() {
        msgs = new ArrayList<Message>();
    }

    // Adds message
    public void addMessage(Message m) {
        msgs.add(m);
    }

    // Gets message
    public Message getMessage(int i) {
        return msgs.get(i);
    }

    // Removes message
    public void removeMessage(int i) {
        msgs.remove(i);
    }
}
