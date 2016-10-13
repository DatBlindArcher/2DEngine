package game.engine;

public class Vector3 
{
	public double x;
	public double y;
	public double z;
	
	public Vector3(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static Vector3 zero()
	{
		return new Vector3(0, 0, 0);
	}
	
	public static Vector3 one()
	{
		return new Vector3(1, 1, 1);
	}
	
	public void add(Vector3 b)
	{
		x += b.x;
		y += b.y;
		z += b.z;
	}
	
	public void sub(Vector3 b)
	{
		x -= b.x;
		y -= b.y;
		z -= b.z;
	}
	
	public void multiply(Vector3 b)
	{
		x *= b.x;
		y *= b.y;
		z *= b.z;
	}
	
	public void multiply(float factor)
	{
		x *= factor;
		y *= factor;
		z *= factor;
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	public static double distance(Vector3 a, Vector3 b)
	{
		return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2) + Math.pow(b.z - a.z, 2));
	}
}