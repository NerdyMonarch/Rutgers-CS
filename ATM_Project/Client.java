package ATM_Project;

import java.util.HashMap;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Client extends Application implements Runnable {

    private GridPane root;
    private GridPane screen;
    private Button[][] keyButtons;
    private Button[] leftButtons;
    private Button[] rightButtons;

    private String userInput = "";

    private DataLoader loader;
    private HashMap<String, BankAccount> accounts;

    private ScreenScene currentScreen;
    private CardSelector cardSelector;
    private PinEnter pinEnter;
    private BankMenu bankMenu;
    private Deposit deposit;
    private Withdraw withdraw;
    private TransferMenu transferMenu;
    private Summary summary;

    public void run() {
        launch();
    }

    public void start(Stage primaryStage) {

        /* ---------------------- BANK ACCOUNTS ---------------------- */

        // Loads bank accounts
        loader = new DataLoader();
        accounts = loader.getAccounts();

        /* ---------------------- ROOT ---------------------- */

        // Main layout organizing other components
        root = new GridPane();
        root.setPrefSize(500, 500);
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Column sizing and alignment rules
        ColumnConstraints[] rootCol = new ColumnConstraints[3];
        rootCol[0] = new ColumnConstraints();
        rootCol[0].setPercentWidth(20);
        rootCol[0].setHalignment(HPos.CENTER);
        rootCol[1] = new ColumnConstraints();
        rootCol[1].setPercentWidth(60);
        rootCol[1].setHalignment(HPos.CENTER);
        rootCol[2] = new ColumnConstraints();
        rootCol[2].setPercentWidth(20);
        rootCol[2].setHalignment(HPos.CENTER);
        root.getColumnConstraints().addAll(rootCol[0], rootCol[1], rootCol[2]);

        // Row sizing and alignment rules
        RowConstraints[] rootRow = new RowConstraints[2];
        rootRow[0] = new RowConstraints();
        rootRow[0].setPercentHeight(50);
        rootRow[0].setValignment(VPos.CENTER);
        rootRow[1] = new RowConstraints();
        rootRow[1].setPercentHeight(50);
        rootRow[1].setValignment(VPos.CENTER);
        root.getRowConstraints().addAll(rootRow[0], rootRow[1]);

        /* ---------------------- LEFT ATM BUTTONS ---------------------- */

        // Left button group
        VBox leftContainer = new VBox(8);
        leftContainer.setAlignment(Pos.CENTER);

        // Creates left buttons and sets properties
        leftButtons = new Button[3];
        for(int i = 0; i < 3; i++) {
            leftButtons[i] = new Button(">>>");
            leftButtons[i].setDisable(true);
        }

        // Adds buttons to left container
        leftContainer.getChildren().addAll(leftButtons[0], leftButtons[1], leftButtons[2]);

        /* ---------------------- RIGHT ATM BUTTONS ---------------------- */

        // Right button group
        VBox rightContainer = new VBox(8);
        rightContainer.setAlignment(Pos.CENTER);

        // Creates right buttons and sets properties
        rightButtons = new Button[3];
        for(int i = 0; i < 3; i++) {
            rightButtons[i] = new Button("<<<");
            rightButtons[i].setDisable(true);
        }

        /* ---------------------- KEYPAD ---------------------- */

        // Keypad layout
        GridPane keypad = new GridPane();
        
        // Column settings for keypad
        ColumnConstraints[] keyCol = new ColumnConstraints[4];
        for(int i = 0; i < 3; i++) {
            keyCol[i] = new ColumnConstraints();
            keyCol[i].setPercentWidth(20);
            keyCol[i].setHalignment(HPos.CENTER);
            keypad.getColumnConstraints().add(keyCol[i]);
        }
        keyCol[3] = new ColumnConstraints();
        keyCol[3].setPercentWidth(40);
        keyCol[3].setHalignment(HPos.CENTER);
        keypad.getColumnConstraints().add(keyCol[3]);

        // Row settings for keypad
        RowConstraints[] keyRow = new RowConstraints[4];
        for(int i = 0; i < 4; i++) {
            keyRow[i] = new RowConstraints();
            keyRow[i].setPercentHeight(25);
            keyRow[i].setValignment(VPos.CENTER);
            keypad.getRowConstraints().add(keyRow[i]);
        }

        // Obtains all buttons
        keyButtons = new Button[4][4];
        keyButtons[0][0] = new Button("7");
        keyButtons[0][1] = new Button("8");
        keyButtons[0][2] = new Button("9");
        keyButtons[0][3] = new Button("CANCEL");
        keyButtons[0][3].setOnAction(this::close);
        keyButtons[1][0] = new Button("4");
        keyButtons[1][1] = new Button("5");
        keyButtons[1][2] = new Button("6");
        keyButtons[1][3] = new Button("CLEAR");
        keyButtons[1][3].setOnAction(this::clearInput);
        keyButtons[2][0] = new Button("1");
        keyButtons[2][1] = new Button("2");
        keyButtons[2][2] = new Button("3");
        keyButtons[2][3] = new Button("ENTER");
        keyButtons[2][3].setOnAction(this::enter);
        keyButtons[3][0] = new Button(".");
        keyButtons[3][1] = new Button("0");
        keyButtons[3][2] = new Button(" ");

        // Sets size of all buttons and gives smaller buttons their function
        for(int i = 0; i < keyButtons.length; i++) {
            for(int j = 0; j < keyButtons[i].length - 1; j++) {
                keyButtons[i][j].setPrefSize(50, 50);
                keyButtons[i][j].setOnAction(this::keyNum);
            }
            if(keyButtons[i][3] != null) {
               keyButtons[i][3].setPrefSize(100, 50);
            }
        }

        // Adds all key buttons into keypad grid area
        for(int i = 0; i < keyButtons.length; i++) {
            for(int j = 0; j < keyButtons[i].length; j++) {
                if(keyButtons[i][j] != null) {
                    keypad.add(keyButtons[j][i], i, j);
                }
            }
        }

        /* ---------------------- MAIN SCREEN ---------------------- */
        screen = new GridPane();
        screen.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Column Setting for Main Screen
        ColumnConstraints screenCol = new ColumnConstraints();
        screenCol.setHalignment(HPos.CENTER);
        screen.getColumnConstraints().add(screenCol);

        // Row Setting for Main Screen
        RowConstraints[] screenRow = new RowConstraints[3];
        screenRow[0] = new RowConstraints();
        screenRow[0].setPercentHeight(10);
        screenRow[1] = new RowConstraints();
        screenRow[1].setPercentHeight(80);
        screenRow[1].setValignment(VPos.CENTER);
        screenRow[2] = new RowConstraints();
        screenRow[2].setPercentHeight(10);
        screen.getRowConstraints().addAll(screenRow[0], screenRow[1], screenRow[2]);

        // Gives screen padding between top and keypad.
        for(int i = 0; i < 2; i++) {
            Label screenHeader = new Label("");
            screenHeader.setPrefHeight(25);
            screenHeader.setPrefWidth(300);
            screenHeader.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
            screen.add(screenHeader, 0, 2 * i);
        }

        /* ---------------------- SCREEN SCENES ---------------------- */

        // Adds menu to screen
        cardSelector = new CardSelector(accounts);
        screen.add(cardSelector.getLayout(), 0, 1);
        currentScreen = cardSelector;
        Button tempButton = ((Button) cardSelector.getElement("Insert Card"));
        tempButton.setOnAction(this::insertCard);

        // Adds rest other screens
        pinEnter = new PinEnter(accounts);
        bankMenu = new BankMenu(this);
        deposit = new Deposit(accounts, this);
        withdraw = new Withdraw(accounts, this);
        transferMenu = new TransferMenu(accounts, this);
        summary = new Summary(accounts, this);

        /* ---------------------- ROOT ---------------------- */

        // Adds buttons to right container
        rightContainer.getChildren().addAll(rightButtons[0], rightButtons[1], rightButtons[2]);
        root.add(leftContainer, 0, 0);
        root.add(screen, 1, 0);
        root.add(rightContainer, 2, 0);
        root.add(keypad, 1, 1);

        /* ---------------------- SCENE DISPLAY ---------------------- */

        // Creates Scene that will be shown
        Scene scene = new Scene(root, 500, 500, Color.BLACK);
        primaryStage.setTitle("ATM Machine - Nikhil Pandey");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // Swaps between screen states
    public void changeScreenState(ScreenScene newScreen) {
        screen.getChildren().remove(currentScreen.getLayout());
        currentScreen = newScreen;
        screen.add(currentScreen.getLayout(), 0, 1);
        userInput = "";
    }

    // Handles all keypad numbers
    public void keyNum(Event e) {
        String input = ((Button) e.getSource()).getText();
        if(!input.equals(" ")) {
            userInput += input;
            currentScreen.inputHandle(input);
        }
    }

    // Enables and disables keypad
    public void toggleKeypad(Boolean disable) {
        for(int i = 0; i < keyButtons.length; i++) {
            for(int j = 0; j < keyButtons[i].length; j++) {
                if(keyButtons[i][j] != null) {
                    keyButtons[i][j].setDisable(disable);
                }
            }
        }
    }

    // Function for clear button
    public void clearInput(Event e) {
        userInput = "";
        if(currentScreen == pinEnter || currentScreen == deposit || currentScreen == withdraw) {
            currentScreen.inputHandle(cardSelector.getSelected() + "!");
        }
    }

    // Function for cancel button
    public void close(Event e) {
        if(currentScreen == cardSelector) {
            System.exit(1);
        }
        else if(currentScreen == pinEnter || currentScreen == bankMenu) {
            changeScreenState(cardSelector);
        }
        else {
            changeScreenState(bankMenu);
        }
    }

    // Function for enter button
    public void enter(Event e) {
        if(currentScreen == pinEnter || currentScreen == deposit || currentScreen == withdraw || currentScreen == transferMenu.getTransfer()) {
            String s = currentScreen.inputHandle(cardSelector.getSelected() + "*");
            if(s.equals("true")) {
                changeScreenState(bankMenu);
            }
        }
    }

    public void toDeposit() {
        changeScreenState(deposit);
    }

    public void toWithdraw() {
        changeScreenState(withdraw);
    }

    public ScreenScene getCurrentScreen() {
        return currentScreen;
    }

    public void toMenu() {
        changeScreenState(bankMenu);
    }

    public void toTransfer() {
        changeScreenState(transferMenu);
    }

    public void toSummary() {
        changeScreenState(summary);
    }

    public ScreenScene getSummary() {
        return summary;
    }

    public void insertCard(Event e) {
        changeScreenState(pinEnter);
    }

    public String getSelected() {
        return cardSelector.getSelected();
    }

    public static void main(String[] args) {
        new Client().run();
    }
    
}
