package game.engine;
public class Rect 
{
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Rect(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean equals(Rect b)
	{
		return x == b.x && y == b.y && width == b.width && height == b.height;
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ", " + width + ", " + height + ")";
	}
}