package multiplayer.game;

import character.controller.CharacterScene;
import game.engine.*;

public class MainMenu extends Component
{
	public void onGUI()
	{
		if(GUI.button(new Rect(Screen.width / 2 - 50, Screen.height / 2 - 75, 100, 50), "Start"))
		{
			new CharacterScene().activate();
		}
		
		if(GUI.button(new Rect(Screen.width / 2 - 50, Screen.height / 2 + 25, 100, 50), "Stop"))
		{
			Game.instance.isRunning = false;
		}
	}
}