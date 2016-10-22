package character.controller;

import java.awt.event.KeyEvent;

import game.engine.*;

public class Character extends CharacterController
{
	float speed = 200f;
	
	public void update()
	{
		Vector2 delta = new Vector2();
		
		if(Input.getKey(KeyEvent.VK_W))
		{
			delta.y--;
		}
		
		if(Input.getKey(KeyEvent.VK_S))
		{
			delta.y++;
		}
		
		if(Input.getKey(KeyEvent.VK_A))
		{
			delta.x--;
		}
		
		if(Input.getKey(KeyEvent.VK_D))
		{
			delta.x++;
		}
		
		super.move(delta.multiply(Time.deltaTime * speed));
	}
}