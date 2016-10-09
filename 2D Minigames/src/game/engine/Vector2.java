package game.engine;
public class Vector2
{
	public float x;
	public float y;

	public Vector2()
	{
		x = 0f;
		y = 0f;
	}
	
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void add(Vector2 v)
	{
		x += v.x;
		y += v.y;
	}
	
	public Vector2 normalized()
	{
		float m = magnitude();
		if(m == 0) return new Vector2();
		return new Vector2(x / m, y / m);
	}
	
	public void normalize()
	{
		Vector2 result = this.normalized();
		x = result.x;
		y = result.y;
	}
	
	public float magnitude()
	{
		return (float)Math.sqrt(x * x + y * y);
	}
	
	public Vector2 multiply(float factor)
	{
		return new Vector2(x * factor, y * factor);
	}
}