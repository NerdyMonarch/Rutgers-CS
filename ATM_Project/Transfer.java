package ATM_Project;

import java.util.HashMap;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Transfer extends ScreenScene {

    private VBox layout;
    private Label showInput;
    private Button insertMoney;
    private HashMap<String, BankAccount> accounts;
    private String userInput;
    private Client client;
    private String selected;
    private double amount;
    private String toWho;

    public Transfer(HashMap<String, BankAccount> accounts, Client client) {
        this.client = client;

        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        showInput = new Label("Enter Amount");
        insertMoney = new Button("Transfer");
        insertMoney.setOnAction(this::returnToMenu);
        insertMoney.setVisible(false);
        layout.getChildren().addAll(showInput, insertMoney);
        this.accounts = accounts;
        this.userInput = "";
    }

    public Control getElement(String s) {
        return null;
    }

    public Pane getLayout() {
        return layout;
    }

    public void setToWho(String s) {
        toWho = s;
    }

    public String inputHandle(String input) {
        String key = input.substring(input.length() - 1);
        if(key.equals("*")) {
            selected = input.substring(0, input.length() - 1);
            amount = Double.parseDouble(userInput);
            if(((int) (amount * 100)) <= accounts.get(selected).getBalance()) {
                insertMoney.setVisible(true);
            }
            else {
                userInput = "";
                showInput.setText("Not Enough Funds!!!!");
            }
            return "false";
        }
        else if(key.equals("!")) {
            userInput = "";
            showInput.setText("Enter Amount");
        }
        else if(!userInput.contains(".") || !key.equals(".")) {
            userInput += key;
            showInput.setText("$" + userInput);
            insertMoney.setVisible(false);
            return "false";
        }
        return "false";
    }

    public void returnToMenu(Event e) {
        accounts.get(selected).withdraw(amount);
        accounts.get(toWho).deposit(amount);
        insertMoney.setVisible(false);
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
