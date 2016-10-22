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
	
	public static boolean button(Rect rect, String content)
	{
		if(Game.instance.getMousePosition() == null) return false;
		boolean hover = Math.abs(Game.instance.getMousePosition().x) > Math.abs(rect.x) &&
				Math.abs(Game.instance.getMousePosition().x) < Math.abs(rect.x + rect.width) &&
				Math.abs(Game.instance.getMousePosition().y) > Math.abs(rect.y + rect.height / 2f) &&
				Math.abs(Game.instance.getMousePosition().y) < Math.abs(rect.y + rect.height * 1.5f);
		setColor(hover ? new Color(150, 150, 150, 255) : new Color(200, 200, 200, 255));
		graphics.fillRect(rect.x, rect.y, rect.width, rect.height);
		setColor(Color.black);
		graphics.drawString(content, rect.x + rect.width / 2 - 10, rect.y + rect.height / 2);
		return hover && Input.getMouseButtonDown(0);
	}
}