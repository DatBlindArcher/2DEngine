package snake;

import game.engine.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeGame extends Application
{
	public static void main(String[] args)
	{
		Game game = new Game("Snake", 1000, 800);
		new SnakeScene().activate();
		game.run();
	}

	public void start(Stage primaryStage) throws Exception 
	{
		
	}
}