package snake;

import java.awt.Color;
import java.util.Random;

import game.engine.*;

public class SnakeScene extends Scene
{
	public void activate()
	{
		super.activate();
		GameObject.create(new GameObject("Music", new Component[] { /*new AudioSource("Sounds/Music.mp3")*/ }), new Vector2(0, 0), 0f);
		GameObject.create(new GameObject("Main Camera", new Component[] { new Camera(), new AudioListener() }), new Vector2(), 0f);
		GameObject.create(new GameObject("Snake", "Snake", new Component[] { new Snake(), new Image("/Images/Square.png", 10, new Color(0, 200, 20, 255)) }), new Vector2(Screen.width / 2 - 20f, Screen.height / 2), 0f);
		GameObject wall1 = new GameObject("Wall", new Component[] { new SquareCollider(), new Image("/Images/Square.png", -10, new Color(0, 0, 0, 255)) });
		wall1.transform.scale = new Vector2(Screen.width / 32f, 1f);
		
		GameObject wall2 = new GameObject("Wall", new Component[] { new SquareCollider(), new Image("/Images/Square.png", -10, new Color(0, 0, 0, 255)) });
		wall2.transform.scale = new Vector2(Screen.width / 32f, 1f);
		
		GameObject wall3 = new GameObject("Wall", new Component[] { new SquareCollider(), new Image("/Images/Square.png", -10, new Color(0, 0, 0, 255)) });
		wall3.transform.scale = new Vector2(1f, Screen.height / 32f);
		
		GameObject wall4 = new GameObject("Wall", new Component[] { new SquareCollider(), new Image("/Images/Square.png", -10, new Color(0, 0, 0, 255)) });
		wall4.transform.scale = new Vector2(1f, Screen.height / 32f);
		GameObject.create(wall1, new Vector2(Screen.width / 2f, 0f), 0f);
		GameObject.create(wall2, new Vector2(Screen.width / 2f, Screen.height), 0f);
		GameObject.create(wall3, new Vector2(0f, Screen.height / 2f), 0f);
		GameObject.create(wall4, new Vector2(Screen.width, Screen.height / 2f), 0f);
		
		Random r = new Random();
		GameObject apple = new GameObject("Apple", "Apple", new Component[] { new Apple(), new Image("/Images/Square.png", 0, Color.red) });;
		GameObject.create(apple, new Vector2(r.nextInt(1000/40 - 2) * 40 + 40f, r.nextInt(800 / 40 - 2) * 40 + 40f), 0f);
	}
}