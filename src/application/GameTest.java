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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameTest extends Application {

	double delay = 2000;
	boolean shotFired = false;
	ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Enemy> enemies = new ArrayList<>();
	double counter = 0;
	protected Player p;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		int windowSizeX = 1920;
		int windowSizeY = 980;
		int centerX = windowSizeX/2;
		int centerY = windowSizeY/2;

		Timer t = new Timer();
		Pane root = new Pane();
		Pane login = new Pane();
		Scene log = new Scene(login,windowSizeX, windowSizeY);

		p = new Player(windowSizeX / 2, windowSizeY / 2, 30, "ufo.png");
		Button b = new Button("login");
		b.setLayoutX(centerX + 100);
		b.setLayoutY(centerY);
		TextField username = new TextField();
		username.setLayoutX(centerX - 100);
		username.setLayoutY(centerY);
		Text userText = new Text(username.getLayoutX() - 200, username.getLayoutY()+50, "username");
		userText.setStyle("-fx-font: 24 arial;");
		TextField password = new TextField();
		password.setLayoutX(centerX - 300);
		password.setLayoutY(centerY);
		Text passText = new Text(password.getLayoutX()+200, password.getLayoutY()+50, "password");
		passText.setStyle("-fx-font: 24 arial;");
		
		login.getChildren().addAll(b, username, password, userText, passText);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(log);
		primaryStage.show();
		
		Text healthNode = new Text(50, windowSizeY - 100, "Lives: " + Integer.toString(p.getLives()));
		healthNode.setFont(new Font(20));
		p.getNode().setX(centerX - 125);
		p.getNode().setY(centerY - 125);
		root.getChildren().addAll(p.getGraphic(), healthNode, p.getNode());

		SpawnManager manager = SpawnManager.createInstance();
		manager.setVariables(root, windowSizeX, windowSizeY);

		Scene s = new Scene(root, windowSizeX, windowSizeY);
				
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setTitle("Game");
				primaryStage.setScene(s);
				primaryStage.show();
			}
		});
		
		root.setOnMouseClicked(e -> {

			double xPosition = e.getSceneX();
			double yPosition = e.getSceneY();

			Bullet bullet = new Bullet(windowSizeX / 2, windowSizeY / 2, 13, xPosition, yPosition);
			bullets.add(bullet);

			root.getChildren().addAll(bullet.getGraphic(), bullet.getIv());
			bullet.setBoundary(windowSizeX, windowSizeY);

		});
		root.setOnKeyPressed(e ->{
			
			
			
		});

		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				counter += 60;

				// TODO: Ask professor if having a bunch of static call methods here is bad.

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

				Physics.playerCollision(enemies, root, p);

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
