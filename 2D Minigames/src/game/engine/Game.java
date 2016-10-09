package game.engine;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import javax.swing.*;

import game.engine.Renderer;

public class Game extends JFrame
{
	private Scene activeScene;
	private List<Scene> scenes = new ArrayList<Scene>();

	private long startTime;
	private boolean isRunning = true;
	private static final long serialVersionUID = 1L;
	private String title;
	private BufferedImage guiBuffer;
	private BufferedImage screenBuffer;
	public Insets insets;

	public Game(String title, int width, int height)
	{
		this.title = title;
		Screen.width = width;
		Screen.height = height;
	}

	public void run()
	{
		initialize();
		runFixedUpdate();
		runUpdate();
		setVisible(false);
	}

	public void runUpdate()
	{
		while(isRunning) 
		{
			long time = System.currentTimeMillis();
			Time.time = time - startTime;

			update();
			draw();

			Time.deltaTime = System.currentTimeMillis() - time;
		}
	}

	void runFixedUpdate()
	{
		Thread loop = new Thread()
		{
			public void run()
			{
				while(isRunning) 
				{
					long time = System.currentTimeMillis();
					Time.fixedTime = time - startTime;

					fixedUpdate();

					long delta = System.currentTimeMillis() - time;

					try
					{
						Thread.sleep(20 - delta);
						Time.deltaFixedTime = System.currentTimeMillis() - time;
					}
					catch(Exception e) {}
				}
			}
		};
		loop.start();
	} 

	void initialize()
	{
		activeScene = scenes.get(0);
		startTime = System.currentTimeMillis();
		setTitle(title); 
		setSize(Screen.width, Screen.height); 
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true); 

        insets = getInsets(); 
        setSize(insets.left + Screen.width + insets.right, insets.top + Screen.height + insets.bottom);
		guiBuffer = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_ARGB_PRE);
		screenBuffer = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_RGB);
        new Input(this);
	}

	void update()
	{
		for(Iterator<GameObject> i = activeScene.gameObjects.iterator(); i.hasNext();)
		{
			i.next().update();
		}
	}

	void fixedUpdate()
	{
		for(Iterator<GameObject> i = activeScene.gameObjects.iterator(); i.hasNext();)
		{
			i.next().fixedUpdate();
		}
	}

	void draw()
	{
		// Draw gui and objects
		Graphics g = getGraphics();
		Renderer.graphics = screenBuffer.getGraphics();
		GUI.graphics = (Graphics2D)guiBuffer.getGraphics();
		GUI.graphics.setBackground(new Color(0, 255, 0, 0));
		GUI.graphics.clearRect(0, 0, Screen.width, Screen.height);
		GUI.graphics.setColor(Color.black);
		activeScene.Draw(this);
		
		// Stats
		GUI.label(new Rect(0, 10, 0, 0), "Time: " + Time.time);
		GUI.label(new Rect(0, 30, 0, 0), "DeltaTime: " + Time.deltaTime);
		GUI.label(new Rect(0, 50, 0, 0), "FixedTime: " + Time.fixedTime);
		GUI.label(new Rect(0, 70, 0, 0), "DeltaFixedTime: " + Time.deltaFixedTime);
		GUI.label(new Rect(0, 90, 0, 0), (1000f / Time.deltaTime) + " FPS");
		
		// Draw frame
		Renderer.graphics.drawImage(guiBuffer, 0, 0, this);
		g.drawImage(screenBuffer, insets.left, insets.top, this);
	}

	public Scene getActiveScene()
	{
		return activeScene;
	}

	public void addScene(Scene scene)
	{
		scenes.add(scene);
	}
}