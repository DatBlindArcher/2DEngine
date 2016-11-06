package multiplayer.game;

import game.engine.Engine;
import javafx.application.Application;
import javafx.stage.Stage;

public class MGame extends Application
{
	public static void main(String[] args)
	{
		Engine game = new Engine("Character Controller", 1000, 800);
		new MainScene().activate();
		game.run();
	}

	public void start(Stage primaryStage) throws Exception 
	{
		
	}
}