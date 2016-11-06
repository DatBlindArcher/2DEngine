import game.engine.*;
import game.engine.UI.Button;
import game.engine.UI.TextField;

public class MinigamesScene extends Scene
{
	public Game[] games;
	
	public void activate()
	{
		super.activate();
		GameObject.create(new GameObject("Main Camera", new Component[] { new Camera(), new AudioListener() }), new Vector2(), 0f);
		GameObject.create(new GameObject("Mini Games", new Component[] { new TextField(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 125, 200, 50), false, "Mini Games", "", "/Images/Square.png") }), new Vector2(), 0f);
		GameObject.create(new GameObject("Back", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 75, 200, 50), "Back", "/Images/Square.png", () -> new MainScene().activate()) }), new Vector2(), 0f);
		
		for(int i = 0; i < games.length; i++)
		{
			Game game = games[i];
			GameObject.create(new GameObject(game.name, new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 25 + 50 * i, 200, 50), "Create Lobby", game.texturePath, () -> game.scenes[0].activate() ) }), new Vector2(), 0f);
		}
	}
}