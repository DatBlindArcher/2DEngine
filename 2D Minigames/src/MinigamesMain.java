import game.engine.Engine;
import javafx.application.Application;
import javafx.stage.Stage;

public class MinigamesMain extends Application
{
	public static void main(String[] args)
	{
		Engine game = new Engine("Mini Games", 1000, 800);
		new MainScene().activate();
		game.run();
	}

	public void start(Stage primaryStage) throws Exception 
	{
		
	}
}