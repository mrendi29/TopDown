//Wit topdown shooter project

package application;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameTest extends Application {
	
public static void main(String[] args) 
{
	launch(args);
}
boolean shotFired = false;
ArrayList<Bullet> bullets= new ArrayList<>();
public void start(Stage primaryStage) throws Exception {
	
		int windowSizeX = 1920;
		int windowSizeY = 1015;
		
		
		
		Timer t = new Timer();
		Pane root = new Pane();
		Player p = new Player(windowSizeX/2, windowSizeY/2, 20);
		Text healthNode = new Text(50,windowSizeY - 100,"Lives: "+Integer.toString(p.getLives()));
		healthNode.setFont(new 	Font(20));
		root.getChildren().addAll(p.getGraphic(), healthNode);
	
		
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
			/*if(e.getCode()==KeyCode.SPACE)	
			{   
				if(p.isFacing().equals("up"))
				{
					p.shoot(p.getX(), p.getY(), 10);

				}
				if(p.isFacing().equals("down"))
				{
					//p.shoot(startx, starty, length);

				}
				if(p.isFacing().equals("left"))
				{
					//p.shoot(startx, starty, length);

				}
				if(p.isFacing().equals("right"))
				{
					//p.shoot(startx, starty, length);

				}
			}*/
//			if(e.getCode() == KeyCode.UP)
//			{
//				p.moveForward();
//			}
//			if(e.getCode() == KeyCode.LEFT)
//			{
//				p.moveLeft();
//			}
//			if(e.getCode() == KeyCode.RIGHT)
//			{
//				p.moveRight();
//			}
//			if(e.getCode() == KeyCode.DOWN)
//			{
//				p.moveDown();
//			}
			
			if (e.getCode() == KeyCode.R) {
				Bullet bullet = new Bullet(windowSizeX/2, windowSizeY/2, 5);
				bullets.add(bullet);
				root.getChildren().add(bullet.getGraphic());
				
				p.setColor();
				
				bullet.setBoundary(windowSizeX, windowSizeY);
				
			}
		});
		
		t.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				
				Platform.runLater(()->p.move());
				for (int i=0; i<bullets.size();++i) {
					bullets.get(i).move();
					
				}
				
	
			}
		},500,60);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent arg0) {
				t.cancel();
			}
		});
		root.requestFocus();
	}
}
