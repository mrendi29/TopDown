package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GameObject {

	private boolean alive;
	private int lives;
	private Image img;
	private ImageView imgv;

	public Player(double x, double y, double radius, String img) {
		super(x, y, radius);
		alive = true;
		lives = 3;
		this.img = new Image(img);
		this.imgv = new ImageView(this.img);

	}

	public Player() {
		this(200, 200, 20,"");
	}

	public boolean injure() {
		lives--;
		if (lives == 0) {
			alive = false;
		}
		return alive;
	}
	public ImageView getNode()
	{
		return imgv;
	}
	public int getLives() {
		return lives;
	}

}
