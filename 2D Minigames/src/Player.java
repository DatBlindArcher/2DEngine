import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import game.engine.*;

public class Player extends SquareCollider
{
	public float speed = 0.5f;
	private Vector2 velocity;
	
	public void start() 
	{
		super.start();
		gameObject.transform.scale = new Vector2(50f / 32f, 50f / 32f);
	}
	
	public void update()
	{
		super.update();
		velocity = new Vector2();
		
		if(Input.getKeyDown(KeyEvent.VK_B))
		{
			Random r = new Random();
			gameObject.getComponent(Image.class).color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), 255);
		}

		if(Input.getKeyDown(KeyEvent.VK_S))
		{
			Random r = new Random();
			GameObject apple = new GameObject("Apple", new Component[] { new Apple(), new Image("Images/Square.png", Color.magenta) });
			GameObject.Create(apple, new Vector2(r.nextInt(950), r.nextInt(750)), 0f);
		}
		if(Input.getKey(KeyEvent.VK_Q))
		{
			gameObject.transform.rotation--;
		}
		
		if(Input.getKey(KeyEvent.VK_E))
		{
			gameObject.transform.rotation++;
		}
		
		if(Input.getKey(KeyEvent.VK_RIGHT))
		{
			velocity.x++;
		}
		
		if(Input.getKey(KeyEvent.VK_LEFT))
		{
			velocity.x--;
		}
		
		if(Input.getKey(KeyEvent.VK_UP))
		{
			velocity.y--;
		}
		
		if(Input.getKey(KeyEvent.VK_DOWN))
		{
			velocity.y++;
		}
		
		velocity.normalize();
		gameObject.transform.position.add(velocity.multiply(speed * Time.deltaTime));
		if(gameObject.transform.position.x < 0f) gameObject.transform.position.x = 0f;
		if(gameObject.transform.position.x > Screen.width) gameObject.transform.position.x = Screen.width;
		if(gameObject.transform.position.y < 0f) gameObject.transform.position.y = 0f;
		if(gameObject.transform.position.y > Screen.height) gameObject.transform.position.y = Screen.height;
	}
	
	public void onGUI()
	{
		super.onGUI();
		GUI.label(new Rect(0, 110, 0, 0), "Position: " + gameObject.transform.position.x + ", " + gameObject.transform.position.y);
		GUI.label(new Rect(0, 130, 0, 0), "Velocity: " + velocity.x + ", " + velocity.y);
	}
	
	public void onCollisionStart(Collider col)
	{
		super.onCollisionStart(col);
		
		if(col.gameObject.name == "Apple")
			System.out.println("You got the apple.");
	}
}