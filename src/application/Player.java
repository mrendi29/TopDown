package application;

import javafx.scene.shape.Circle;

public class Player {

	private double x;
	private double y;
	private double radius;
	private boolean alive;
	private int lives;
	private Circle node;


	public Player(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		alive = true;
		node = new Circle(x, y, radius);
		lives = 3;

	}

	public Player() {
		this(200, 200, 20);
	}

	public Circle getGraphic() {
		return node;
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
//	public Bullet shoot(double x, double y, double radius)
//	{
//		Bullet b = new Bullet(x, y, radius);
//		
//		return b;
//	}





}
