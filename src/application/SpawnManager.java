package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;

/**
 * Spawn Manager class which deals with the random spawn of enemies in 4
 * different regions based on a delay.
 * 
 * Since we need only an instance of the class the Singleton Pattern was the
 * best choice to be adapted.
 * 
 * @author caushie
 *
 */
public class SpawnManager {
	private Pane root;
	private Random random = new Random();
//	private int direction;
	private int windowSizeX;
	private int windowSizeY;
	private static SpawnManager _manager = null;
	private int radius = 20;

	private SpawnManager() {
	}

	public void setVariables(Pane root, int windowSizeX, int windowSizeY) {
		this.root = root;
		this.windowSizeX = windowSizeX;
		this.windowSizeY = windowSizeY;
	}

	public static SpawnManager createInstance() {
		if (_manager == null) {
			_manager = new SpawnManager();
		}
		return _manager;
	}

	public void spawn(ArrayList<Enemy> enemyList) {
		int direction = (random.nextInt(2000)) % 4;
		switch (direction) {
		case 0:
			spawnLeft(enemyList);
			break;
		case 1:
			spawnTop(enemyList);
			break;
		case 2:
			spawnRight(enemyList);
			break;
		case 3:
			spawnBottom(enemyList);
			break;
		default:
			break;
		}

	}

	// TODO: FIX PROBLEM WITH RANDOM NUMBERS.
	private void spawnBottom(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double x = (random.nextInt(1800) % windowSizeX);
			Enemy enemy = new Enemy(x, windowSizeY + 1, radius, windowSizeX / 2, windowSizeY / 2);
			attachEnemy(enemyList, enemy);
		}
	}

	private void spawnRight(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double y = (random.nextInt(1800) % windowSizeY);
			Enemy enemy = new Enemy(windowSizeX + 1, y, radius, windowSizeX / 2, windowSizeY / 2);
			attachEnemy(enemyList, enemy);
		}

	}

	private void spawnTop(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double y = (random.nextInt(1800) % windowSizeX);
			Enemy enemy = new Enemy(y, 1, radius, windowSizeX / 2, windowSizeY / 2);
			attachEnemy(enemyList, enemy);
		}
	}

	private void spawnLeft(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double x = (random.nextInt(2000) % windowSizeY);
			Enemy enemy = new Enemy(0, x, radius, windowSizeX / 2, windowSizeY / 2);
			attachEnemy(enemyList, enemy);
		}
	}

	private void attachEnemy(ArrayList<Enemy> enemyList, Enemy enemy) {
		enemy.setBoundary(getWindowSizeX(), getWindowSizeY());
		enemy.createRandomSpeed();
		enemyList.add(enemy);
		root.getChildren().addAll(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic(),
				enemyList.get((int) enemyList.indexOf(enemy)).getIv());
	}

	public Pane getRoot() {
		return root;
	}

	public int getWindowSizeX() {
		return windowSizeX;
	}

	public int getWindowSizeY() {
		return windowSizeY;
	}

}
