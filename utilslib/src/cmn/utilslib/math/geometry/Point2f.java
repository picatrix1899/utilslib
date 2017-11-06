package cmn.utilslib.math.geometry;

import cmn.utilslib.Pool;
import cmn.utilslib.math.tuple.Tuple2d;
import cmn.utilslib.math.tuple.Tuple2f;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2f;
import cmn.utilslib.math.tuple.api.Tup2fBase;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.Vector2d;
import cmn.utilslib.math.vector.Vector2f;
import cmn.utilslib.math.vector.Vector3d;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec2dBase;
import cmn.utilslib.math.vector.api.Vec2fBase;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3fBase;


public class Point2f implements Tup2f
{
	public float x = 0.0f;
	public float y = 0.0f;
	
	/*
	###############
	##           ##
	##  POOLING  ##
	##           ##
	###############
	 */
	private static Pool<Point2f> pool = new Pool<Point2f>(Point2f.class);
	
	public static Point2f getInstance() { return pool.get().setZero(); }
	public static Point2f getInstance(Vector2f v) { return pool.get().set(v); }
	public static Point2f getInstance(Vector2d v) { return pool.get().set(v); }
	public static Point2f getInstance(Vec2fBase v) { return pool.get().set(v); }
	public static Point2f getInstance(Vec2dBase v) { return pool.get().set(v); }
	public static Point2f getInstance(Tuple2f t) { return pool.get().set(t); }
	public static Point2f getInstance(Tuple2d t) { return pool.get().set(t); }
	public static Point2f getInstance(Tup2fBase t) { return pool.get().set(t); }
	public static Point2f getInstance(Tup2dBase t) { return pool.get().set(t); }
	public static Point2f getInstance(Point2f p) { return pool.get().set(p); }
	public static Point2f getInstance(float scalar) { return pool.get().set(scalar); }
	public static Point2f getInstance(double scalar) { return pool.get().set(scalar); }
	public static Point2f getInstance(float x, float y) { return pool.get().set(x, y); }
	public static Point2f getInstance(double x, double y) { return pool.get().set(x, y); }
	
	public static void storeInstance(Point2f v) { pool.store(v); }
	
	
	
	/*
	####################
	##                ##
	##  CONSTRUCTORS  ##
	##                ##
	####################
	 */
	
