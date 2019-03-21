package application;

import java.util.Random;

import javafx.scene.shape.Circle;

public abstract class Entity {
	public double x,y;
	private double vx,vy;
	private double maxX,maxY;
	private Circle node;
	Random random = new Random();
	private double radius;
	
	public Entity(double x, double y, double vx, double vy) {
		this.x=x;
		this.y=y;
		
		this.vx=vx-x;
		this.vx=vy-y;
		
		
	}
	
	abstract void move();
	
	abstract void setBoundary(double x,double y);
	
	abstract Circle getGraphic();
	
	
	
}
