import game.engine.*;
import game.engine.UI.*;

public class MainScene extends Scene
{
	public void activate()
	{
		super.activate();
		GameObject.create(new GameObject("Main Camera", new Component[] { new Camera(), new AudioListener() }), new Vector2(), 0f);
		GameObject.create(new GameObject("Main Menu", new Component[] { new TextField(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 125, 200, 50), false, "Main Menu", "", "/Images/Square.png") }), new Vector2(), 0f);
		GameObject.create(new GameObject("Quick Play", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 75, 200, 50), "Quick Play", "/Images/Square.png", () -> new MinigamesScene().activate() ) }), new Vector2(), 0f);
		GameObject.create(new GameObject("Tournament", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 25, 200, 50), "Tournament", "/Images/Square.png", () -> new GroupsScene().activate() ) }), new Vector2(), 0f);
		GameObject.create(new GameObject("Quit", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 + 25, 200, 50), "Quit", "/Images/Square.png", () -> Engine.instance.isRunning = false) }), new Vector2(), 0f);
	}
}