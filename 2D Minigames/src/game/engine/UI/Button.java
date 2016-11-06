package game.engine.UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import game.engine.Action;
import game.engine.Engine;
import game.engine.Image;
import game.engine.Input;
import game.engine.Rect;
import game.engine.Vector2;

public class Button extends UI
{
	public String content;
	public Rect rect;
	public boolean hover;
	public Action action;
	private BufferedImage background;
	
	public Button(Rect rect, String content, String path, Action action)
	{
		this.rect = rect;
		this.content = content;
		this.action = action;
		hover = false;
		
		if(Image.loadedImages.containsKey(path))
		{
			ImageIcon img = Image.loadedImages.get(path);
			background = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
			Graphics g = background.createGraphics();
			img.paintIcon(null, g, img.getIconWidth(), img.getIconHeight());
			g.dispose();
		}
		
		else
		{
			try 
			{
				ImageIcon img = new ImageIcon(new Object().getClass().getResource(path));
				background = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = background.createGraphics();
				img.paintIcon(null, g, 0, 0);
				g.dispose();
			} 
			
			catch (Exception e) 
			{
				System.out.println("Failed to load " + path + ": " + e.getMessage());
			}
		}
	}
	
	public void draw(Graphics g, Vector2 offset)
	{
		hover = Math.abs(Input.getMousePosition().x) > Math.abs(rect.x) &&
				Math.abs(Input.getMousePosition().x) < Math.abs(rect.x + rect.width) &&
				Math.abs(Input.getMousePosition().y) > Math.abs(rect.y) &&
				Math.abs(Input.getMousePosition().y) < Math.abs(rect.y + rect.height);
		Color color = hover ? new Color(150, 150, 150, 255) : new Color(200, 200, 200, 255);

		BufferedImage result = new BufferedImage(background.getWidth(), background.getHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
        Graphics2D img = (Graphics2D)result.getGraphics();
        img.drawImage(background, 0, 0, Engine.instance);
        img.setColor(color);
        img.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, (float)color.getAlpha() / 255f));
        img.fillRect(0, 0, background.getWidth(), background.getHeight());
		g.drawImage(result, rect.x, rect.y, rect.width, rect.height, Engine.instance);
		
		g.setColor(Color.black);
	    FontMetrics metrics = g.getFontMetrics();
	    int x = (rect.width - metrics.stringWidth(content)) / 2 + rect.x;
	    int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent() + rect.y;
		g.drawString(content, x, y);
		
		if(hover && Input.getMouseButtonDown(0))
		{
			trigger();
		}
	}
	
	public void trigger()
	{
		action.execute();
	}
}