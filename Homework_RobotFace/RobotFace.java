package Homework_RobotFace;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class RobotFace extends Group {
   // Constructor
   public RobotFace() {
      // Prepares colors
      Color borderColor = Color.NAVY;
      Color earColor = Color.ORANGE;
      Color primaryColor = Color.AQUAMARINE;
      Color secondaryColor = Color.WHITE;
      
      // Creates face outline
      Circle face = new Circle(250, 250, 125);
      face.setFill(primaryColor);
      
      // Face border
      Circle face_border = new Circle(250, 250, 130);
      face_border.setFill(borderColor);
      
      // Goggles for robot
      Rectangle goggles = new Rectangle(150, 200, 200, 75);
      goggles.setFill(secondaryColor);
      goggles.setArcWidth(75);
      goggles.setArcHeight(75);
      
      // Goggles border
      Rectangle goggles_border = new Rectangle(146, 198, 208, 80);
      goggles_border.setFill(borderColor);
      goggles_border.setArcWidth(80);
      goggles_border.setArcHeight(80);
      
      // Left eye
      Circle left_eye_border = new Circle(200, 238, 25);
      left_eye_border.setFill(borderColor);
      
      Circle left_eye = new Circle(200, 238, 20);
      left_eye.setFill(secondaryColor);
      
      // Right eye
      Circle right_eye_border = new Circle(300, 238, 25);
      right_eye_border.setFill(borderColor);
      
      Circle right_eye = new Circle(300, 238, 20);
      right_eye.setFill(secondaryColor);
      
      // Smile
      Arc smile_border = new Arc(250, 300, 45, 45, 180, 180);
      smile_border.setFill(borderColor);
      
      Rectangle lip_line = new Rectangle(205, 295, 90, 5);
      lip_line.setFill(borderColor);
      
      Arc smile = new Arc(250, 300, 40, 40, 180, 180);
      smile.setFill(secondaryColor);
      
      // Antenna lines
      Line left_antenna = new Line(125, 125, 250, 250);
      left_antenna.setStrokeWidth(5);
      left_antenna.setFill(borderColor);
      
      Line right_antenna = new Line(250, 250, 375, 125);
      right_antenna.setStrokeWidth(5);
      right_antenna.setFill(borderColor);
      
      // Left ear base
      Circle left_ear_base_border = new Circle(165, 165, 25);
      left_ear_base_border.setFill(borderColor);
      
      Circle left_ear_base = new Circle(165, 165, 20);
      left_ear_base.setFill(earColor);
      
      // Right ear base
      Circle right_ear_base_border = new Circle(335, 165, 25);
      right_ear_base_border.setFill(borderColor);
      
      Circle right_ear_base = new Circle(335, 165, 20);
      right_ear_base.setFill(earColor);
      
      // Left ear
      Circle left_ear_border = new Circle(125, 125, 15);
      left_ear_border.setFill(borderColor);
      
      Circle left_ear = new Circle(125, 125, 10);
      left_ear.setFill(earColor);
      
      // Right ear
      Circle right_ear_border = new Circle(375, 125, 15);
      right_ear_border.setFill(borderColor);
      
      Circle right_ear = new Circle(375, 125, 10);
      right_ear.setFill(earColor);
      
      // Groups face together
      getChildren().addAll(left_antenna, right_antenna, 
                           left_ear_base_border, left_ear_base,
                           right_ear_base_border, right_ear_base,
                           left_ear_border, left_ear,
                           right_ear_border, right_ear,
                           face_border, face, 
                           goggles_border, goggles, 
                           left_eye_border, left_eye, 
                           right_eye_border, right_eye, 
                           smile_border, lip_line, smile);
   }
}
