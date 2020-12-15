package ATM_Project;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Summary extends ScreenScene {
    private HashMap<String, BankAccount> accounts;
    private Client client;
    private VBox layout;
    private Label[] labels;

    public Summary(HashMap<String, BankAccount> accounts, Client client) {
        this.accounts = accounts;
        this.client = client;
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        labels = new Label[4];
        for(int i = 0; i < 4; i++) {
            labels[i] = new Label();
        }
        layout.getChildren().addAll(labels);
    }

    @Override
    public Control getElement(String s) {
        // TODO Auto-generated method stub
        return null;
    }

    public void init() {
        String selected = client.getSelected();

        labels[0].setText("User: " + accounts.get(selected).getUserName());
        labels[1].setText("Card Number: " + accounts.get(selected).getCardNumber());
        labels[2].setText("Balance: $" + accounts.get(selected).getBalance() / 100);
        labels[3].setText("Pin Num: " + accounts.get(selected).getPin());
    }

    @Override
    public Pane getLayout() {
        // TODO Auto-generated method stub
        return layout;
    }

    @Override
	public String inputHandle(String input) {
		// TODO Auto-generated method stub
		return null;
    }
}
