package game.engine;

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Collider extends Component
{
	public Area area;
	
	public void collide()
	{
		for(int i = 0; i < Game.instance.activeScene.gameObjects.size(); i++)
		{
			Collider c;
			
			if((c = Game.instance.activeScene.gameObjects.get(i).getComponent(Collider.class)) != null)
			{
				if (c.gameObject == gameObject) continue;
				
				if (CheckInterSection(c))
				{
					onCollisionStart((Collider)c);
				}
			}
		}
	}
	
	private boolean CheckInterSection(Collider b)
	{
		AffineTransform af = new AffineTransform();
		af.rotate(Math.toRadians(gameObject.transform.rotation), gameObject.transform.position.x, 
				gameObject.transform.position.y);
		Area rotatedA = area.createTransformedArea(af);
		
		AffineTransform bf = new AffineTransform();
		bf.rotate(Math.toRadians(b.gameObject.transform.rotation), b.gameObject.transform.position.x, 
        		b.gameObject.transform.position.y);
		Area rotatedB = b.area.createTransformedArea(bf);
		
		rotatedA.intersect(rotatedB);
		return !rotatedA.isEmpty();
	}
	
	public void onCollisionStart(Collider col)
	{
		System.out.println(gameObject.name + " collided with " + col.gameObject.name);
	}
	
	public void onCollisionStay(Collider col)
	{
		
	}
	
	public void onCollisionStop(Collider col)
	{
		
	}
}