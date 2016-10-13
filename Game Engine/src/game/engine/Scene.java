package game.engine;

import java.util.*;
import javafx.scene.*;

public class Scene extends javafx.scene.Scene
{
	List<GameObject> gameObjects;
	private Dictionary<Camera, SubScene> views;
	
	public Scene() 
	{
		super(Game.root, Screen.width, Screen.height, true, null);
		gameObjects = new ArrayList<GameObject>();
		views = new Hashtable<Camera, SubScene>();
	}
	
	public void dispose()
	{
		List<Transform> transforms = new ArrayList<Transform>();
		
		for(GameObject obj : gameObjects)
		{
			transforms.add(obj.transform);
		}
		
		Game.root.getChildren().removeAll(transforms);
		gameObjects.clear();
	}
	
	public GameObject[] getGameObjects()
	{
		return (GameObject[])gameObjects.toArray();
	}
	
	public void addCamera(Camera cam)
	{
		SubScene camScene = new SubScene(Game.root, Screen.width, Screen.height, true, null);
		camScene.setCamera(cam.camera);
		views.put(cam, camScene);
	}
	
	public void removeCamera(Camera cam)
	{
		views.remove(cam);
	}
	
	public void testRoot(Node node)
	{
		Game.root.getChildren().add(node);
	}
	
	public void addGameObject(GameObject gameObject)
	{
		Game.root.getChildren().add(gameObject.transform);
		gameObjects.add(gameObject);
		gameObject.start();
	}
}