package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Player extends GameObject {

	private boolean alive;
	private int lives;
	private Image img = new Image("ufo.png");
	private ImageView imgv;
	private int score;
	private int level;

	public Player(double x, double y, double radius) {
		super(x, y, radius);

		alive = true;
		lives = 3;
		score = 0;
		level = 1;
		imgv = new ImageView();
		imgv.setImage(img);

		imgv.setX(x - 125);
		imgv.setY(y - 125);
	}

	public Player() {
		this(200, 200, 20);
	}
	public void levelUp()
	{
		level++;
	}
	public  int getLevel()
	{
		return level;
	}
	public int injure() {
		this.lives--;
		if (this.lives == 0) {
			alive = false;
		}
		return this.lives;
	}
	public int getScore()
	{
		return score;
	}
	public void score()
	{
		score++;
	}
	public int getLives() {
		return lives;
	}

	public ImageView getNode() {
		return imgv;
	}

	@Override
	public  String toString() {
		return "Player";
	}
}
