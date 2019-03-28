//Wit Top-Down shooter project

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

	double delay = 1000;
	boolean shotFired = false;
	ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Enemy> enemies = new ArrayList<>();
	double counter = 0;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		int windowSizeX = 1920;
		int windowSizeY = 980;

		Timer t = new Timer();
		Pane root = new Pane();
		Player p = new Player(windowSizeX / 2, windowSizeY / 2, 30);
		Text healthNode = new Text(50, windowSizeY - 100, "Lives: " + Integer.toString(p.getLives()));
		healthNode.setFont(new Font(20));
		root.getChildren().addAll(p.getGraphic(), healthNode);

		SpawnManager manager = SpawnManager.createInstance();
		manager.setVariables(root, windowSizeX, windowSizeY);

		Scene s = new Scene(root, windowSizeX, windowSizeY);
		primaryStage.setTitle("Game Test");
		primaryStage.setScene(s);
		primaryStage.show();

		root.setOnMouseClicked(e -> {

			double xPosition = e.getSceneX();
			double yPosition = e.getSceneY();

			Bullet bullet = new Bullet(windowSizeX / 2, windowSizeY / 2, 5, xPosition, yPosition);
			bullets.add(bullet);

			root.getChildren().add(bullet.getGraphic());
			bullet.setBoundary(windowSizeX, windowSizeY);
			// System.out.println("SCREEN CLICKED");
		});

		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				counter += 60;
				
				
				for (int i = 0; i < bullets.size(); ++i) {
					bullets.get(i).setSpeedCoeficient(2.3);
					bullets.get(i).move();
					
						
					if (bullets.get(i).isOutOfBounds()) {
						Bullet bullet = bullets.get(i);
						Platform.runLater(() -> root.getChildren().remove(bullet.getGraphic()));
						bullets.remove(i);
						// System.out.println("Removed");
					}
				}

				if (counter > delay) {
					counter = 0;
					Platform.runLater(() -> manager.spawn(enemies));
				}
				
				for (int i = 0; i < enemies.size(); ++i) {
				
					enemies.get(i).move();
					
					if (enemies.get(i).isOutOfBounds()) {
					Enemy enemy = enemies.get(i);
					Platform.runLater(() -> root.getChildren().remove(enemy.getGraphic()));
						enemies.remove(i);
						
						//System.out.println("ENEMY Removed");
					}
				}
				
				collision();
				
				
			}

			public void collision() {
			
				for (GameObject bullet:bullets) {
					for (GameObject enemy: enemies) {
						if (bullet.isCollision(enemy)) {
							bullet.setAlive(false);
							enemy.setAlive(false);
						}
					}
				}
				//Go through all the bullets and enemies  if a bullet is dead remove it from the list.
				bullets.removeIf(GameObject::isDead);
				enemies.removeIf(GameObject::isDead);
				
//				bullets.forEach(GameObject::move);
//				enemies.forEach(GameObject::move);
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
