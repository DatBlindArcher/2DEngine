package game.engine;
import java.util.*;

public class Scene 
{
	public List<Camera> cameras = new ArrayList<Camera>();
	public List<GameObject> gameObjects = new ArrayList<GameObject>();
	
	public void activateScene(Scene ddol)
	{
		cameras.addAll(ddol.cameras);
		gameObjects.addAll(ddol.gameObjects);
	}
	
	public void draw(Game game)
	{
		for(int i = 0; i < cameras.size(); i++)
		{
			cameras.get(i).draw(game, gameObjects);
		}
		
		for(int i = 0; i < gameObjects.size(); i++)
		{
			gameObjects.get(i).onGUI();
		}
	}
	
	public void activate()
	{
		Game.instance.activeScene = this;
	}
}