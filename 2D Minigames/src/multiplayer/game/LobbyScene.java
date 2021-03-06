package multiplayer.game;

import game.engine.*;
import game.engine.UI.Button;
import game.engine.UI.TextField;

public class LobbyScene extends Scene
{
	public void activate()
	{
		super.activate();
		GameObject.create(new GameObject("Main Camera", new Component[] { new Camera(), new AudioListener() }), new Vector2(), 0f);
		GameObject.create(new GameObject("Textfield Title", new Component[] { new TextField(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 125, 200, 50), false, "Lobby Menu", "", "/Images/Square.png") }), new Vector2(), 0f);
		GameObject.create(new GameObject("Button Create Lobby", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 75, 200, 50), "Create Lobby", "/Images/Square.png", () -> new LobbyCreateScene().activate() ) }), new Vector2(), 0f);
		GameObject.create(new GameObject("Button Join Lobby", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 25, 200, 50), "Join Lobby", "/Images/Square.png", () -> SteamManager.instance.matchmaking.requestLobbyList() ) }), new Vector2(), 0f);
		GameObject.create(new GameObject("Button Back", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 + 25, 200, 50), "Back", "/Images/Square.png", () -> new MainScene().activate()) }), new Vector2(), 0f);
	}
}