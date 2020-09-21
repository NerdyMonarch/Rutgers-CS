package Homework_0;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    // Holds all cards in deck
    private ArrayList<Card> deck;

    public DeckOfCards() {
        // Creates list to hold new deck
        this.deck = new ArrayList<Card>();
        // Array of suits are created to help deck creation
        Suit suits[] = {Suit.SPADES, Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS};
        
        // Creates and adds all cards into deck
        for(int i = 1; i <= 13; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, suits[j]));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card dealCard() {
        // Gets card from top of deck
        Card card = this.deck.get(0);
        // Removes card from deck
        this.deck.remove(0);
        // Prints what card it is
        System.out.println("The card is " + card);
        // Returns card
        return card;
    }

    public int cardsLeft() {
        System.out.println("There are " + this.deck.size() + " cards left!");
        return this.deck.size();
    }
}
