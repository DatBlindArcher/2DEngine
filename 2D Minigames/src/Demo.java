import game.engine.*;

public class Demo 
{
	public static void main(String[] args)
	{
		Game game = new Game("Demo", 1000, 800);
		new TestScene().activate();
		game.run();
	}
}