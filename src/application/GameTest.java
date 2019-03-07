package application;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameTest extends Application {
	
public static void main(String[] args) 
{
	launch(args);
}
boolean shotFired = false;
public void start(Stage primaryStage) throws Exception {
	
		int windowSizeX = 1920;
		int windowSizeY = 1080;
		
		
		
		Timer t = new Timer();
		Pane root = new Pane();
		Player p = new Player();
		
		root.getChildren().add(p.getGraphic());
		
		
		Scene s = new Scene(root ,windowSizeX, windowSizeY);
		p.setBoundary(windowSizeX, windowSizeY);
		primaryStage.setTitle("Game Test");
		primaryStage.setScene(s);
		primaryStage.show();
		
		
		root.requestFocus();
		
		root.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ESCAPE)	
			{   
				System.exit(0);
			}
			if(e.getCode() == KeyCode.SPACE)
			{
				//creates a new bullet
				Bullet b = p.shoot(p.getX(), p.getY(), p.getY());
				
				
				
				
				
				//adds bullet to pane
				root.getChildren().add(b.getGraphic());
				
			}
			if(e.getCode() == KeyCode.UP)
			{
				p.moveForward();
			}
			if(e.getCode() == KeyCode.LEFT)
			{
				p.moveLeft();
			}
			if(e.getCode() == KeyCode.RIGHT)
			{
				p.moveRight();
			}
			if(e.getCode() == KeyCode.DOWN)
			{
				p.moveDown();
			}
		});
		
		t.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				
				Platform.runLater(()->p.move());

			}
		},100,30);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent arg0) {
				t.cancel();
			}
		});
		root.requestFocus();
	}
}
