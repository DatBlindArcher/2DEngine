package game.engine;

import java.util.*;
import javafx.scene.input.KeyCode;

public class Input 
{
	static List<KeyCode> keys = new ArrayList<KeyCode>();
	static List<KeyCode> keysUp = new ArrayList<KeyCode>();
	static List<KeyCode> keysDown = new ArrayList<KeyCode>();
	
	public static boolean getKey(KeyCode key)
	{
		return keys.contains(key);
	}
	
	public static boolean getKeyUp(KeyCode key)
	{
		return keysUp.contains(key);
	}
	
	public static boolean getKeyDown(KeyCode key)
	{
		return keysDown.contains(key);
	}
}