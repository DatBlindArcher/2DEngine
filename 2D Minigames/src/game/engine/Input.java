package game.engine;
import java.awt.Component; 
import java.awt.event.*; 

public class Input implements KeyListener 
{
	private static boolean[] keys;
	private static boolean[] keysUp;
	private static boolean[] keysDown;
	private static boolean[] keysUpBuffer;
	private static boolean[] keysDownBuffer;
	
    public Input(Component c) 
    { 
            c.addKeyListener(this);
            keys = new boolean[256];
            keysUp = new boolean[256];
            keysDown = new boolean[256];
            keysUpBuffer = new boolean[256];
            keysDownBuffer = new boolean[256];
    }
    
    public static boolean getKey(int keyCode) 
    {
    	return keys[keyCode]; 
    } 

    public static boolean getKeyUp(int keyCode) 
    {
    	return keysUp[keyCode]; 
    } 
    
    public static boolean getKeyDown(int keyCode) 
    {
    	return keysDown[keyCode]; 
    } 
    
    public void keyPressed(KeyEvent e) 
    { 
        if (!keys[e.getKeyCode()]) keysDownBuffer[e.getKeyCode()] = true;
        keys[e.getKeyCode()] = true;
    } 

    public void keyReleased(KeyEvent e) 
    {
        keys[e.getKeyCode()] = false; 
        keysUpBuffer[e.getKeyCode()] = true;
    }
    
    public void update()
    {
    	keysUp = keysUpBuffer;
    	keysDown = keysDownBuffer;
    	keysUpBuffer = new boolean[255];
    	keysDownBuffer = new boolean[255];
    }

	public void keyTyped(KeyEvent e) { }
} 