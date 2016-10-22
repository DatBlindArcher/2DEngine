package character.controller;

import java.util.Random;

import game.engine.*;

public class AI extends CharacterController
{
	float speed = 200f;
	float t = 0f;
	Vector2 delta;
	
	public void update()
	{
		if(t <= 0f)
		{
			t = 1.5f;
			Random r = new Random();
			int x = r.nextInt(3) - 1;
			int y = r.nextInt(3) - 1;
			delta = new Vector2(x, y).normalized();
		}
		
		else
		{
			t -= Time.deltaTime;
		}
		
		super.move(delta.multiply(Time.deltaTime * speed));
	}
}