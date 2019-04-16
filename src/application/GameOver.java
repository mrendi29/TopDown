package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameOver extends Application {

	private Pane root;
	private Scene s;
	private int windowSizeX = 1920;
	private int windowSizeY = 980;
	private Image imgBackground = new Image(getClass().getResourceAsStream("space.png"));

	public GameOver() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		root = new Pane();

		primaryStage.setScene(s);
		primaryStage.show();
		root.getChildren().add(new ImageView(imgBackground));

	}

}
