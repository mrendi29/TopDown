//Wit topdown shooter project

package application;

import java.util.ArrayList;
import java.util.Random;
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

	public static void main(String[] args) {
		launch(args);
	}

	boolean shotFired = false;
	ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Enemy> enemies = new ArrayList<>();

	public void start(Stage primaryStage) throws Exception {

		int windowSizeX = 1920;
		int windowSizeY = 980;

		Random random = new Random(windowSizeX);
		
		Timer t = new Timer();
		Pane root = new Pane();
		Player p = new Player(windowSizeX / 2, windowSizeY / 2, 20);
		Text healthNode = new Text(50, windowSizeY - 100, "Lives: " + Integer.toString(p.getLives()));
		healthNode.setFont(new Font(20));
		root.getChildren().addAll(p.getGraphic(), healthNode);

		// Enemy enemy= new Enemy(windowSizeX/2+100, windowSizeY/2+100);
		SpawnManager manager = new SpawnManager(root,windowSizeX,windowSizeY);
		Scene s = new Scene(root, windowSizeX, windowSizeY);
		p.setBoundary(windowSizeX, windowSizeY);
		primaryStage.setTitle("Game Test");
		primaryStage.setScene(s);
		primaryStage.show();

		root.requestFocus();

		/**
		 * Beta randomizaton for spawning Enemies.
		 */

//		for (int i = 0; i < 5; ++i) {
//			if (i == 1) {
//				for (int j = 0; j < 5; ++j) {
//					double x = (random.nextDouble() * 1000) % windowSizeX;
//					Enemy enemy = new Enemy(x, 0, windowSizeX / 2, windowSizeY / 2);
//					enemies.add(enemy);
//					root.getChildren().add(enemies.get(j).getGraphic());
//
//				}
//			}
//
//			if (i== 1) {
//				// TODO: Ask professor for solution.
//				for (int j = 5; j < 10; ++j) {
//					double x = (random.nextDouble() * 1000) % windowSizeX;
//					Enemy enemy = new Enemy(0, x, windowSizeX / 2, windowSizeY / 2);
//					enemies.add(enemy);
//					root.getChildren().add(enemies.get(j).getGraphic());
//				}
//			}
//	
//		}

		root.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE) {
				System.exit(0);
			}
			/*
			 * if(e.getCode()==KeyCode.SPACE) { if(p.isFacing().equals("up")) {
			 * p.shoot(p.getX(), p.getY(), 10);
			 * 
			 * } if(p.isFacing().equals("down")) { //p.shoot(startx, starty, length);
			 * 
			 * } if(p.isFacing().equals("left")) { //p.shoot(startx, starty, length);
			 * 
			 * } if(p.isFacing().equals("right")) { //p.shoot(startx, starty, length);
			 * 
			 * } }
			 */
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
				// Bullet bullet = new Bullet(windowSizeX/2, windowSizeY/2, 5);
				// bullets.add(bullet);
				// root.getChildren().add(bullet.getGraphic());

				p.setColor();

				// bullet.setBoundary(windowSizeX, windowSizeY);

			}
		});

		root.setOnMouseClicked(e -> {

			double xPosition = e.getSceneX();
			double yPosition = e.getSceneY();

			Bullet bullet = new Bullet(windowSizeX / 2, windowSizeY / 2, 5, xPosition, yPosition);
			bullets.add(bullet);

			root.getChildren().add(bullet.getGraphic());
			bullet.setBoundary(windowSizeX, windowSizeY);

//			System.out.println(e.getScreenX());
//			System.out.println(e.getScreenY());

		});
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {

				for (int i = 0; i < bullets.size(); ++i) {
					bullets.get(i).move();

				}

				//FIXME: spawnmanager should be only instantiated once and then the spawn method should take care of the logic

				manager.spawn(enemies);

				
				

			}
		}, 500, 60);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				t.cancel();
			}
		});
		root.requestFocus();
	}
	

}
