import game.engine.*;

public class Demo 
{
	public static void main(String[] args)
	{
		Game game = new Game("2D Spel", 1000, 800);
		new TestScene().activate();
		game.run();
	}
}