package game.engine;

import java.awt.Color;
import java.awt.Graphics2D;

public class GUI 
{
	public static Graphics2D graphics;
	
	public static void setColor(Color color)
	{
		graphics.setColor(color);
	}
	
	public static void label(Rect rect, String content)
	{
		graphics.drawString(content, rect.x, rect.y);
	}
	
	public static void textArea(Rect rect, String content)
	{
		graphics.drawRect(rect.x, rect.y, rect.width, rect.height);
		graphics.drawString(content, rect.x, rect.y);
	}
}