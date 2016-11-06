package game.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

import org.w3c.dom.Node;

import game.engine.UI.UI;

public class Camera extends Component
{
	private BufferedImage imageBuffer;
	private Vector2 corner = new Vector2();
	
	public Camera() { }
	public Camera(Node xml)
	{
		
	}
	
	public void start() 
	{
		imageBuffer = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_RGB);
		Engine.instance.activeScene.cameras.put(gameObject.ID, this);
	}
	
	public void update()
	{
		corner = new Vector2(transform.position.x - Screen.width / 2f, transform.position.y - Screen.height / 2f);
	}
	
	public void draw(Engine game, Collection<GameObject> gameObjects)
	{
		java.util.List<Image> result = new ArrayList<Image>();
		java.util.List<UI> ui = new ArrayList<UI>();
		
		gameObjects.forEach(x -> 
		{
			Image img;
			
			if((img = x.getComponent(Image.class)) != null)
			{
				result.add(img);
			}
		});

		gameObjects.forEach(x -> 
		{
			UI element;
			
			if((element = x.getComponent(UI.class)) != null)
			{
				ui.add(element);
			}
		});
		
		result.sort(new LayerHandler());
		Graphics graphics = imageBuffer.getGraphics();
		
		// Background
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, Screen.width, Screen.height);
		graphics.setColor(Color.black);

		for(int i = 0; i < result.size(); i++)
		{
			result.get(i).draw(graphics, corner);
		}
		
		for(int i = 0; i < ui.size(); i++)
		{
			ui.get(i).draw(graphics, corner);
		}
		
		Renderer.graphics.drawImage(imageBuffer, 0, 0, Screen.width, Screen.height, game);
	}
}