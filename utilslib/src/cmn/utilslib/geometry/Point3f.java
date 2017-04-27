package cmn.utilslib.geometry;

import cmn.utilslib.matrix.Matrix4f;
import cmn.utilslib.vector.Vec3f;
import cmn.utilslib.vector.api.IVec3f;
import cmn.utilslib.vector.api.IVec3fBase;

public class Point3f
{
	public float x = 0.0f; 
	public float y = 0.0f;
	public float z = 0.0f;
	
	public Vec3f normal = new Vec3f();
	
	public Point3f()
	{
		setOrigin();
	}
	
	public Point3f(float x, float y, float z)
	{
		set(x, y, z);
	}
	
	public Point3f(Vec3f v)
	{
		set(v);
	}
	
	private Point3f(Point3f p)
	{
		set(p);
	}
	
	public Point3f setOrigin() { return set(0.0f, 0.0f, 0.0f); }
	
	public Point3f set(Point3f p) { return set(p.x, p.y, p.z); }
	
	public Point3f set(IVec3fBase v) { return set(v.getX(), v.getY(), v.getZ()); }	
	
	public Point3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	
	public Point3f setX(float x) { this.x = x; return this; }
	
	public Point3f setY(float y) { this.y = y; return this; }
	
	public Point3f setZ(float z) { this.z = z; return this; }
	
	
	public IVec3f vectorTo(Point3f p) { return new Vec3f(p.x - this.x, p.y - this.y, p.z - this.z); }
	
	public IVec3f vectorFrom(Point3f p) { return new Vec3f(this.x - p.x, this.y - p.y, this.z - p.z); }
	
	public float distanceTo(Point3f p) { return vectorTo(p).length(); }
	
	public float distanceFrom(Point3f p) { return vectorFrom(p).length(); }
	
	public IVec3f directionTo(Point3f p) { return vectorTo(p).normalize(); }
	
	public IVec3f directionFrom(Point3f p) { return vectorFrom(p).normalize(); }
	
	public IVec3f vector() { return new Vec3f(this.x, this.y, this.z); }
	
	public Point3f transform(Matrix4f m) { return m.transform(this); }
	
	public Point3f transformed(Matrix4f m) { return m.transformN(this); }
	
	public Point3f translate(float x, float y, float z) { return set(this.x + x, this.y + y, this.z + z); }
	
	public Point3f add(IVec3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	
	public Point3f add(float x, float y, float z) { return new Point3f(this.x + x, this.y + y, this.z + z); }
	
	public Point3f sub(IVec3fBase v) { return sub(v.getX(), v.getY(), v.getZ()); }
	
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
