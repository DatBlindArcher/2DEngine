package character.controller;

import game.engine.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class CGame extends Application
{
	public static void main(String[] args)
	{
		Game game = new Game("Character Controller", 1000, 800);
		new CharacterScene().activate();
		game.run();
	}

	public void start(Stage primaryStage) throws Exception 
	{
		
	}
}