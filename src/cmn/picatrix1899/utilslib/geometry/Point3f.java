package cmn.picatrix1899.utilslib.geometry;

import cmn.picatrix1899.utilslib.matrix.Matrix4f;
import cmn.picatrix1899.utilslib.vector.Vector3f;

public class Point3f
{
	public float x = 0.0f; 
	public float y = 0.0f;
	public float z = 0.0f;
	
	public Vector3f normal = new Vector3f();
	
	public Point3f()
	{
		setOrigin();
	}
	
	public Point3f(float x, float y, float z)
	{
		set(x, y, z);
	}
	
	public Point3f(Vector3f v)
	{
		set(v);
	}
	
	private Point3f(Point3f p)
	{
		set(p);
	}
	
	public Point3f setOrigin() { return set(0.0f, 0.0f, 0.0f); }
	
	public Point3f set(Point3f p) { return set(p.x, p.y, p.z); }
	
	public Point3f set(Vector3f v) { return set(v.x, v.y, v.z); }	
	
	public Point3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	
	public Point3f setX(float x) { this.x = x; return this; }
	
	public Point3f setY(float y) { this.y = y; return this; }
	
	public Point3f setZ(float z) { this.z = z; return this; }
	
	
	public Vector3f vectorTo(Point3f p) { return new Vector3f(p.x - this.x, p.y - this.y, p.z - this.z); }
	
	public Vector3f vectorFrom(Point3f p) { return new Vector3f(this.x - p.x, this.y - p.y, this.z - p.z); }
	
	public float distanceTo(Point3f p) { return vectorTo(p).length(); }
	
	public float distanceFrom(Point3f p) { return vectorFrom(p).length(); }
	
	public Vector3f directionTo(Point3f p) { return vectorTo(p).normalize(); }
	
	public Vector3f directionFrom(Point3f p) { return vectorFrom(p).normalize(); }
	
	public Vector3f vector() { return new Vector3f(this.x, this.y, this.z); }
	
	public Point3f transform(Matrix4f m) { return m.transform(this); }
	
	public Point3f transformed(Matrix4f m) { return m.transformN(this); }
	
	public Point3f translate(float x, float y, float z) { return set(this.x + x, this.y + y, this.z + z); }
	
	public Point3f add(Vector3f v) { return add(v.x, v.y, v.z); }
	
	public Point3f add(float x, float y, float z) { return new Point3f(this.x + x, this.y + y, this.z + z); }
	
	public Point3f sub(Vector3f v) { return sub(v.x, v.y, v.z); }
	
	public Point3f sub(float x, float y, float z) { return new Point3f(this.x - x, this.y - y, this.z - z); }
	
	public String toString()
	{
		return "point3f(" + this.x + "f, " + this.y + "f, " + this.z + "f)";
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Point3f)
		{
			Point3f p = (Point3f)obj;
			
			return this.x == p.x && this.y == p.y && this.z == p.z;
		}
		
		return false;
	}
	
	public Point3f clone()
	{
		return new Point3f(this);
	}
}