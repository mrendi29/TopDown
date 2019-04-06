package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends GameObject {

	private ImageView imView;
	private Image img = new Image("bullet.png", 50, 50, true, true);

	public Bullet(double x, double y, double radius, double vx, double vy) {
		super(x, y, radius, vx, vy);

		imView = new ImageView();
		imView.setImage(img);

		// Determining angle in which the bullet should rotate
		imView.setRotate(angleOfRotation());

	}

	public void move() {

		double x = getX() + getSpeedCoeficient() / 2 * getVx() * getDt();
		double y = getY() + getSpeedCoeficient() / 2 * getVy() * getDt();

		super.setX(x);
		super.setY(y);

		getGraphic().setCenterX(x);
		getGraphic().setCenterY(y);

		getIv().setX(x - 25);
		getIv().setY(y - 25);

	}

	public double angleOfRotation() {
		double rotationAngle = Math.toDegrees(Math.atan((super.getVy() / super.getVx())));
		if (super.getVx() < 0) {
			return ((rotationAngle) + 225);
		} else {
			return ((rotationAngle) + 45);
		}
	}

	public ImageView getIv() {
		return imView;
	}

	public Image getImage() {
		return img;
	}
}
