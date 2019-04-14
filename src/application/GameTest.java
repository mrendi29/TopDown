//Wit Top-Down shooter project

package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameTest extends Application {

	double delay = 2000;
	ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Enemy> enemies = new ArrayList<>();
	double counter = 0;
	protected Player p;
	private int windowSizeX = 1920;
	private int windowSizeY = 980;
	Pane root;
	SpawnManager manager;
	protected boolean isPaused = true;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		Timer t = new Timer();
		root = new Pane();
		p = new Player(windowSizeX / 2, windowSizeY / 2, 50);

		// creates new StartMenu
		StartMenu start = new StartMenu(windowSizeX, windowSizeY, "space.png", "title.png");

		// sets background image to be space
		start.getPane().setBackground(start.getBG());
		start.getPane().getChildren().addAll(start.getButton(), start.getTitlePic());

		primaryStage.setTitle(start.getTitle());
		primaryStage.setScene(start.getScene());
		primaryStage.show();

		Text healthNode = new Text(50, windowSizeY - 100, "Lives: " + Integer.toString(p.getLives()));
		healthNode.setFont(new Font(20));
		healthNode.setFill(Color.rgb(255, 255, 255));

		root.setBackground(start.getBG());
		root.getChildren().addAll(p.getGraphic(), p.getNode(), healthNode);

		manager = SpawnManager.createInstance();
		manager.setVariables(root, windowSizeX, windowSizeY);

		Scene s = new Scene(root, windowSizeX, windowSizeY);

		start.getButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				isPaused = false;
				primaryStage.setTitle("Game");
				primaryStage.setScene(s);
				primaryStage.show();
			}
		});

		root.setOnMouseClicked(e -> {

			shootBullet(e);

		});

		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				if (!isPaused) {
					update();
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

	private void shootBullet(MouseEvent e) {
		double xPosition = e.getSceneX();
		double yPosition = e.getSceneY();

		Bullet bullet = new Bullet(windowSizeX / 2, windowSizeY / 2, 13, xPosition, yPosition);
		bullets.add(bullet);

		root.getChildren().addAll(bullet.getGraphic(), bullet.getIv());
		bullet.setBoundary(windowSizeX, windowSizeY);

	}

	protected void update() {
		counter += 60;

		// TODO: Ask professor if having a bunch of static call methods here is bad.

		// TODO: Ask professor how to resolve java thread bug.
		for (int i = 0; i < bullets.size(); ++i) {
			bullets.get(i).setSpeedCoeficient(2.3);
			bullets.get(i).move();

			if (bullets.get(i).isOutOfBounds()) {
				Bullet bullet = bullets.get(i);
				Platform.runLater(() -> root.getChildren().removeAll(bullet.getGraphic(), bullet.getIv()));
				bullets.remove(i);
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
			}
		}

		Physics.collision(bullets, enemies, root);
		p.injure();
		Physics.playerCollision(enemies, root, p);
	}

}
