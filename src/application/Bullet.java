package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends GameObject {
	
	
	private ImageView imView;
	private Image img;

	public Bullet(double x, double y, double radius ,double vx, double vy) {
		super(x,y,radius,vx,vy);
		
		imView = new ImageView();
		imView.setImage(img);
		
	}
	
	
	public ImageView getImage() {
		return imView;
	}
	
}
