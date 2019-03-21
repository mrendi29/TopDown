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
	/**
	 *  make an create instance 
	 *  and a setter.
	 *  private constructor 
	 *  static instance method.
	 *  
	 * @param root
	 * @param windowSizeX
	 * @param windowSizeY
	 * @param enemies
	 */
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
		direction = (random.nextInt(200)) % 3;
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
			Enemy enemy = new Enemy(y, windowSizeY,20, windowSizeX / 2, windowSizeY / 2);
			enemyList.add(enemy);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());
			
			root.getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}
//		double y = (random.nextDouble() * 1000) % windowSizeX;
//		Enemy enemy = new Enemy(y, windowSizeY, windowSizeX / 2, windowSizeY / 2);
//		enemyList.add(enemy);
//		return enemy;
		
	}

	private void spawnRight(ArrayList<Enemy> enemyList) {
		for (int j = 0; j < 2; ++j) {
			double y = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(windowSizeX, y,20, windowSizeX / 2, windowSizeY / 2);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());

			enemyList.add(enemy);
			
			//Indexof , or put the add enemy to the get.
			root.getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}

	}

	private  void spawnTop(ArrayList<Enemy> enemyList) {
		
		for (int j = 0; j < 2; ++j) {
			double y = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(0, y,20, windowSizeX / 2, windowSizeY / 2);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());

			enemyList.add(enemy);
			root.getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}
	}

	private void spawnLeft(ArrayList<Enemy> enemyList) {
		
		for (int j = 0; j < 2; ++j) {
			double x = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(x, 0, 20,windowSizeX / 2, windowSizeY / 2);
			enemy.setBoundary(getWindowSizeX(), getWindowSizeY());
			enemyList.add(enemy);
			root.getChildren().add(enemyList.get((int) enemyList.indexOf(enemy)).getGraphic());
		}

	}

}
