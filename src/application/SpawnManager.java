package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;

public class SpawnManager {
	private  Pane root;
	private  Random random=new Random();
	private  int direction;
	private  int windowSizeX;
	private  int windowSizeY;
	private static SpawnManager _manager=null;
	
	
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
		direction = (random.nextInt(200)) % 4;
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
			spawnTop(enemyList);
			break;
		}

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

	private void spawnBottom(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double y = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(y, windowSizeY+1,20, windowSizeX / 2, windowSizeY / 2);
			enemy.createRandomSpeed();;
			enemyList.add(enemy);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());
			getRoot().getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}
	}

	private void spawnRight(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double y = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(windowSizeX+1, y,20, windowSizeX / 2, windowSizeY / 2);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());
			enemy.createRandomSpeed();;
			enemyList.add(enemy);
			root.getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}

	}

	private  void spawnTop(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double y = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(1, y,20, windowSizeX / 2, windowSizeY / 2);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());
			enemy.createRandomSpeed();;
			enemyList.add(enemy);
			root.getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}
	}

	private void spawnLeft(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double x = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(x, 1, 20,windowSizeX / 2, windowSizeY / 2);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());
			enemy.createRandomSpeed();;
			enemyList.add(enemy);
			root.getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}
	}

}
