package game.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;

public class Camera extends GameObject
{
	private BufferedImage imageBuffer;
	
	public Camera(String objectName) 
	{
		super(objectName);
		imageBuffer = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void draw(Game game, Iterator<GameObject> gameObjects)
	{
		Graphics graphics = imageBuffer.getGraphics();
		
		// Background
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, Screen.width, Screen.height);
		graphics.setColor(Color.black);

		for(Iterator<GameObject> i = gameObjects; i.hasNext();)
		{
			i.next().draw(graphics, transform.position);
		}
		
		Renderer.graphics.drawImage(imageBuffer, (int)transform.position.x, (int)transform.position.y, Screen.width, Screen.height, game);
	}
}