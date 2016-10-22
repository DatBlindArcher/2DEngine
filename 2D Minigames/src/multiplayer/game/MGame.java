package multiplayer.game;

import game.engine.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class MGame extends Application
{
	public static void main(String[] args)
	{
		Game game = new Game("Character Controller", 1000, 800);
		new MainScene().activate();
		game.run();
	}

	public void start(Stage primaryStage) throws Exception 
	{
		
	}
}