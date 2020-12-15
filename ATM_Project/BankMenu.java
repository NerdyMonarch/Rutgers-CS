package ATM_Project;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class BankMenu extends ScreenScene {

    private FlowPane layout;
    private Button deposit;
    private Button withdraw;
    private Button transfer;
    private Button info;
    private Client client;

    public BankMenu(Client client) {
        this.client = client;
        deposit = new Button("Deposit");
        deposit.setPrefWidth(100);
        deposit.setOnAction(this::toDeposit);
        withdraw = new Button("Withdraw");
        withdraw.setOnAction(this::toWithdraw);
        withdraw.setPrefWidth(100);
        transfer = new Button("Transfer");
        transfer.setOnAction(this::toTransfer);
        transfer.setPrefWidth(100);
        info = new Button("Summary");
        info.setPrefWidth(100);
        info.setOnAction(this::toSummary);

        layout = new FlowPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(20);
        layout.setHgap(30);
        layout.getChildren().addAll(deposit, withdraw, transfer, info);
    }

	@Override
	public Control getElement(String s) {
        if(s.equals("Deposit")) {
            return deposit;
        }
        else if(s.equals("Withdraw")) {
            return withdraw;
        }
        else if(s.equals("Transfer")) {
            return transfer;
        }
        else if(s.equals("Info")) {
            return info;
        }
        else {
            return null;
        }
	}

	@Override
	public Pane getLayout() {
        return layout;
	}

	@Override
	public String inputHandle(String input) {
		return null;
    }
    
    public void toDeposit(Event e) {
        client.toDeposit();
    }

    public void toWithdraw(Event e) {
        client.toWithdraw();
    }

    public void toTransfer(Event e) {
        client.toTransfer();
    }

    public void toSummary(Event e) {
        ((Summary) client.getSummary()).init();
        client.toSummary();
    }
    
}
