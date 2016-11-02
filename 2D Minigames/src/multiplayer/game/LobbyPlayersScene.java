package multiplayer.game;

import game.engine.*;
import game.engine.UI.Button;
import game.engine.UI.TextField;

public class LobbyPlayersScene extends Scene
{
	public void activate()
	{
		super.activate();
		GameObject.create(new GameObject("Main Camera", new Component[] { new Camera(), new AudioListener() }), new Vector2(), 0f);
		GameObject.create(new GameObject("Textfield Title", new Component[] { new TextField(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 125, 200, 50), false, "Lobby", "", "/Images/Square.png") }), new Vector2(), 0f);
		GameObject.create(new GameObject("Button Start", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 75, 200, 50), "Start Game", "/Images/Square.png", () -> SteamManager.instance.startGame()) }), new Vector2(), 0f);
		GameObject.create(new GameObject("Button Back", new Component[] { new Button(new Rect(Screen.width / 2 - 100, Screen.height / 2 - 25, 200, 50), "Leave", "/Images/Square.png", () -> { SteamManager.instance.matchmaking.leaveLobby(SteamManager.instance.lobby.ID); SteamManager.instance.lobby = null; new LobbyScene().activate(); }) }), new Vector2(), 0f);
	}
}