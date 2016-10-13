import game.engine.Game;

public class Demo 
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.run(args, "Demo", 1000, 800);
	}
}