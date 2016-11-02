package game.engine.Physics;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.util.*;

import game.engine.GameObject;
import game.engine.Vector2;
import game.engine.UI.GUI;

public class Physics
{
	public static List<Collider> colliders = new ArrayList<Collider>();
	
	public static RaycastHit[] raycast(Vector2 origin, Vector2 direction, float depth)
	{
		if(direction.equals(new Vector2(0f, 0f))) return new RaycastHit[0];
		Area line = new Area(new Rectangle((int)origin.x, (int)origin.y, (int)depth, 1).getBounds());
		List<RaycastHit> result = new ArrayList<RaycastHit>();
		float angle = direction.y < 0 ? -(float)Math.acos(direction.x) : (float)Math.acos(direction.x);
		
		AffineTransform ba = new AffineTransform();
		ba.rotate(angle, origin.x, origin.y);
		
		for(int i = 0; i < colliders.size(); i++)
		{
			Collider c = colliders.get(i);
			Area rotatedLine = line.createTransformedArea(ba);
			
			AffineTransform bf = new AffineTransform();
			bf.rotate(Math.toRadians(c.gameObject.transform.rotation), c.gameObject.transform.position.x, 
	        		c.gameObject.transform.position.y);
			Area rotatedB = c.area.createTransformedArea(bf);
			
			rotatedLine.intersect(rotatedB);
			
			if(!rotatedLine.isEmpty())
			{
				result.add(new RaycastHit(new Vector2((float)rotatedLine.getBounds2D().getX(), (float)rotatedLine.getBounds2D().getY()), c.gameObject));
			}
		}

		RaycastHit[] value = new RaycastHit[result.size()];
		result.toArray(value);
		return value;
	}
	
	public static RaycastHit[] areacast(GameObject obj, Area area)
	{
		List<RaycastHit> result = new ArrayList<RaycastHit>();
		
		for(int i = 0; i < colliders.size(); i++)
		{
			Collider c = colliders.get(i);
			if(obj == c.gameObject) continue;
			Area temp = (Area)area.clone();
			
			if(GUI.graphics != null)
			{
				GUI.setColor(Color.red);
				GUI.graphics.draw(temp);
			}
			
			AffineTransform bf = new AffineTransform();
			bf.rotate(Math.toRadians(c.gameObject.transform.rotation), c.gameObject.transform.position.x, 
	        		c.gameObject.transform.position.y);
			Area rotatedB = c.area.createTransformedArea(bf);
			
			temp.intersect(rotatedB);
			
			if(!temp.isEmpty())
			{
				result.add(new RaycastHit(new Vector2((float)temp.getBounds2D().getX(), (float)temp.getBounds2D().getY()), c.gameObject));
			}
		}

		RaycastHit[] value = new RaycastHit[result.size()];
		result.toArray(value);
		return value;
	}
}