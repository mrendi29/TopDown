package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends GameObject{

	private ImageView imView;
	private Image img=new Image("bullet.png",36,36,true,true);

	public Enemy(double x, double y, double radius, double vx, double vy) {
		super(x,y,radius,vx,vy);
		
		imView = new ImageView();
		imView.setImage(img);
		imView.setX(x);
		imView.setY(y);
	}
	
	
	public ImageView getImage() {
		return imView;
	}
}
