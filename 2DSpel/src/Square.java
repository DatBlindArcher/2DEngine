import java.awt.event.KeyEvent;

public class Square extends GameObject
{
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
		transform.position.add(velocity);
		if(transform.position.x < 0f) transform.position.x = 0f;
		if(transform.position.x > Screen.width - 100) transform.position.x = Screen.width - 100;
		if(transform.position.y < 0f) transform.position.y = 0f;
		if(transform.position.y > Screen.height - 100) transform.position.y = Screen.height - 100;
	}
	
	public void draw()
	{
		super.draw();
		Renderer.label(new Rect(0, 110, 0, 0), "Position: " + transform.position.x + ", " + transform.position.y);
		Renderer.label(new Rect(0, 130, 0, 0), "Velocity: " + velocity.x + ", " + velocity.y);
		Renderer.graphics.drawRect((int)transform.position.x,(int)transform.position.y, 100, 100);
	}
}