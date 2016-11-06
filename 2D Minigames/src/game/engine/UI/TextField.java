package game.engine.UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import game.engine.*;
import game.engine.Image;

public class TextField extends UI
{
	public Rect rect;
	public boolean editable;
	public boolean hover;
	public String content;
	public String placeholder;
	private BufferedImage background;
	
	public TextField(Rect rect, boolean editable, String content, String placeholder, String path)
	{
		this.rect = rect;
		this.editable = editable;
		this.content = content;
		this.placeholder = placeholder;
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
		
		if(Input.getMouseButtonDown(0) && editable)
		{
			if(hover)
			{
				selected = true;
				Input.textfield = this;
			}
			
			else if (selected)
			{
				selected = false;
				Input.textfield = null;
			}
		}

		Color color = Color.darkGray;
		BufferedImage result = new BufferedImage(background.getWidth(), background.getHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
        Graphics2D img = (Graphics2D)result.getGraphics();
        img.drawImage(background, 0, 0, Engine.instance);
        img.setColor(color);
        img.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, (float)color.getAlpha() / 255f));
        img.fillRect(0, 0, background.getWidth(), background.getHeight());
		g.drawImage(result, rect.x, rect.y, rect.width, rect.height, Engine.instance);
		
		String actualcontent = content.length() > 0 ? content : placeholder;
		g.setColor(Color.white);
	    FontMetrics metrics = g.getFontMetrics();
	    int x = (rect.width - metrics.stringWidth(actualcontent)) / 2 + rect.x;
	    int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent() + rect.y;
		g.drawString(actualcontent, x, y);
	}
}