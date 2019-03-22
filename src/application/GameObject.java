package application;

import java.util.Random;

import javafx.scene.shape.Circle;

public class GameObject {

	private double x,y;
	private double vx,vy;
	private double maxX,maxY;
	private double radius;
	private Circle node;
	
	private boolean outOfBounds=false;
	private Random random= new Random();
	
	public GameObject(double x, double y, double radius,double vx, double vy) {
		this.x=x;
		this.y=y;
		this.radius=radius;
		
		this.vx=vx-x;
		this.vy=vy-y;
		
		node = new Circle(x,y,radius);
	}
	
	public Circle getGraphic() {
		return node;
	}
	
	public void setBoundary(double x,double y) {
		this.maxX=x;
		this.maxY=y;
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

	public void setOutOfBounds(boolean b) {
		this.outOfBounds=b;	
	}
	
	
	public boolean isOutOfBounds() {
		return outOfBounds;
	}
	
}
