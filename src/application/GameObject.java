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
	private boolean alive=true;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public boolean isDead() {
		return !alive;
	}

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
		
		x = x + speedCoeficient/2 * vx * dt;
		y = y + speedCoeficient/2 *vy * dt;
		
		node.setCenterX(x);
		node.setCenterY(y);
		
		
	}

	
	public boolean isOutOfBounds() {
		return 	 (x - radius <= -50 || x + radius >= maxX+50) || (y - radius <= -50 || y + radius >= maxY+50); 	
	}
	
	public double getSpeedCoeficient() {
		return speedCoeficient;
	}

	public void setSpeedCoeficient(double speedCoeficient) {
		this.speedCoeficient = speedCoeficient;
	}
	
	public void createRandomSpeed() {
		double coef= Math.abs((random.nextDouble() )+0.3);
		setSpeedCoeficient(coef);
	}
	
	public boolean isCollision(GameObject o2 ) {
		return getGraphic().getBoundsInParent().intersects(o2.getGraphic().getBoundsInParent());
			
	}
	
}
