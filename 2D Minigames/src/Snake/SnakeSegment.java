package snake;

import game.engine.*;

public class SnakeSegment extends SquareCollider
{
	public SnakeSegment child;
	
	public void move(Vector2 currentPos)
	{
		Vector2 lastPos = gameObject.transform.position.copy();
		gameObject.transform.position = currentPos;
		if(child != null) child.move(lastPos);
	}
}
