package snake;

import org.w3c.dom.Node;

import game.engine.*;
import game.engine.Physics.SquareCollider;

public class SnakeSegment extends SquareCollider
{
	public SnakeSegment child;

	public SnakeSegment() { }
	public SnakeSegment(Node xml)
	{
		super(xml);
	}
	
	public void move(Vector2 currentPos)
	{
		Vector2 lastPos = gameObject.transform.position.copy();
		gameObject.transform.position = currentPos;
		if(child != null) child.move(lastPos);
	}
}
