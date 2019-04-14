package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class StartMenu {
	
	private int windowSizeX;
	private int windowSizeY;
	private int centerX;
	private int centerY;
	private BackgroundImage bg;
	private Background backg;
	
	private String title;
	
	private Pane start;
	private Scene st;
	
	private Button go;
	private Image BgScreen;
	
	private Image titlePic;
	private ImageView viewTitPic;
	
	
	
	public StartMenu(int windowSizeX, int windowSizeY, String filename, String titlePic)
	{
		this.windowSizeX = windowSizeX;
		this.windowSizeY = windowSizeY;
		this.centerX = windowSizeX/2;
		this.centerY = windowSizeY/2;
		
		title = "Start Menu";
		
		this.start = new Pane();
		this.st = new Scene(start, windowSizeX, windowSizeY);
		
		BgScreen = new Image(filename);
		
		this.titlePic = new Image(titlePic);
		this.viewTitPic= new ImageView(this.titlePic);
		viewTitPic.setLayoutX(centerX - 445);
		viewTitPic.setLayoutY(centerY - 500);
		
		this.bg = new BackgroundImage(BgScreen, null, null, null, null); 
		backg = new Background(bg);
		
		this.go = new Button("Start");
		this.go.setStyle("-fx-font: 25 arial;");
		this.go.setLayoutX(centerX-30);
		this.go.setLayoutY(centerY);
	}
	public ImageView getTitlePic()
	{
		return viewTitPic;
	}
	public Background getBG()
	{
		return backg;
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
	
	
	
	

}
