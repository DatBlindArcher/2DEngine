package Snake;

import game.engine.Game;

public class SnakeGame
{
	public static void main(String[] args) throws Exception
	{
		Game game = new Game("Snake", 1000, 800);
		new SnakeScene().activate();
		game.run();
	}
}