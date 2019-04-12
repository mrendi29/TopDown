package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GameObject {

	private boolean alive;
	private int lives;
	private Image img;
	private ImageView imgv;

	public Player(double x, double y, double radius, String filename) {
		super(x, y, radius);

		alive = true;
		lives = 3;
		
		img = new Image(filename);
		imgv = new ImageView(img);
		
		imgv.setLayoutX(x - 125);
		imgv.setLayoutY(y - 125);
		

	}

	public Player() {
		this(200, 200, 20,"");
	}
	public ImageView getImgv()
	{
		return imgv;
	}
	public boolean injure() {
		lives--;
		if (lives == 0) {
			alive = false;
		}
		return alive;
	}

	public int getLives() {
		return lives;
	}


}
