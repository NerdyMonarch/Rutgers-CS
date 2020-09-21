package Homework_0;

/**
 * Question:
 * Create a Card class that represents a playing card with a face
 * value and a suit. Then create a class called DeckOfCards that
 * stores 52 objects of the Card class. Include methods to shuffle
 * the deck, deal a card, and report the number of cards left in the 
 * deck. The shuffle method should assume a full deck. Create 
 * a driver class with a main method that deals each card from a
 * shuffled deck, printing each card as it is dealt.
 * Author: Nikhil Pandey
 * Date: September 12th, 2020
 */
public class Q8_7 {
    public static void main(String[] args) {
        // Gets a new deck of cards
        DeckOfCards deck = new DeckOfCards();
        // Shuffles cards
        deck.shuffleDeck();
        // Deals all cards
        for(int i = 0; i < 52; i++) {
            deck.dealCard();
        }
    }
}
