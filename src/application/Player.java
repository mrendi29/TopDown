package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GameObject {

	private boolean alive;
	private int lives;
 	private Image img= new Image("ufo.png");
 	private ImageView imgv;

	public Player(double x, double y, double radius) {
		super(x, y, radius);

		alive = true;
		lives = 3;
		imgv = new ImageView();
		imgv.setImage(img);
		
		imgv.setX(x-125);
		imgv.setY(y-125);
	}

	public Player() {
		this(200, 200, 20);
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
	public ImageView getNode()
 	{
 		return imgv;
 	}
//	public Bullet shoot(double x, double y, double radius)
//	{
//		Bullet b = new Bullet(x, y, radius);
//		
//		return b;
//	}

}
