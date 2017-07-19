package cmn.utilslib.math.geometry;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2f;
import cmn.utilslib.math.tuple.api.Tup2fBase;
import cmn.utilslib.math.vector.Vector2f;
import cmn.utilslib.math.vector.api.Vec2dBase;
import cmn.utilslib.math.vector.api.Vec2fBase;


public class Point2f implements Tup2f
{
	public float x = 0.0f;
	public float y = 0.0f;
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Point2f> allocator = new Allocator<Point2f>(Point2f.class);
	
	public static Point2f alloc() { return allocator.alloc().setZero(); }
	public static Point2f alloc(Vec2fBase v) { return allocator.alloc().set(v); }
	public static Point2f alloc(Vec2dBase v) { return allocator.alloc().set(v); }
	public static Point2f alloc(Tup2fBase t) { return allocator.alloc().set(t); }
	public static Point2f alloc(Tup2dBase t) { return allocator.alloc().set(t); }
	public static Point2f alloc(float scalar) { return allocator.alloc().set(scalar); }
	public static Point2f alloc(double scalar) { return allocator.alloc().set(scalar); }
	public static Point2f alloc(float x, float y) { return allocator.alloc().set(x, y); }
	public static Point2f alloc(double x, double y) { return allocator.alloc().set(x, y); }
	
	public static void dealloc(Point2f v) { allocator.dealloc(v); }
	
	
	public Point2f() { }
	public Point2f(Vector2f v) { this.x = v.x; this.y = v.y; }
	public Point2f(Point2f p) { this.x = p.x; this.y = p.y; }
	public Point2f(float x, float y, float z) { this.x = x; this.y = y; }
	
	
	
	public Vector2f asVector2f(Vector2f dst) { return dst.set(x, y); }
	
	public Point2f clone() { return new Point2f(this); }
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	
	public Point2f setX(float x) { this.x = x; return this; }
	public Point2f setY(float y) { this.y = y; return this; }
	
	public Point2f set(Vec2fBase v) { this.x = v.getX(); this.y = v.getY(); return this; }
	public Point2f set(Point2f p) { this.x = p.x; this.y = p.y; return this; }
	public Point2f set(float x, float y, float z) { this.x = x; this.y = y; return this; }
	public Point2f set(double x, double y, double z) { this.x = (float)x; this.y = (float)y; return this; }
	
	public Vector2f vectorTo(Point2f p, Vector2f v) { return p.asVector2f(v).sub(asVector2f(Vector2f.TEMP)); }
	public Vector2f vectorFrom(Point2f p, Vector2f v) { return asVector2f(v).sub(p.asVector2f(Vector2f.TEMP)); }
	
	public Vector2f directionTo(Point2f p, Vector2f v) { return vectorTo(p, v).normalize(); }
	public Vector2f directionFrom(Point2f p, Vector2f v) { return vectorFrom(p, v).normalize(); }
	
	
	public Point2f jump(Vec2fBase v) { return set(asVector2f(Vector2f.TEMP).add(v)); }
	public Point2f jumpN(Vec2fBase v) { return clone().jump(v); }
	
	public String toString() { return String.format("point2f({0},{1})", getX(), getY()); }
	
	@Override
	public float get(int index)
	{
		switch(index)
		{
			case 1: return this.x;
			case 2: return this.y;
		}
		
		return Float.NaN;
	}
	@Override
	public Point2f setZero()
	{
		this.x = 0.0f;
		this.y = 0.0f;
		
		return this;
	}
	@Override
	public Point2f set(Tup2fBase t)
	{
		this.x = t.get(0);
		this.y = t.get(1);
		
		return this;
	}
	@Override
	public Point2f set(Tup2dBase t)
	{
		this.x = (float)t.get(0);
		this.y = (float)t.get(1);
		
		return this;
	}
	@Override
	public Point2f set(float scalar)
	{
		this.x = scalar;
		this.y = scalar;
		
		return this;
	}
	@Override
	public Point2f set(double scalar)
	{
		this.x = (float)scalar;
		this.y = (float)scalar;
		
		return this;
	}
	@Override
	public Point2f set(float... values)
	{
		this.x = values[0];
		this.y = values[1];
		
		return this;
	}
	@Override
	public Point2f set(double... values)
	{
		this.x = (float)values[0];
		this.y = (float)values[1];
		
		return this;
	}
	@Override
	public Point2f set(int index, float value)
	{
		switch(index)
		{
			case 0: this.x = value;
			case 1: this.y = value;
		}
		
		return this;
	}
	@Override
	public Point2f set(int index, double value)
	{
		switch(index)
		{
			case 0: this.x = (float)value;
			case 1: this.y = (float)value;
		}
		
		return this;
	}
}
