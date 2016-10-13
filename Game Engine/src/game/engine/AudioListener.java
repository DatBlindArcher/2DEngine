package game.engine;

public class AudioListener extends Component
{
	public void start()
	{
		int x = 0;
		
		for(int i = 0; i < SceneManager.activeScene.gameObjects.size(); i++)
		{
			if(SceneManager.activeScene.gameObjects.get(i).getComponents(AudioListener.class) != null)
			{
				x++;
			}
		}
		
		if(x > 1)
		{
			System.out.println("There is more than one AudioListener.");
		}
	}
	
	public void update()
	{
		super.update();
		
		for(int i = 0; i < SceneManager.activeScene.gameObjects.size(); i++)
		{
			AudioSource c;
			
			if((c = SceneManager.activeScene.gameObjects.get(i).getComponent(AudioSource.class)) != null)
			{
				c.setValues(this);
			}
		}
	}
}