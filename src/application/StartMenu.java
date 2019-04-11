package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class StartMenu {
	
	private int windowSizeX;
	private int windowSizeY;
	private int centerX;
	private int centerY;
	
	private String title;
	
	private Pane start;
	private Scene st;
	
	private Button go;
	
	
	
	public StartMenu(int windowSizeX, int windowSizeY)
	{
		this.windowSizeX = windowSizeX;
		this.windowSizeY = windowSizeY;
		this.centerX = windowSizeX/2;
		this.centerY = windowSizeY/2;
		
		title = "Start Menu";
		
		this.start = new Pane();
		this.st = new Scene(start, windowSizeX, windowSizeY);
		
		this.go = new Button("Start");
		this.go.setLayoutX(centerX);
		this.go.setLayoutY(centerY);
	}
	public Pane getPane()
	{
		return start;
	}
	public String getTitle() 
	{
		return title;
	}
	public Scene getScene()
	{
		return st;
	}
	public Button getButton()
	{
		return go;
	}
	public void setColor()
	{
		
		st.setFill(Paint.valueOf("100"));
	}
	
	
	

}
