package application;


public class Player extends GameObject {

	private boolean alive;
	private int lives;

	public Player(double x, double y, double radius) {
		super(x,y,radius);

		alive = true;
		lives = 3;

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
//	public Bullet shoot(double x, double y, double radius)
//	{
//		Bullet b = new Bullet(x, y, radius);
//		
//		return b;
//	}





}
