package game.engine.Animation;

import game.engine.Action;

public class AnimationFrame 
{
	public float time;
	public Action[] actions;
	
	public AnimationFrame(float time, Action[] actions)
	{
		this.time = time;
		this.actions = actions;
	}
	
	public void run()
	{
		for(Action action : actions)
			action.execute();
	}
}