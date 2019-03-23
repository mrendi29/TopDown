package application;

import java.util.Random;

import javafx.scene.shape.Circle;

public class GameObject {

	private double x,y;
	private double vx,vy;
	private double maxX,maxY;
	private double radius;
	private Circle node;
	private double dt = 0.06;
//	private boolean outOfBounds=false;
	private Random random= new Random();
	private double speedCoeficient;


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
		
		x = x + speedCoeficient * vx * dt;
		y = y + speedCoeficient *vy * dt;
		
		node.setCenterX(x);
		node.setCenterY(y);

	}

	
	public boolean isOutOfBounds() {
		return 	 (x - radius <= 0 || x + radius >= maxX) || (y - radius <= 0 || y + radius >= maxY); 	
	}
	
	public double getSpeedCoeficient() {
		return speedCoeficient;
	}

	public void setSpeedCoeficient(double speedCoeficient) {
		this.speedCoeficient = speedCoeficient;
	}
	
	public void createRandomSpeed() {
		double coef= Math.abs((random.nextDouble() )+0.5);
		setSpeedCoeficient(coef);
	}
}
