package snake;

import java.awt.Color;
import java.util.Random;

import org.w3c.dom.Node;

import game.engine.*;
import game.engine.Physics.Collider;
import game.engine.Physics.SquareCollider;

public class Apple extends SquareCollider
{
	public Apple() { }
	public Apple(Node xml)
	{
		super(xml);
	}
	
	public void update()
	{
		collide();
	}
	
	public void onCollisionStart(Collider col)
	{
		super.onCollisionStart(col);
		Random r = new Random();
		GameObject apple = new GameObject("Apple", "Apple", new Component[] { new Apple(), new Image("/Images/Square.png", 0, Color.red) });
		GameObject.create(apple, new Vector2(r.nextInt(1000/40 - 2) * 40 + 40f, r.nextInt(800 / 40 - 2) * 40 + 40f), 0f);
		GameObject.destroy(gameObject);
	}
}