package game.engine;

import java.awt.Shape;
import java.awt.geom.*;

public class CircleCollider extends Collider 
{
	public void start()
	{
		super.start();
		Shape shape = new Ellipse2D.Float((int)gameObject.transform.position.x - (int)(gameObject.transform.scale.x * 16f),
				(int)gameObject.transform.position.y - (int)(gameObject.transform.scale.y * 16f),
				(int)(gameObject.transform.scale.x * 32f),
				(int)(gameObject.transform.scale.y * 32f));
		
		area = new Area(shape);
	}
	
	public void update()
	{
		super.update();
		Shape shape = new Ellipse2D.Float((int)gameObject.transform.position.x - (int)(gameObject.transform.scale.x * 16f),
				(int)gameObject.transform.position.y - (int)(gameObject.transform.scale.y * 16f),
				(int)(gameObject.transform.scale.x * 32f),
				(int)(gameObject.transform.scale.y * 32f));
		
		area = new Area(shape);
	}
}