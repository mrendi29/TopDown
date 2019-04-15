package application;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class Physics {
	/**
	 * Method responsible for checking if bullets collide with enemies. If collision
	 * happens then remove both bullet and enemy from screen.
	 * 
	 * @param bullets
	 * @param enemies
	 * @param root
	 */
	public static void collision(ArrayList<Bullet> bullets, ArrayList<Enemy> enemies, Pane root, Player p, Text healthNode) {

		for (int i = 0; i < bullets.size(); ++i) {
			for (int j = 0; j < enemies.size(); ++j) {

				if (bullets.get(i).isCollision(enemies.get(j))) {
					Bullet bullet = bullets.get(i);
					Enemy enemy = enemies.get(j);
					bullet.setAlive(false);
					enemy.setAlive(false);
					p.score();
					if(p.getScore() % 10 == 0)
					{
						p.levelUp();
					}
					System.out.println(p.getScore());
					// TODO: FIX RENDER PROBLEMS.
					Platform.runLater(() -> root.getChildren().removeAll(bullet.getGraphic(), enemy.getGraphic()));
					Platform.runLater(() -> root.getChildren().remove(bullet.getIv()));
					Platform.runLater(() -> root.getChildren().remove(enemy.getIv()));
					
					
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
				System.out.println("Player hit");
				Platform.runLater(() -> root.getChildren().removeAll(enemy.getGraphic(), enemy.getIv()));
				Platform.runLater(() -> root.getChildren().remove(enemy.getIv()));

			}
		}
		
		enemies.removeIf(GameObject::isDead);
		enemies.forEach(GameObject::move);
	}

}
