package game.engine;

public class Component 
{
	public GameObject gameObject;
	public Transform transform;
	public boolean enabled;
	
	public void start() { }
	public void stop() { }
	public void update() { }
	public void fixedUpdate() { }
	public void onGUI() { }
	
	public static void destroy(GameObject gameObject) 
	{
		
	}
	
	public static void create(GameObject gameObject, Vector3 position, float rotation) 
	{
		
	}
	
	public static void dontDestroyOnLoad(GameObject gameObject) 
	{
		
	}
}