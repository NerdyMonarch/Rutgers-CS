package ATM_Project;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PinEnter extends ScreenScene {

    private VBox layout;
    private Label showInput;
    private HashMap<String, BankAccount> accounts;
    private String userPin;

    public PinEnter(HashMap<String, BankAccount> accounts) {
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        showInput = new Label("Enter Pin");
        layout.getChildren().add(showInput);
        this.accounts = accounts;
        this.userPin = "";
    }

    public Control getElement(String s) {
        return null;
    }

    public Pane getLayout() {
        return layout;
    }

    public String inputHandle(String input) {
        if(input.charAt(input.length() - 1) == '*') {
            String user = input.substring(0, input.length() - 1);
            if(isNumeric(userPin) && accounts.get(user).isValidPin(Integer.parseInt(userPin))) {
                userPin = "";
                showInput.setText("Enter Pin");
                return "true";
            }
            else {
                userPin = "";
                showInput.setText("Invalid Pin! Correct Pin is " + accounts.get(user).getPin());
                return "false";
            }
        }
        else if(input.charAt(input.length() - 1) == '!') {
            userPin = "";
            showInput.setText("Enter Pin");
            return "false";
        }
        else {
            userPin += input.charAt(input.length() - 1);
            if(showInput.getText().equals("Enter Pin")) {
                showInput.setText("*");
            }
            else if(showInput.getText().charAt(0) == 'I') {
                showInput.setText("*");
            }
            else {
                showInput.setText(showInput.getText() + "*");
            }
            return "false";
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
