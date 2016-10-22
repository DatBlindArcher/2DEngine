package multiplayer.game;

import game.engine.*;

public class MainScene extends Scene
{
	public void activate()
	{
		super.activate();
		GameObject.create(new GameObject("Main Camera", new Component[] { new Camera(), new AudioListener() }), new Vector2(), 0f);
		GameObject.create(new GameObject("MainMenu", new Component[] { new MainMenu() }), new Vector2(), 0f);
	}
}