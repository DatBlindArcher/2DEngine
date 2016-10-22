package game.engine;
import java.awt.Component; 
import java.awt.event.*; 

public class Input implements KeyListener, MouseListener 
{
	private static boolean[] keys;
	private static boolean[] keysUp;
	private static boolean[] keysDown;
	private static boolean[] keysUpBuffer;
	private static boolean[] keysDownBuffer;
	private static boolean[] mouseButtons;
	private static boolean[] mouseUp;
	private static boolean[] mouseDown;
	private static boolean[] mouseUpBuffer;
	private static boolean[] mouseDownBuffer;
	
    public Input(Component c) 
    { 
            c.addKeyListener(this);
            c.addMouseListener(this);
            keys = new boolean[256];
            keysUp = new boolean[256];
            keysDown = new boolean[256];
            keysUpBuffer = new boolean[256];
            keysDownBuffer = new boolean[256];
            mouseButtons = new boolean[10];
            mouseUp = new boolean[10];
            mouseDown = new boolean[10];
            mouseUpBuffer = new boolean[10];
            mouseDownBuffer = new boolean[10];
    }
    
    public void update()
    {
    	keysUp = keysUpBuffer;
    	keysDown = keysDownBuffer;
    	keysUpBuffer = new boolean[255];
    	keysDownBuffer = new boolean[255];
    	mouseUp = mouseUpBuffer;
    	mouseDown = mouseDownBuffer;
    	mouseUpBuffer = new boolean[10];
    	mouseDownBuffer = new boolean[10];
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
    
    public static boolean getMouseButton(int button)
    {
    	return mouseButtons[button];
    }
    
    public static boolean getMouseButtonUp(int button)
    {
    	return mouseUp[button];
    }
    
    public static boolean getMouseButtonDown(int button)
    {
    	return mouseDown[button];
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

	public void keyTyped(KeyEvent e) { }

	public void mousePressed(MouseEvent e) 
	{
        if (!mouseButtons[e.getButton() - 1]) mouseDownBuffer[e.getButton() - 1] = true;
		mouseButtons[e.getButton() - 1] = true;
	}

	public void mouseReleased(MouseEvent e) 
	{
		mouseButtons[e.getButton() - 1] = false;
        mouseUpBuffer[e.getButton() - 1] = true;
	}

	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
} 