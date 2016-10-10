package game.engine;
import java.awt.Component; 
import java.awt.event.*; 

public class Input implements KeyListener 
{
	private static boolean[] keys;
	
    public Input(Component c) 
    { 
            c.addKeyListener(this);
            keys = new boolean[256];
    } 
    
    public static boolean isKeyDown(int keyCode) 
    {
    	return keys[keyCode]; 
    } 
    
    public void keyPressed(KeyEvent e) 
    { 
        keys[e.getKeyCode()] = true;
    } 

    public void keyReleased(KeyEvent e) 
    {
        keys[e.getKeyCode()] = false; 
    }

	public void keyTyped(KeyEvent e) { }
} 