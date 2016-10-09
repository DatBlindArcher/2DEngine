import game.engine.*;

public class TestScene extends Scene
{
	public TestScene()
	{
		cameras.add(new Camera("Main Camera"));
		gameObjects.add(new Square("Square"));
	}
}