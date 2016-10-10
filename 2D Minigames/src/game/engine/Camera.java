package game.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Camera extends Component
{
	private BufferedImage imageBuffer;
	
	public void start() 
	{
		imageBuffer = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_RGB);
		Game.instance.activeScene.cameras.add(this);
	}
	
	public void draw(Game game, List<GameObject> gameObjects)
	{
		Graphics graphics = imageBuffer.getGraphics();
		
		// Background
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, Screen.width, Screen.height);
		graphics.setColor(Color.black);

		for(int i = 0; i < gameObjects.size(); i++)
		{
			gameObjects.get(i).draw(graphics, gameObject.transform.position);
		}
		
		Renderer.graphics.drawImage(imageBuffer, (int)gameObject.transform.position.x, (int)gameObject.transform.position.y, Screen.width, Screen.height, game);
	}
}