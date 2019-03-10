package application;

import java.util.Random;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Enemy {

	private double x,y;
	private double length,width;
	private double vx;
	private double vy;
	private double maxX;
	private double maxY;
	private Circle node;
	Random random = new Random();
	private double dt;
	public Enemy(double x, double y, double vx, double vy) {
		this.x = x;
		this.y = y;
		node = new Circle(x,y,30);
		
		this.vx = vx-x;
		this.vy =  vy-y;
		dt = 0.03;
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

//		if (x - radius <= 0 || x + radius >= maxX) {
//			// TODO: Add better detachment handling.
//
//			outOfBounds = true;
//
//		}
//
//		if (y - radius <= 0 || y + radius >= maxY) {
//
//			outOfBounds = true;
//
//		}
//
		node.setCenterX(x);
		node.setCenterY(y);
		
	}
	
	
}
