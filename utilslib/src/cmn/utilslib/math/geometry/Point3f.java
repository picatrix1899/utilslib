package cmn.utilslib.math.geometry;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3f;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3fBase;

public class Point3f implements Tup3f
{
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Point3f> allocator = new Allocator<Point3f>(Point3f.class);
	
	public static Point3f alloc() { return allocator.alloc().setZero(); }
	public static Point3f alloc(Vec3fBase v) { return allocator.alloc().set(v); }
	public static Point3f alloc(Vec3dBase v) { return allocator.alloc().set(v); }
	public static Point3f alloc(Tup3fBase t) { return allocator.alloc().set(t); }
	public static Point3f alloc(Tup3dBase t) { return allocator.alloc().set(t); }
	public static Point3f alloc(float scalar) { return allocator.alloc().set(scalar); }
	public static Point3f alloc(double scalar) { return allocator.alloc().set(scalar); }
	public static Point3f alloc(float x, float y, float z) { return allocator.alloc().set(x, y, z); }
	public static Point3f alloc(double x, double y, double z) { return allocator.alloc().set(x, y, z); }
	
	public static void dealloc(Point3f v) { allocator.dealloc(v); }
	
	
	public Point3f() { }
	public Point3f(Vector3f v) { this.x = v.x; this.y = v.y; this.z = v.z; }
	public Point3f(Point3f p) { this.x = p.x; this.y = p.y; this.z = p.z; }
	public Point3f(float x, float y, float z) { this.x = x; this.y = y; this.z = z; }
	
	
	
	public Vector3f asVector3f(Vector3f dst) { return dst.set(x, y, z); }
	
	public Point3f clone() { return new Point3f(this); }
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	
	public Point3f setX(float x) { this.x = x; return this; }
	public Point3f setY(float y) { this.y = y; return this; }
	public Point3f setZ(float z) { this.z = z; return this; }
	
	public Point3f set(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); return this; }
	public Point3f set(Point3f p) { this.x = p.x; this.y = p.y; this.z = p.z; return this; }
	public Vector3f vectorTo(Point3f p, Vector3f v) { return p.asVector3f(v).sub(asVector3f(Vector3f.TEMP)); }
	public Vector3f vectorFrom(Point3f p, Vector3f v) { return asVector3f(v).sub(p.asVector3f(Vector3f.TEMP)); }
	
	public Vector3f directionTo(Point3f p, Vector3f v) { return vectorTo(p, v).normalize(); }
	public Vector3f directionFrom(Point3f p, Vector3f v) { return vectorFrom(p, v).normalize(); }
	
	
	public Point3f jump(Vec3fBase v) { return set(asVector3f(Vector3f.TEMP).add(v)); }
	public Point3f jumpN(Vec3fBase v) { return clone().jump(v); }
	
	public String toString() { return String.format("point3f(%s,%s,%s)", getX(), getY(), getZ()); }
	
	@Override
	public float get(int index)
	{
		switch(index)
		{
			case 0: return this.x;
			case 1: return this.y;
			case 2: return this.z;
		}
		
		return Float.NaN;
	}
	@Override
	public Point3f setZero()
	{
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		
		return this;
	}
	@Override
	public Point3f set(Tup3fBase t)
	{
		this.x = t.get(0);
		this.y = t.get(1);
		this.z = t.get(2);
		
		return this;
	}
	@Override
	public Point3f set(Tup3dBase t)
	{
		this.x = (float)t.get(0);
		this.y = (float)t.get(1);
		this.z = (float)t.get(2);
		
		return this;
	}
	@Override
	public Point3f set(float scalar)
	{
		this.x = scalar;
		this.y = scalar;
		this.z = scalar;
		
		return this;
	}
	@Override
	public Point3f set(double scalar)
	{
		this.x = (float)scalar;
		this.y = (float)scalar;
		this.z = (float)scalar;
		
		return this;
	}
	@Override
	public Point3f set(float v0, float v1, float v2)
	{
		this.x = v0;
		this.y = v1;
		this.z = v2;
		return this;
	}
	@Override
	public Point3f set(double v0, double v1, double v2)
	{
		this.x = (float)v0;
		this.y = (float)v1;
		this.z = (float)v2;
		return this;
	}
	
	@Override
	public Point3f set(int index, float value)
	{
		switch(index)
		{
			case 0: this.x = value;
			case 1: this.y = value;
			case 2: this.z = value;
		}
		
		return this;
	}
	@Override
	public Point3f set(int index, double value)
	{
		switch(index)
		{
			case 0: this.x = (float)value;
			case 1: this.y = (float)value;
			case 2: this.z = (float)value;
		}
		
		return this;
	}
}
