package game.engine.Physics;

import game.engine.GameObject;
import game.engine.Vector2;

public class RaycastHit 
{
	public Vector2 point;
	public GameObject gameObject;
	
	public RaycastHit(Vector2 point, GameObject gameObject)
	{
		this.point = point;
		this.gameObject = gameObject;
	}
}