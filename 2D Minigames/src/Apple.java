import game.engine.*;

public class Apple extends SquareCollider
{
	public void onCollisionStart(Collider col)
	{
		super.onCollisionStart(col);
		GameObject.Destroy(gameObject);
	}
}