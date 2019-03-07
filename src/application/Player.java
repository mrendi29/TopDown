package application;
import java.util.Random;

import javafx.scene.shape.Circle;

public class Player {
	
	private double x;
	private double y;
	private double radius;
	private double vx;
	private double vy;
	private double dx;
	private double dt;
	private double maxX;
	private double maxY;
	private String isFacing = "up";
	
	
	private Circle node;
	private Random rand = new Random();
	
	
	public Player(double x, double y, double radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		node = new Circle(x,y,radius);
		
		vx = 400; //pix/sec
		vy = 150; //pic/sec
		dt = 0.03; //sec
		
	}
	public Player()
	{
		this(200,200,20);
	}
	public String isFacing()
	{
		return isFacing;
	}
	public void setBoundary(double x, double y)
	{
		maxX = x;
		maxY = y;
	}
	public Circle getGraphic()
	{
		return node;
	}	
	public void moveForward()
	{	
		//node.setTranslateY(node.getTranslateY() - 20);
		isFacing = "up";
		
	}
	public void moveLeft()
	{
		//node.setTranslateX(node.getTranslateX() - 20);
		isFacing = "left";
		
	}
	public void moveDown()
	{
		//node.setTranslateY( node.getTranslateY()+ 20);
		isFacing="down";
		
	}
	public void moveRight()
	{
		//node.setTranslateX(node.getTranslateX() + 20);
		isFacing = "right";

		
	}
	public Bullet shoot(double startx, double starty, double length)
	{
		Bullet b = new Bullet(startx, starty, length);
		
		return b;
	}
	
	public double getX()
	{
		return node.getTranslateX();
	}
	public double getY()
	{
		return node.getTranslateY() -radius;
	}
	public void move()
	{
		if(isFacing.equals("up"))
		{
			node.setTranslateY(node.getTranslateY() - 10);
		}
		if(isFacing.equals("down"))
		{
			node.setTranslateY( node.getTranslateY()+ 10);
		}
		if(isFacing.equals("left"))
		{
			node.setTranslateX(node.getTranslateX() - 10);
		}
		if(isFacing.equals("right"))
		{
			node.setTranslateX(node.getTranslateX() + 10);
		}
	}

}
