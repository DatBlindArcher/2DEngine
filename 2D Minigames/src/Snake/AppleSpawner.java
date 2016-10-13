package Snake;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import game.engine.*;

public class AppleSpawner extends Component
{
	public void update()
	{
		super.update();
		
		if(Input.getKeyDown(KeyEvent.VK_J))
		{
			Random r = new Random();
			GameObject apple = new GameObject("Apple", "Apple", new Component[] { new Apple(), new Image("Images/Square.png", 0, Color.red) });
			GameObject.create(apple, new Vector2(r.nextInt(1000/40) * 40 + 20f, r.nextInt(800 / 40) * 40), 0f);
		}
	}
}