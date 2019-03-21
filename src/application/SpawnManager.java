package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;

public class SpawnManager {
	private  Pane root;
	private  Random random;
	private  int direction = (random.nextInt(200)) % 3;
	private  int windowSizeX;
	private  int windowSizeY;
	private static SpawnManager manager = null;
	
	public SpawnManager(Pane root, int windowSizeX, int windowSizeY) {
		this.root = root;
		this.windowSizeX = windowSizeX;
		this.windowSizeY = windowSizeY;
		
	}
	
	
//	public static SpawnManager createInstance(Pane root, int windowSizeX, int windowSizeY,ArrayList<Enemy> enemyList) {
//		if (manager == null) {
//			manager = new SpawnManager(root, windowSizeX,windowSizeY,enemyList);
//		}
//		return manager;
//	}
	public void spawn(ArrayList<Enemy> enemyList) {

		switch (direction) {
		case 0:
			spawnLeft(enemyList);
			break;
		case 1:
			spawnTop(enemyList);
			break;
//		case 2:
//			spawnRight(enemyList);
//			break;
//		case 3:
//			spawnBottom(enemyList);
//			break;
			default:
			spawnTop(enemyList);
			break;
		}

	}

	private  void spawnBottom(ArrayList<Enemy> enemyList) {
		// TODO Auto-generated method stub

	}

	private void spawnRight(ArrayList<Enemy> enemyList) {
		// TODO Auto-generated method stub

	}

	private  void spawnTop(ArrayList<Enemy> enemyList) {
		
		for (int j = 0; j < 5; ++j) {
			double x = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(0, x, windowSizeX / 2, windowSizeY / 2);
			enemyList.add(enemy);
			root.getChildren().add(enemyList.get(j).getGraphic());
		}
	}

	private void spawnLeft(ArrayList<Enemy> enemyList) {

		for (int j = 0; j < 5; ++j) {
			double x = (random.nextDouble() * 1000) % windowSizeX;
			Enemy enemy = new Enemy(x, 0, windowSizeX / 2, windowSizeY / 2);
			enemyList.add(enemy);
			root.getChildren().add(enemyList.get(j).getGraphic());
		}

	}

}
