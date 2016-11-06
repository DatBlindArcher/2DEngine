package game.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import game.engine.UI.GUI;

public class Engine extends JFrame
{
	public Insets insets;
	public Scene ddolScene = new Scene();
	public Scene activeScene;
	public static Engine instance;

	private Scene[] scenes;
	private long startTime;
	private Input input;
	public boolean isRunning = true;
	private static final long serialVersionUID = 1L;
	private String title;
	private BufferedImage guiBuffer;
	private BufferedImage screenBuffer;
	private boolean fullscreen;
	private boolean resizable;

	public Engine(String title, int width, int height)
	{
		this.title = title;
		Screen.width = width;
		Screen.height = height;
		instance = this;
		Time.deltaFixedTime = 0.02f;
	}
	
	public Engine(String xml)
	{
		try
		{
			File file = new File(xml);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			title = doc.getDocumentElement().getAttribute("Title");
			Screen.width = Integer.parseInt(doc.getDocumentElement().getAttribute("Width"));
			Screen.height = Integer.parseInt(doc.getDocumentElement().getAttribute("Height"));
			fullscreen = Boolean.parseBoolean(doc.getDocumentElement().getAttribute("Fullscreen"));
			resizable = Boolean.parseBoolean(doc.getDocumentElement().getAttribute("Resizable"));
			
			NodeList xmlscenes = doc.getDocumentElement().getChildNodes();
			scenes = new Scene[xmlscenes.getLength()];
			
			for (int i = 0; i < xmlscenes.getLength(); i++)
			{
				scenes[i] = new Scene(xmlscenes.item(i));
			}
		}
		
		catch(Exception e)
		{
			
		}
	}

	public void run()
	{
		initialize();
		runFixedUpdate();
		runUpdate();
		activeScene.deActivate();
		ddolScene.deActivate();
		System.exit(0);
	}

	public void runUpdate()
	{
		while(isRunning) 
		{
			long time = System.nanoTime();
			Time.time = (time - startTime) / 1000000000f;

			input.update();
			update();
			draw();

			Time.deltaTime = (System.nanoTime() - time) / 1000000000f;
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
					long time = System.nanoTime();
					Time.fixedTime = (time - startTime) / 1000000000f;

					fixedUpdate();

					int delta = (int)((System.nanoTime() - time) / 1000000f);

					try
					{
						Thread.sleep((long)(Time.deltaFixedTime * 1000f) - delta);
					}
					catch(Exception e) {}
				}
			}
		};
		loop.start();
	} 

	void initialize()
	{
		startTime = System.nanoTime();
		setTitle(title);
		
		if(fullscreen)
		{
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
			setUndecorated(true);
		}
		
		else
		{
			setSize(Screen.width, Screen.height); 
			setResizable(resizable);
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true); 

		insets = getInsets(); 
		setSize(insets.left + Screen.width + insets.right, insets.top + Screen.height + insets.bottom);
		guiBuffer = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_ARGB_PRE);
		screenBuffer = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_RGB);
		input = new Input(this);
		
		GUI.setLayout(Color.black, "/Images/Square.png", "/Images/Square.png");
	}

	void update()
	{
		activeScene.gameObjects.values().forEach(x -> x.update());
		ddolScene.gameObjects.values().forEach(x -> x.update());
	}

	void fixedUpdate()
	{
		activeScene.gameObjects.values().forEach(x -> x.fixedUpdate());
		ddolScene.gameObjects.values().forEach(x -> x.fixedUpdate());
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
		activeScene.draw(this);
		
		// StatsDecimal
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.FLOOR);
		GUI.setColor(Color.black);
		GUI.label(new Rect(20, 30, 0, 0), "Time: " + df.format(Time.time));
		GUI.label(new Rect(20, 50, 0, 0), "DeltaTime: " + df.format(Time.deltaTime));
		GUI.label(new Rect(20, 70, 0, 0), "FixedTime: " + df.format(Time.fixedTime));
		GUI.label(new Rect(20, 90, 0, 0), "DeltaFixedTime: " + df.format(Time.deltaFixedTime));
		GUI.label(new Rect(20, 110, 0, 0), df.format((1f / Time.deltaTime)) + " FPS");

		// Draw frame
		Renderer.graphics.drawImage(guiBuffer, 0, 0, this);
		g.drawImage(screenBuffer, insets.left, insets.top, this);
	}
}