package game.engine;
import java.util.*;

public class Scene 
{
	public List<Camera> cameras = new ArrayList<Camera>();
	public List<GameObject> gameObjects = new ArrayList<GameObject>();
	
	public void Draw(Game game)
	{
		for(Iterator<Camera> i = cameras.iterator(); i.hasNext();)
		{
			Camera cam = i.next();
			cam.draw(game, gameObjects.iterator());
		}
	}
}