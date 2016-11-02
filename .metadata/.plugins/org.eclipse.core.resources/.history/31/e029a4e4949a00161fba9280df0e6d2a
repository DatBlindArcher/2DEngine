package game.engine;

import java.util.*;

public class Animation extends Component
{
	private boolean running;
	private int frameIndex;
	public float time;
	public float length;
	public AnimationFrame[] frames;
	
	public Animation(boolean runByDefault, float length, List<AnimationFrame> frames)
	{
		running = runByDefault;
		this.length = length;
		frames.sort(new AnimationFrameHandler());
		this.frames = new AnimationFrame[frames.size()];
		frames.toArray(this.frames);
		time = 0f;
		frameIndex = 0;
	}
	
	public void run(boolean doRun)
	{
		running = doRun;
		time = 0f;
		frameIndex = 0;
	}
	
	public void update()
	{
		if(running)
		{
			time += Time.deltaTime;
			
			if(time >= length)
			{
				time -= length;
				frameIndex = 0;
			}
			
			if(frameIndex < frames.length)
			{
				while(time > frames[frameIndex].time)
				{
					frames[frameIndex].run();
					frameIndex++;
					if(frameIndex >= frames.length) break;
				}
			}
		}
	}
}