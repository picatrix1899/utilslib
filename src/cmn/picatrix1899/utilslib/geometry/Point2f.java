package cmn.picatrix1899.utilslib.geometry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;
import cmn.picatrix1899.utilslib.vector.Vector2f;

public class Point2f implements DataHolder, Serializable
{
	private static final long serialVersionUID = 1L;
	
	public float x = 0.0f;
	public float y = 0.0f;
	
	public Vector2f normal = new Vector2f();
	
	public Point2f()
	{
		setOrigin();
	}
	
	public Point2f(float x, float y)
	{
		set(x, y);
	}
	
	private Point2f(Point2f p)
	{
		set(p);
	}
	
	public Point2f setOrigin() { return set(0.0f, 0.0f); }
	
	public Point2f set(Point2f p) { return set(p.x, p.y); }
	
	public Point2f set(float x, float y) { return setX(x).setY(y); }
	
	
	public Point2f setX(float x) { this.x = x; return this; }
	
	public Point2f setY(float y) { this.y = y; return this; }
	
	public Vector2f vectorTo(Point2f p) { return new Vector2f(p.x - this.x, p.y - this.y); }
	
	public Vector2f vectorFrom(Point2f p) { return new Vector2f(this.x - p.x, this.y - p.y); }
	
	public float distanceTo(Point2f p) { return vectorTo(p).length(); }
	
	public Vector2f directionTo(Point2f p) { return vectorTo(p).normalize(); }
	
	public Vector2f directionFrom(Point2f p) { return vectorFrom(p).normalize(); }
	
	public Vector2f vector() { return new Vector2f(this.x, this.y); }
	
	public String toString()
	{
		return "point2f(" + this.x +"f, " + this.y +"f)";
	}
	
	public Point2f clone()
	{
		return new Point2f(this);
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Point2f)
		{
			Point2f p = (Point2f)obj;
			
			return this.x == p.x && this.y == p.y;
		}
		
		return false;
	}

	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.x = dis.readFloat();
		this.y = dis.readFloat();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
	}
}
