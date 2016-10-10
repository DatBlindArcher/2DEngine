import java.awt.Color;

import game.engine.*;

public class TestScene extends Scene
{
	public void activate()
	{
		super.activate();
		GameObject.Create(new GameObject("Main Camera", new Component[] { new Camera() }), new Vector2(), 0f);
		GameObject player = new GameObject("Player", new Component[] { new Player(), new Image("Images/Square.png", new Color(0, 255, 0, 0)) });
		GameObject wall = new GameObject("Wall", new Component[] { new SquareCollider(), new Image("Images/Square.png", new Color(0, 255, 0, 0)) });
		GameObject apple = new GameObject("Apple", new Component[] { new Apple(), new Image("Images/Square.png", Color.magenta) });
		GameObject ball = new GameObject("Ball", new Component[] { new CircleCollider(), new Image("Images/Circle.png", new Color(0, 255, 0, 0)) });
		wall.transform.scale = new Vector2(50f / 32f, 50f / 32f);
		ball.transform.scale = new Vector2(3f, 3f);
		
		GameObject.Create(player, new Vector2(Screen.width / 2 , Screen.height / 2), 0f);
		GameObject.Create(wall, new Vector2(Screen.width / 2 - 150f, Screen.height / 2 - 150f), 0f);
		GameObject.Create(apple, new Vector2(Screen.width / 2 - 250f, Screen.height / 2 - 250f), 0f);
		GameObject.Create(ball, new Vector2(Screen.width / 2 + 250f, Screen.height / 2 - 250f), 0f);
	}
}