package ATM_Project;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

public abstract class ScreenScene {
    public abstract Control getElement(String s);
    public abstract Pane getLayout();
    public abstract String inputHandle(String input);
}
