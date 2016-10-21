package game.engine;

import java.awt.event.KeyEvent;

public class CharacterController extends Component
{
	private float speed = 200f;
	private float x = 0;
	private float y = 0;
	
	public void update()
	{
		x = 0;
		y = 0;
		
		if(Input.getKey(KeyEvent.VK_UP) && checkWall(new Vector2(0f, -1f), Time.deltaTime * speed))
		{
			y--;
		}
		
		if(Input.getKey(KeyEvent.VK_DOWN) && checkWall(new Vector2(0f, 1f), Time.deltaTime * speed))
		{
			y++;
		}
		
		if(Input.getKey(KeyEvent.VK_LEFT) && checkWall(new Vector2(-1f, 0f), Time.deltaTime * speed))
		{
			x--;
		}
		
		if(Input.getKey(KeyEvent.VK_RIGHT) && checkWall(new Vector2(1f, 0f), Time.deltaTime * speed))
		{
			x++;
		}

		Vector2 direction = new Vector2(x, y).normalized().multiply(Time.deltaTime * speed);
		transform.position.add(direction);
	}
	
	public void onGUI()
	{
		super.onGUI();
		checkWall(new Vector2(0f, y), Time.deltaFixedTime * speed);
		checkWall(new Vector2(x, 0f), Time.deltaFixedTime * speed);
	}
	
	private boolean checkWall(Vector2 direction, float t)
	{
		Vector2 inverse = new Vector2(direction.y, direction.x);
		Vector2 inverse2 = inverse.multiply(-1f).multiply(14f);
		inverse = inverse.multiply(15f);
		inverse.add(transform.position);
		inverse2.add(transform.position);
		
		if(direction.y > 0)
		{
			inverse.x -= 1;
			inverse2.x -= 1;
		}
		
		return Physics.raycast(transform.position, direction, 17f + t).length == 0 &&
				Physics.raycast(inverse, direction, 17f + t).length == 0 &&
				Physics.raycast(inverse2, direction, 17f + t).length == 0;
	}
}