package application;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public abstract class Physics {
	/**
	 * Method responsible for checking if bullets collide with enemies. If collision
	 * happens then remove both bullet and enemy from screen.
	 * 
	 * @param bullets
	 * @param enemies
	 * @param root
	 */
	public static void collision(ArrayList<Bullet> bullets, ArrayList<Enemy> enemies, Pane root) {

		for (int i = 0; i < bullets.size(); ++i) {
			for (int j = 0; j < enemies.size(); ++j) {

				if (bullets.get(i).isCollision(enemies.get(j))) {
					Bullet bullet = bullets.get(i);
					Enemy enemy = enemies.get(j);
					bullet.setAlive(false);
					enemy.setAlive(false);

					Platform.runLater(() -> root.getChildren().removeAll(bullet.getGraphic(), enemy.getGraphic()));
					Platform.runLater(() -> root.getChildren().remove(bullet.getIv()));
				}
			}
		}

		// Go through all the bullets and enemies if a bullet and enemy is "dead" remove
		// it from the
		// list.
		bullets.removeIf(GameObject::isDead);
		enemies.removeIf(GameObject::isDead);
		// Update Each Bullet and Enemy.
		bullets.forEach(GameObject::move);
		enemies.forEach(GameObject::move);
	}

	/**
	 * Method detecting collision between player and the enemies.
	 * 
	 * @param enemies
	 * @param root
	 * @param player
	 */
	public static void playerCollision(ArrayList<Enemy> enemies, Pane root, Player player) {
		for (int i = 0; i < enemies.size(); ++i) {
			if (enemies.get(i).isCollision(player)) {
				Enemy enemy = enemies.get(i);
				enemy.setAlive(false);

				Platform.runLater(() -> root.getChildren().removeAll(enemy.getGraphic()));
			}
		}
		enemies.removeIf(GameObject::isDead);
		enemies.forEach(GameObject::move);
	}

}
