import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Robot extends Application {
   // Overrides start of application
   public void start(Stage primaryStage) {
      // Creates robot face
      RobotFace robot = new RobotFace();
      
      // Sets up scene
      Scene scene = new Scene(robot, 500, 500, Color.WHITE);
      
      // Sets title of application
      primaryStage.setTitle("Robot!!!!");
      
      // Tells app what scene to show
      primaryStage.setScene(scene);
      
      // Displays scene
      primaryStage.show();
   }
   
   // Main method to run code
   public static void main(String[] args) {
      launch(args);
   }
}