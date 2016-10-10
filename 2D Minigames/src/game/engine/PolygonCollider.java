package game.engine;

import java.awt.geom.Area;
import java.awt.geom.GeneralPath;;

public class PolygonCollider extends Collider
{
	public PolygonVertice[] vertices;
	
	public PolygonCollider(PolygonVertice[] polygon)
	{
		vertices = polygon;
	}
	
	public void start()
	{
		super.start();
		GeneralPath shape = new GeneralPath();
		shape.moveTo(vertices[0].start.x, vertices[1].start.y);
		
		for(int i = 1; i < vertices.length; i++)
		{
			if(vertices[i].curve)
				shape.curveTo(vertices[i].start.x, vertices[i].start.y, 
						vertices[i].middle.x, vertices[i].middle.y, 
						vertices[i].end.x, vertices[i].end.y);
			else
				shape.lineTo(vertices[i].start.x, vertices[i].start.y);
		}
		
		shape.closePath();
		area = new Area(shape);
	}
	
	public void update()
	{
		super.update();
		GeneralPath shape = new GeneralPath();
		shape.moveTo(vertices[0].start.x, vertices[1].start.y);
		
		for(int i = 1; i < vertices.length; i++)
		{
			if(vertices[i].curve)
				shape.curveTo(vertices[i].start.x, vertices[i].start.y, 
						vertices[i].middle.x, vertices[i].middle.y, 
						vertices[i].end.x, vertices[i].end.y);
			else
				shape.lineTo(vertices[i].start.x, vertices[i].start.y);
		}
		
		shape.closePath();
		area = new Area(shape);
	}
}