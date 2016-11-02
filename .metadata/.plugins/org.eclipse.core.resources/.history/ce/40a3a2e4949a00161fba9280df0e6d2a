package game.engine;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.*;

import javax.swing.ImageIcon;

public class Image extends Component
{
	public String imagePath;
	public Color color;
	public int layer;
	public BufferedImage image;
	public static Map<String, ImageIcon> loadedImages = new HashMap<String, ImageIcon>();
	
	private int width;
	private int height;
	private int frameIndex;

	public Image(String path, int depthLayer, Color imageColor)
	{
		this(path, depthLayer, imageColor, 0, 0, 0);
	}
	
	public Image(String path, int depthLayer, Color imageColor, int width, int height, int frameIndex)
	{
		imagePath = path;
		layer = depthLayer;
		color = imageColor;
		this.width = width;
		this.height = height;
		this.frameIndex = frameIndex;
	}
	
	public void changeImage(String path, int depthLayer, Color imageColor, int width, int height, int frameIndex)
	{
		imagePath = path;
		layer = depthLayer;
		color = imageColor;
		this.width = width;
		this.height = height;
		this.frameIndex = frameIndex;
		image = null;
	
		if(loadedImages.containsKey(imagePath))
		{
			ImageIcon img = Image.loadedImages.get(imagePath);
			width = width == 0 ? img.getIconWidth() : width;
			height = height == 0 ? img.getIconHeight() : height;
			int column = (int)Math.floor(img.getIconWidth() / width);
			
			int x = frameIndex % column;
			int y = (int)Math.floor(frameIndex / column);
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
			Graphics g = image.createGraphics();
			img.paintIcon(null, g, x * width, y * height);
			g.dispose();
		}
		
		else
		{
			try 
			{
				ImageIcon img = new ImageIcon(getClass().getResource(imagePath));
				width = width == 0 ? img.getIconWidth() : width;
				height = height == 0 ? img.getIconHeight() : height;
				int column = (int)Math.floor(img.getIconWidth() / width);
				
				int x = frameIndex % column;
				int y = (int)Math.floor(frameIndex / column);
				image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = image.createGraphics();
				img.paintIcon(null, g, - x * width, - y * height);
				g.dispose();
			} 
			
			catch (Exception e) 
			{
				System.out.println("Failed to load " + imagePath + ": " + e.getMessage());
			}
		}
	}
	
	public void start()
	{
		image = null;
		
		if(loadedImages.containsKey(imagePath))
		{
			ImageIcon img = Image.loadedImages.get(imagePath);
			width = width == 0 ? img.getIconWidth() : width;
			height = height == 0 ? img.getIconHeight() : height;
			int column = (int)Math.floor(img.getIconWidth() / width);
			
			int x = frameIndex % column;
			int y = (int)Math.floor(frameIndex / column);
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
			Graphics g = image.createGraphics();
			img.paintIcon(null, g, x * width, y * height);
			g.dispose();
		}
		
		else
		{
			try 
			{
				ImageIcon img = new ImageIcon(getClass().getResource(imagePath));
				width = width == 0 ? img.getIconWidth() : width;
				height = height == 0 ? img.getIconHeight() : height;
				int column = (int)Math.floor(img.getIconWidth() / width);
				
				int x = frameIndex % column;
				int y = (int)Math.floor(frameIndex / column);
				image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = image.createGraphics();
				img.paintIcon(null, g, - x * width, - y * height);
				g.dispose();
			} 
			
			catch (Exception e) 
			{
				System.out.println("Failed to load " + imagePath + ": " + e.getMessage());
			}
		}
	}
	
	public void draw(Graphics g, Vector2 offset)
	{
		if (image == null) return;
		Graphics2D g2d = (Graphics2D)g;
		BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
        AffineTransform translation = new AffineTransform();

		// Add color
        Graphics2D img = (Graphics2D)result.getGraphics();
        img.drawImage(image, 0, 0, Game.instance);
        img.setColor(color);
        img.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, (float)color.getAlpha() / 255f));
        img.fillRect(0, 0, image.getWidth(), image.getHeight());
		
        // Set center
        translation.translate(gameObject.transform.position.x - image.getWidth() / 2 * gameObject.transform.scale.x, 
        		gameObject.transform.position.y - image.getHeight() / 2 * gameObject.transform.scale.y);
        
        // Set rotation
        translation.rotate(Math.toRadians(gameObject.transform.rotation), image.getWidth() / 2 * gameObject.transform.scale.x, 
        		image.getHeight() / 2 * gameObject.transform.scale.y);
        
        // Set scale
        translation.scale(gameObject.transform.scale.x, gameObject.transform.scale.y);
        
		// Draw the image
        g2d.drawImage(result, translation, Game.instance);
	}
}