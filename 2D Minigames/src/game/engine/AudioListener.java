package game.engine;

import org.w3c.dom.Node;
import java.util.*;

public class AudioListener extends Component
{
	public AudioListener() { }
	public AudioListener(Node xml)
	{
		
	}
	
	public void start()
	{
		List<AudioListener> audioListeners = new ArrayList<AudioListener>();
		
		Engine.instance.activeScene.gameObjects.values().forEach(x -> 
		{	AudioListener a = null;
		
			if(x.getComponent(AudioListener.class) != null)
			{
				audioListeners.add(a);
			}
		});
		
		if(audioListeners.size() > 1)
		{
			System.out.println("There is more than one AudioListener.");
		}
	}
	
	public void update()
	{
		super.update();
		
		Engine.instance.activeScene.gameObjects.values().forEach(x -> 
		{	AudioSource c = null;
		
			if((c = x.getComponent(AudioSource.class)) != null)
			{
				c.setValues(this);
			}
		});
	}
}