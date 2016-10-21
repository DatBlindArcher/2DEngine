package game.engine;

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