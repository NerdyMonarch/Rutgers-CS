package Homework_1;

public class CashRegister_02 {

    private int itemCount;
    private int totalPrice;
    private int salesCount;
    private int salesTotal;

    // Constructor
    public CashRegister_02() {
        itemCount = 0;
        totalPrice = 0;
        salesCount = 0;
        salesTotal = 0;
    }

    // Add item to cash register
    public void addItem(double price) {
        itemCount++;
        salesCount++;
        price = (int) (price * 100);
        totalPrice += price;
        salesTotal += price;
    }

    // Get total price for current sale
    public double getTotal() {
        return ((double) totalPrice) / 100;
    }

    // Gets total number of items
    public int getCount() {
        return itemCount;
    }

    // Gets total number of sales
    public int getSalesCount() {
        return salesCount;
    }

    // Get total amount made from sales
    public double getSalesTotal() {
        return ((double) salesTotal) / 100;
    }

    // Empties cash register
    public void clear() {
        itemCount = 0;
        totalPrice = 0;
    }
    
    // Resets sales
    public void resetSales() {
        salesCount = 0;
        salesTotal = 0;
    }
    
}