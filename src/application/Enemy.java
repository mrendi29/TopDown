package application;

import java.util.Random;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Enemy {

	private double x, y;
	private double vx;
	private double vy;
	private double maxX;
	private double maxY;
	private Circle node;
	private boolean outOfBounds = false;
	Random random = new Random();
	private double dt = (random.nextDouble()+1) % 0.06;
	private double radius;

	public Enemy(double x, double y, double radius, double vx, double vy) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		node = new Circle(x, y, radius);
		this.vx = vx - x;
		this.vy = vy - y;

	}

	public Circle getGraphic() {
		return node;
	}

	public void setBoundary(double x, double y) {
		maxX = x;
		maxY = y;
	}

	public void move() {
		x = x + vx * dt;
		y = y + vy * dt;

		if (x - radius <= 0 || x + radius >= maxX) {
			setOutOfBounds(true);
		}

		if (y - radius <= 0 || y + radius >= maxY) {
			setOutOfBounds(true);
		}

		node.setCenterX(x);
		node.setCenterY(y);

	}

	public boolean isOutOfBounds() {
		return outOfBounds;
	}

	public void setOutOfBounds(boolean outOfBounds) {
		this.outOfBounds = outOfBounds;
	}

}
