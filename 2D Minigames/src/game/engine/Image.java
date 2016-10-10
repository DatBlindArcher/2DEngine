package game.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image extends Component
{
	public String imagePath;
	public Color color;
	private BufferedImage image;
	
	public Image(String path, Color imageColor)
	{
		imagePath = path;
		color = imageColor;
	}
	
	public void start()
	{
		image = null;
		
		try 
		{
			image = ImageIO.read(new File("D:/Documents/GitHub/2DEngine/" + imagePath));
		} 
		
		catch (IOException e) 
		{
			System.out.println("Failed to load " + image + ": " + e.getMessage());
		}
	}
	
	public void draw(Graphics g, Vector2 offset)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		// Add color
        Graphics img = image.getGraphics();
		img.setColor(color);
		img.fillRect(0, 0, image.getWidth(), image.getHeight());
        AffineTransform translation = new AffineTransform();
        
        // Set center
        translation.translate(gameObject.transform.position.x - image.getWidth() / 2 * gameObject.transform.scale.x, 
        		gameObject.transform.position.y - image.getHeight() / 2 * gameObject.transform.scale.y);
        
        // Set rotation
        translation.rotate(Math.toRadians(gameObject.transform.rotation), image.getWidth() / 2 * gameObject.transform.scale.x, 
        		image.getHeight() / 2 * gameObject.transform.scale.y);
        
        // Set scale
        translation.scale(gameObject.transform.scale.x, gameObject.transform.scale.y);
        
		// Draw the image
        g2d.drawImage(image, translation, Game.instance);
	}
}