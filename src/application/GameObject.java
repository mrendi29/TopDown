package application;

import java.util.Random;

import javafx.scene.shape.Circle;

public class GameObject {

	private double x, y;
	private double vx, vy;
	private double maxX, maxY;
	private double radius;
	private Circle node;
	private double dt = 0.06;
	private Random random = new Random();
	private double speedCoeficient;
	private boolean alive = true;

	public boolean isAlive() {
		return alive;
	}

	public double getDt() {
		return dt;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isDead() {
		return !alive;
	}

	public GameObject(double x, double y, double radius, double vx, double vy) {
		this.x = x;
		this.y = y;
		this.radius = radius;

		this.vx = vx - x;
		this.vy = vy - y;

		node = new Circle(x, y, radius);
	}

	/**
	 * Constructor used for player.
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 */
	public GameObject(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		node = new Circle(x, y, radius);

	}

	public Circle getGraphic() {
		return node;
	}

	public void setBoundary(double x, double y) {
		this.maxX = x;
		this.maxY = y;
	}

	public void move() {

		x = x + speedCoeficient / 2 * vx * dt;
		y = y + speedCoeficient / 2 * vy * dt;

		node.setCenterX(x);
		node.setCenterY(y);

	}

	public boolean isOutOfBounds() {
		return (x - radius <= -50 || x + radius >= maxX + 50) || (y - radius <= -50 || y + radius >= maxY + 50);
	}

	public double getSpeedCoeficient() {
		return speedCoeficient;
	}

	public void setSpeedCoeficient(double speedCoeficient) {
		this.speedCoeficient = speedCoeficient;
	}

	public void createRandomSpeed() {
		double coef = Math.abs((random.nextDouble()) + 0.3) - 0.2;
		setSpeedCoeficient(coef);
	}

	public boolean isCollision(GameObject o2) {
		return this.getGraphic().getBoundsInParent().intersects(o2.getGraphic().getBoundsInParent());

	}

	public double getRadius() {
		return radius;
	}

}
