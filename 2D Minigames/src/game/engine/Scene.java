package game.engine;

import java.util.*;
import java.util.concurrent.*;

import org.w3c.dom.*;

public class Scene 
{
	public long index = 0;
	public ConcurrentMap<Long, Camera> cameras = new ConcurrentHashMap<Long, Camera>();
	public ConcurrentMap<Long, GameObject> gameObjects = new ConcurrentHashMap<Long, GameObject>();
	
	public Scene() { }
	public Scene(Node scene)
	{
		NodeList xmlgameObject = scene.getChildNodes();
		
		for (int i = 0; i < xmlgameObject.getLength(); i++)
		{
			GameObject obj = new GameObject(xmlgameObject.item(i));
			obj.ID = index;
			gameObjects.put(++index, obj);
		}
	}
	
	public void draw(Game game)
	{
		List<GameObject> result = new ArrayList<GameObject>();
		result.addAll(gameObjects.values());
		result.addAll(Game.instance.ddolScene.gameObjects.values());
		cameras.values().forEach(x -> x.draw(game, result));
		Game.instance.ddolScene.cameras.values().forEach(x -> x.draw(game, result));

		gameObjects.values().forEach(x -> x.onGUI());
		Game.instance.ddolScene.gameObjects.values().forEach(x -> x.onGUI());
	}
	
	public void activate()
	{
		if (Game.instance.activeScene != null) Game.instance.activeScene.deActivate();
		Game.instance.activeScene = this;
	}
	
	public void deActivate()
	{
		gameObjects.values().forEach(x -> x.stop());
		gameObjects.clear();
	}
}