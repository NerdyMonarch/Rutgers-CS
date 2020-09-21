package Homework_1;

import java.util.ArrayList;

public class CashRegister_01 {

    private ArrayList<Double> prices;

    // Constructor
    public CashRegister_01() {
        prices = new ArrayList<Double>();
    }

    // Add item to cash register
    public void addItem(double price) {
        prices.add(price);
    }

    // Get total price for current sale
    public double getTotal() {
        double sum = 0;
        for(double price: prices) {
            sum += price;
        }
        return sum;
    }

    // Gets total number of items
    public int getCount() {
        return prices.size();
    }

    // Empties cash register
    public void clear() {
        prices.clear();
    }

    // Displays all items
    public void displayAll() {
        System.out.println(prices);
    }
}