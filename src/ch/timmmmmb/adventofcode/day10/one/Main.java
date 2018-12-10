package ch.timmmmmb.adventofcode.day10.one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    private static ArrayList<Point> points = new ArrayList<>();
    private static int step= 0;
    private static Label stepLabel = new Label("Step: "+step);


    public static void main(String[] args) {
        launch(args);
    }

    public static void moveAll(){
        for(Point point: points){
            point.move();
        }
        step++;
        stepLabel.setText("Step: "+step);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        AnchorPane root = new AnchorPane();
        //add all steps to the array
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int x = Integer.parseInt(line.substring(line.indexOf("position=<")+10,line.indexOf(",")).replaceAll(" ",""));
            int y = Integer.parseInt(line.substring(line.indexOf(",")+1,line.indexOf(">")).replaceAll(" ",""));
            int xspeed = Integer.parseInt(line.substring(line.indexOf("velocity=<")+10,line.lastIndexOf(",")).replaceAll(" ",""));
            int yspeed = Integer.parseInt(line.substring(line.lastIndexOf(",")+1,line.lastIndexOf(">")).replaceAll(" ",""));
            Point point = new Point(x,y,xspeed,yspeed);
            points.add(point);
            root.getChildren().add(point);
        }
        Button move = new Button("Move");
        move.setLayoutY(500);
        stepLabel.setLayoutY(450);
        root.getChildren().addAll(move,stepLabel);
        move.setOnAction(event -> moveAll());
        Scene scene = new Scene(root,1000,1000);
        primaryStage.setScene(scene);
        primaryStage.show();
        for(int i = 0; i<=10850;i++){
            moveAll();
        }
    }
}
