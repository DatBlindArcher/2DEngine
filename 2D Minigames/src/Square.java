import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import game.engine.*;

public class Square extends GameObject
{
	public float speed = 1f;
	private Vector2 velocity;
	
	public Square(String objectName) 
	{
		super(objectName);
		transform.position = new Vector2(500 - 50, 400 - 50);
	}
	
	public void update()
	{
		super.update();
		velocity = new Vector2();
		
		if(Input.isKeyDown(KeyEvent.VK_RIGHT))
		{
			velocity.x++;
		}
		
		if(Input.isKeyDown(KeyEvent.VK_LEFT))
		{
			velocity.x--;
		}
		
		if(Input.isKeyDown(KeyEvent.VK_UP))
		{
			velocity.y--;
		}
		
		if(Input.isKeyDown(KeyEvent.VK_DOWN))
		{
			velocity.y++;
		}
		
		velocity.normalize();
		transform.position.add(velocity.multiply(speed * Time.deltaTime));
		if(transform.position.x < 0f) transform.position.x = 0f;
		if(transform.position.x > Screen.width - 50) transform.position.x = Screen.width - 50;
		if(transform.position.y < 0f) transform.position.y = 0f;
		if(transform.position.y > Screen.height - 50) transform.position.y = Screen.height - 50;
	}
	
	public void draw(Graphics g, Vector2 offset)
	{
		super.draw(g, offset);
		GUI.label(new Rect(0, 110, 0, 0), "Position: " + transform.position.x + ", " + transform.position.y);
		GUI.label(new Rect(0, 130, 0, 0), "Velocity: " + velocity.x + ", " + velocity.y);
		g.setColor(Color.red);
		g.fillRect((int)transform.position.x - (int)offset.x,(int)transform.position.y - (int)offset.y, 50, 50);
	}
}