	public Point2f() { }
	public Point2f(Vector2f v) { this.x = v.x; this.y = v.y; }
	public Point2f(Vector2d v) { this.x = (float)v.x; this.y = (float)v.y; }
	public Point2f(Vec2fBase v) { this.x = v.getX(); this.y = v.getY(); }
	public Point2f(Vec2dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); }
	public Point2f(Tuple2f t) { this.x = t.v[0]; this.y = t.v[1]; }
	public Point2f(Tuple2d t) { this.x = (float)t.v[0]; this.y = (float)t.v[1]; }
	public Point2f(Tup2fBase t) { this.x = t.get(0); this.y = t.get(1); }
	public Point2f(Tup2dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); }
	public Point2f(Point2f p) { this.x = p.x; this.y = p.y; }
	public Point2f(float x, float y) { this.x = x; this.y = y; }
	public Point2f(double x, double y) { this.x = (float)x; this.y = (float)y; }

	
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	
	public float get(int index)
	{
		switch(index)
		{
			case 0: return this.x;
			case 1: return this.y;
		}
		
		return Float.NaN;
	}
	
	public Point2f setX(float x) { this.x = x; return this; }
	public Point2f setY(float y) { this.y = y; return this; }
	
	public Point2f setZero()
	{
		this.x = 0.0f;
		this.y = 0.0f;
		
		return this;
	}
	
	public Point2f set(Vector2f v) { this.x = v.x; this.y = v.y; return this; }
	public Point2f set(Vector2d v) { this.x = (float)v.x; this.y = (float)v.y; return this; }
	public Point2f set(Vec2fBase v) { this.x = v.getX(); this.y = v.getY(); return this; }
	public Point2f set(Vec2dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); return this; }
	public Point2f set(Tuple2f t) { this.x = t.v[0]; this.y = t.v[1]; return this; }
	public Point2f set(Tuple2d t) { this.x = (float)t.v[0]; this.y = (float)t.v[1]; return this; }
	public Point2f set(Tup2fBase t) { this.x = t.get(0); this.y = t.get(1); return this; }
	public Point2f set(Tup2dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); return this; }
	public Point2f set(Point2f p) { this.x = p.x; this.y = p.y; return this; }
	public Point2f set(float scalar) { this.x = scalar; this.y = scalar; return this; }
	public Point2f set(double scalar) { this.x = (float)scalar; this.y = (float)scalar; return this; }
	public Point2f set(float x, float y) { this.x = x; this.y = y; return this; }
	public Point2f set(double x, double y) { this.x = (float)x; this.y = (float)y; return this; }
	
	public Point2f set(int index, float value)
	{
		switch(index)
		{
			case 0: this.x = value; break;
			case 1: this.y = value; break;
		}
		
		return this;
	}
	
	public Point2f set(int index, double value)
	{
		switch(index)
		{
			case 0: this.x = (float)value; break;
			case 1: this.y = (float)value; break;
		}
		
		return this;
	}
	
	public Vector2f asVector2f(Vector2f dst) { return dst.set(x, y); }
	public Vector2d asVector2d(Vector2d dst) { return dst.set(x, y); }
	public Vector2f asVector2f() { return new Vector2f(x, y); }
	public Vector2d asVector2d() { return new Vector2d(x, y); }
	

	
	public Vector2f vectorTof(Point2f p, Vector2f v) { return p.asVector2f(v).sub(asVector2f()); }
	public Vector2d vectorTod(Point2f p, Vector2d v) { return p.asVector2d(v).sub(asVector2d()); }
	public Vector2f vectorFromf(Point2f p, Vector2f v) { return asVector2f(v).sub(p.asVector2f()); }
	public Vector2d vectorFromd(Point2f p, Vector2d v) { return asVector2d(v).sub(p.asVector2d()); }
	
	public Vector2f vectorTof(Point2f p) { return p.asVector2f().sub(asVector2f()); }
	public Vector2d vectorTod(Point2f p) { return p.asVector2d().sub(asVector2d()); }
	public Vector2f vectorFromf(Point2f p) { return asVector2f().sub(p.asVector2f()); };
	public Vector2d vectorFromd(Point2f p) { return asVector2d().sub(p.asVector2d()); };
	
	public Vector2f directionTof(Point2f p, Vector2f v) { return vectorTof(p, v).normalize(); }
	public Vector2d directionTod(Point2f p, Vector2d v) { return vectorTod(p, v).normalize(); }
	public Vector2f directionFromf(Point2f p, Vector2f v) { return vectorFromf(p, v).normalize(); }
	public Vector2d directionFromd(Point2f p, Vector2d v) { return vectorFromd(p, v).normalize(); }
	
	public Vector2f directionTof(Point2f p) { return vectorTof(p).normalize(); }
	public Vector2d directionTod(Point2f p) { return vectorTod(p).normalize(); }
	public Vector2f directionFromf(Point2f p) { return vectorFromf(p).normalize(); }
	public Vector2d directionFromd(Point2f p) { return vectorFromd(p).normalize(); }
	
	public Point2f jump(Vec2fBase v) { return set(asVector2f().add(v)); }
	public Point2f jump(Vec2dBase v) { return set(asVector2d().add(v)); }
	public Point2f jumpN(Vec2fBase v) { return clone().jump(v); }
	public Point2f jumpN(Vec2dBase v) { return clone().jump(v); }
	
	public Point2f clone() { return new Point2f(this); }
	
	public String toString() { return String.format("point2f(%sf, %sf)", x, y); }
	
	public Point2f add(Tup2fBase v) { this.x += v.get(0); this.y += v.get(1); return this; }
	
	
	public Point2f addN(Tup2fBase v) { return clone().add(v); }
	
	public Point2f sub(Tup2fBase v) { this.x -= v.get(0); this.y -= v.get(1); return this; }
	
	
	public Point2f subN(Tup2fBase v) { return clone().sub(v); }
	
	public Point2f mul(Tup2fBase v) { this.x *= v.get(0); this.y *= v.get(1); return this; }
	
	
	public Point2f mulN(Tup2fBase v) { return clone().mul(v); }	
	
	public Point2f div(Tup2fBase v) { this.x /= v.get(0); this.y /= v.get(1); return this; }
	
	
	public Point2f divN(Tup2fBase v) { return clone().div(v); }
	

	
	public Vector2f addVector(Vec2fBase v, Vector2f dest) { return asVector2f(dest).add(v); }
	
	public Vector2f addVectorN(Vec2fBase v, Vector2f dest) { return clone().addVector(v, dest); }
	
	public Vector2f subVector(Vec2fBase v, Vector2f dest) { return asVector2f(dest).sub(v); }
	
	public Vector2f subVectorN(Vec2fBase v, Vector2f dest) { return clone().subVector(v, dest); }
	
	public Vector2f mulVector(Vec2fBase v, Vector2f dest) { return asVector2f(dest).mul(v); }
	
	public Vector2f mulVectorN(Vec2fBase v, Vector2f dest) { return clone().mulVector(v, dest); }
	
	public Vector2f divVector(Vec2fBase v, Vector2f dest) { return asVector2f(dest).div(v); }
	public Vector2f divVectorN(Vec2fBase v, Vector2f dest) { return clone().divVector(v, dest); }
	
	public Point2f center(Point2f p) { this.add(p); return this; }
}
