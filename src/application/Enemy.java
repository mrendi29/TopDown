package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends GameObject {

	private ImageView imView;
	private Image img = new Image("fighter.png", 80, 80, true, true);

	public Enemy(double x, double y, double radius, double vx, double vy) {
		super(x, y, radius, vx, vy);

		imView = new ImageView();
		imView.setImage(img);

		imView.setRotate(angleOfRotation());

		// Make the bullet bounding box invisible so images can appear better.
		super.getGraphic().setOpacity(0);

	}

	public ImageView getIv() {
		return imView;
	}

	public void move() {

		double x = getX() + getSpeedCoeficient() / 2 * getVx() * getDt();
		double y = getY() + getSpeedCoeficient() / 2 * getVy() * getDt();

		super.setX(x);
		super.setY(y);

		getGraphic().setCenterX(x);
		getGraphic().setCenterY(y);

		getIv().setX(x - 40);
		getIv().setY(y - 40);

	}
	
	@Override
	public  String toString() {
		return "Enemy";
	}
	public double angleOfRotation() {
		double rotationAngle = Math.toDegrees(Math.atan((super.getVy() / super.getVx())));

		// x< 0 && y < 0
		if (super.getVx() < 0 && super.getVy() < 0) {
			return rotationAngle - 90;
		}
		// x > 0 y < 0
		else if (super.getVx() > 0 && super.getVy() > 0) {
			return rotationAngle + 90;
		}
		// x <0 && y > 0
		else if (super.getVx() > 0 && super.getVy() < 0) {
			return rotationAngle + 90;
		}
		// x>0 && y >0
		else {
			return rotationAngle - 90;
		}
	}

}
