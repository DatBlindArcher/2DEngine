package game.engine;

import java.util.Comparator;

public class LayerHandler implements Comparator<Image>
{
	public int compare(Image o1, Image o2) 
	{
		if(o1.layer == o2.layer)
			return 0;
		if (o1.layer < o2.layer)
			return -1;
		return 1;
	}
}