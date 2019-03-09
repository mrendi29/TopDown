package application;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Bullet {
	
	private Circle node;
	private double x;
	private double y;
	private double endY;
	private double vx;
	private double vy;
	private double dt;
	private double radius;
	private double maxX;
	private double maxY;
	private boolean outOfBounds;
	public Bullet(double x, double y,double radius,double vx,double vy)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		
		node = new Circle(x, y, radius );
		
		this.vx= vx-x;
		this.vy = vy-y;
		dt=0.2;

	}
	public void move()
	{
		x=x+vx*dt;
		y=y+vy*dt;
		
		if (x-radius<=0 || x+radius>=maxX) {
			//TODO: Add better detachment handling.
			outOfBounds=true;
		}
		
		if(y-radius<=0 ||  y+radius>=maxY) {
			outOfBounds=true;
		}
		
		node.setCenterX(x);
		node.setCenterY(y);
		
	}
	
	public void setBoundary(double x, double y) {
		maxX = x;
		maxY=y;
	}
	public Circle getGraphic()
	{
		return node;
	}
	
	public boolean getOutOfBounds() {
		return outOfBounds;
	}
}
