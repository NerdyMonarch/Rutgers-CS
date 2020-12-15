package ATM_Project;

import java.util.HashMap;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class TransferMenu extends ScreenScene {

    private GridPane cardSelector;
    private Button insertCard;
    private Label cardMenuLabel;
    private String selected;
    private HashMap<String, Button> users;
    private Transfer transfer;
    private Client client;

    public TransferMenu(HashMap<String, BankAccount> accounts, Client client) {
        // Grid to seperate card list from selector
        cardSelector = new GridPane();
        this.client = client;

        // FlowPane layout for all credit cards
        FlowPane selectCardMenu = new FlowPane();
        selectCardMenu.setVgap(10);
        selectCardMenu.setHgap(10);
        selectCardMenu.setPadding(new Insets(15));
        selectCardMenu.setAlignment(Pos.CENTER);

        // Creates button for each card
        for (String cardKey : accounts.keySet()) {
            Button card = new Button(cardKey);
            card.setPrefWidth(100);
            card.setOnAction(this::cardSelected);
            selectCardMenu.getChildren().add(card);
        }

        // cardSelector.add(selectCardMenu, 0, 0);
        cardSelector.addRow(0, selectCardMenu);

        // Adds interface to select card
        VBox cardInserter = new VBox(5);
        cardInserter.setPadding(new Insets(15));
        cardInserter.setAlignment(Pos.CENTER);
        cardMenuLabel = new Label("Please Select Card");
        insertCard = new Button("Transfer");
        insertCard.setOnAction(this::readyTransfer);
        insertCard.setPrefWidth(100);
        insertCard.setDisable(true);
        cardInserter.getChildren().addAll(cardMenuLabel, insertCard);

        // For submittion
        cardSelector.addRow(1, cardInserter);

        transfer = new Transfer(accounts, client);
    }

    // Returns element
    public Control getElement(String s) {
        if(s.equals("Transfer")) {
            return insertCard;
        }
        else if(s.equals("Card Label")) {
            return cardMenuLabel;
        }
        else {
            for(String key: users.keySet()) {
                if(s.equals(key)) {
                    return users.get(key);
                }
            }
        }
        return null;
    }

    public void readyTransfer(Event e) {
        transfer.setToWho(selected);
        client.changeScreenState(transfer);
    }

    public String getSelected() {
        return selected;
    }

    public ScreenScene getTransfer() {
        return transfer;
    }

    public void cardSelected(Event e) {
        selected = ((Button) e.getSource()).getText();
        cardMenuLabel.setText(selected);
        insertCard.setDisable(false);
    }

    // Returns layout
    public Pane getLayout() {
        return cardSelector;
    }

    // Does not use keypad
    public String inputHandle(String input) {
        if(client.getCurrentScreen() == transfer) {
            transfer.inputHandle(input);
            return "false";
        }
        return "false";
    }
}
