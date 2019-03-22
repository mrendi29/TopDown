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

		Timer t = new Timer();
		Pane root = new Pane();
		Player p = new Player(windowSizeX / 2, windowSizeY / 2, 20);
		Text healthNode = new Text(50, windowSizeY - 100, "Lives: " + Integer.toString(p.getLives()));
		healthNode.setFont(new Font(20));
		root.getChildren().addAll(p.getGraphic(), healthNode);

		SpawnManager manager = SpawnManager.createInstance();
		manager.setVariables(root, windowSizeX, windowSizeY);


		Scene s = new Scene(root, windowSizeX, windowSizeY);
		p.setBoundary(windowSizeX, windowSizeY);
		primaryStage.setTitle("Game Test");
		primaryStage.setScene(s);
		primaryStage.show();

		root.requestFocus();

		root.setOnMouseClicked(e -> {

			double xPosition = e.getSceneX();
			double yPosition = e.getSceneY();

			Bullet bullet = new Bullet(windowSizeX / 2, windowSizeY / 2, 10, xPosition, yPosition);
			bullets.add(bullet);

			root.getChildren().add(bullet.getGraphic());
			bullet.setBoundary(windowSizeX, windowSizeY);

		});

		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {

				Platform.runLater(() -> p.move());

				for (int i = 0; i < bullets.size(); ++i) {
					bullets.get(i).move();
					if (bullets.get(i).getOutOfBounds()) {
						bullets.remove(i);
						//System.out.println("Removed");
					}
				}

				Platform.runLater(() -> manager.spawn(enemies));

				for (int i = 0; i < enemies.size(); ++i) {
					enemies.get(i).move();
					if (enemies.get(i).isOutOfBounds()) {
						enemies.remove(i);
						//System.out.println("ENEMY Removed");
					}
				}

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
