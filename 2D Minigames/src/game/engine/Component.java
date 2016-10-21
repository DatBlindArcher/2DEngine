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
	public void collide() { }
}