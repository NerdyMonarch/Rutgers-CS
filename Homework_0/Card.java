package Homework_0;

public class Card {
    // Properties of the card
    private int value;
    private Suit suit;

    // Constructor
    public Card(int value, Suit suit) {
        // Stores properties
        this.value = value;
        this.suit = suit;
    }

    // Prints this when object is printed
    public String toString() {
        String value = "";
        // Special cases for values
        switch(this.value) {
            case 1:
                value += "Ace";
                break;
            case 11:
                value += "Jack";
                break;
            case 12:
                value += "Queen";
                break;
            case 13:
                value += "King";
                break;
            default:
                value += this.value;
                break;
        }
        // Prints card like this
        return value + " of " + this.suit;
    }
}
