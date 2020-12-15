package ATM_Project;

import java.util.HashMap;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Withdraw extends ScreenScene {

    private VBox layout;
    private Label showInput;
    private Button takeMoney;
    private HashMap<String, BankAccount> accounts;
    private String userInput;
    private Client client;
    private String selected;
    private double amount;

    public Withdraw(HashMap<String, BankAccount> accounts, Client client) {
        this.client = client;

        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        showInput = new Label("Enter Amount");
        takeMoney = new Button("Take Money");
        takeMoney.setOnAction(this::returnToMenu);
        takeMoney.setVisible(false);
        layout.getChildren().addAll(showInput, takeMoney);
        this.accounts = accounts;
        this.userInput = "";
    }

    public Control getElement(String s) {
        return null;
    }

    public Pane getLayout() {
        return layout;
    }

    public String inputHandle(String input) {
        String key = input.substring(input.length() - 1);
        if(key.equals("*")) {
            selected = input.substring(0, input.length() - 1);
            amount = Double.parseDouble(userInput);
            if(((int) (amount * 100)) <= accounts.get(selected).getBalance()) {
                takeMoney.setVisible(true);
            }
            else {
                userInput = "";
                showInput.setText("Not Enough Funds!!!!");
            }
            return "false";
        }
        else if(key.equals("!")) {
            userInput = "";
            showInput.setText("Take Money");
            takeMoney.setVisible(false);
            return "false";
        }
        else if(!userInput.contains(".") || !key.equals(".")) {
            userInput += key;
            showInput.setText("$" + userInput);
            takeMoney.setVisible(false);
            return "false";
        }
        return "false";
    }

    public void returnToMenu(Event e) {
        accounts.get(selected).withdraw(amount);
        takeMoney.setVisible(false);
        showInput.setText("Enter Amount");
        userInput = "";
        client.toMenu();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
            System.out.println(d);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}