package application;
import javafx.scene.shape.Line;

public class Bullet {
	
	private Line node;
	private double x;
	private double y;
	private double endY;
	
	public Bullet(double x, double y,double ylength)
	{
		this.x = x;
		this.y = y;
		endY = y - ylength;
		node = new Line(x, y, x, endY);
	}
	public void move()
	{
		x += 10;
		node.setEndX(node.getEndX() + 10);
	}
	public Line getGraphic()
	{
		return node;
	}
}
