package character.controller;

import java.awt.event.KeyEvent;

import game.engine.*;

public class Character extends CharacterController
{
	float speed = 200f;
	
	public void update()
	{
		Vector2 delta = new Vector2();
		
		if(Input.getKey(KeyEvent.VK_W) || Input.getKey(KeyEvent.VK_UP))
		{
			delta.y--;
		}
		
		if(Input.getKey(KeyEvent.VK_S) || Input.getKey(KeyEvent.VK_DOWN))
		{
			delta.y++;
		}
		
		if(Input.getKey(KeyEvent.VK_A) || Input.getKey(KeyEvent.VK_LEFT))
		{
			delta.x--;
		}
		
		if(Input.getKey(KeyEvent.VK_D) || Input.getKey(KeyEvent.VK_RIGHT))
		{
			delta.x++;
		}
		
		super.move(delta.multiply(Time.deltaTime * speed));
	}
}