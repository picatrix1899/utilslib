package cmn.utilslib.math.geometry;

import cmn.utilslib.Pool;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3f;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.Vector3d;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3fBase;

public class Point3f implements Tup3f
{
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	/*
	###############
	##           ##
	##  POOLING  ##
	##           ##
	###############
	 */
	private static Pool<Point3f> pool = new Pool<Point3f>(Point3f.class);
	
	public static Point3f getInstance() { return pool.get().setZero(); }
	public static Point3f getInstance(Vector3f v) { return pool.get().set(v); }
	public static Point3f getInstance(Vector3d v) { return pool.get().set(v); }
	public static Point3f getInstance(Vec3fBase v) { return pool.get().set(v); }
	public static Point3f getInstance(Vec3dBase v) { return pool.get().set(v); }
	public static Point3f getInstance(Tuple3f t) { return pool.get().set(t); }
	public static Point3f getInstance(Tuple3d t) { return pool.get().set(t); }
	public static Point3f getInstance(Tup3fBase t) { return pool.get().set(t); }
	public static Point3f getInstance(Tup3dBase t) { return pool.get().set(t); }
	public static Point3f getInstance(Point3f p) { return pool.get().set(p); }
	public static Point3f getInstance(float scalar) { return pool.get().set(scalar); }
	public static Point3f getInstance(double scalar) { return pool.get().set(scalar); }
	public static Point3f getInstance(float x, float y, float z) { return pool.get().set(x, y, z); }
	public static Point3f getInstance(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void storeInstance(Point3f v) { pool.store(v); }
	
	
	
	/*
	####################
	##                ##
	##  CONSTRUCTORS  ##
	##                ##
	####################
	 */
	
	public Point3f() { }
	public Point3f(Vector3f v) { this.x = v.x; this.y = v.y; this.z = v.z; }
	public Point3f(Vector3d v) { this.x = (float)v.x; this.y = (float)v.y; this.z = (float)v.z; }
	public Point3f(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); }
	public Point3f(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); }
	public Point3f(Tuple3f t) { this.x = t.v[0]; this.y = t.v[1]; this.z = t.v[2]; }
	public Point3f(Tuple3d t) { this.x = (float)t.v[0]; this.y = (float)t.v[1]; this.z = (float)t.v[2]; }
	public Point3f(Tup3fBase t) { this.x = t.get(0); this.y = t.get(1); this.z = t.get(2); }
	public Point3f(Tup3dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); this.z = (float)t.get(2); }
	public Point3f(Point3f p) { this.x = p.x; this.y = p.y; this.z = p.z; }
	public Point3f(float x, float y, float z) { this.x = x; this.y = y; this.z = z; }
	public Point3f(double x, double y, double z) { this.x = (float)x; this.y = (float)y; this.z = (float)z; }

	
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	
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
	
	public Point3f setX(float x) { this.x = x; return this; }
	public Point3f setY(float y) { this.y = y; return this; }
	public Point3f setZ(float z) { this.z = z; return this; }
	
	public Point3f setZero()
	{
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		
		return this;
	}
	
	public Point3f set(Vector3f v) { this.x = v.x; this.y = v.y; this.z = v.z; return this; }
	public Point3f set(Vector3d v) { this.x = (float)v.x; this.y = (float)v.y; this.z = (float)v.z; return this; }
	public Point3f set(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); return this; }
	public Point3f set(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); return this; }
	public Point3f set(Tuple3f t) { this.x = t.v[0]; this.y = t.v[1]; this.z = t.v[2]; return this; }
	public Point3f set(Tuple3d t) { this.x = (float)t.v[0]; this.y = (float)t.v[1]; this.z = (float)t.v[2]; return this; }
	public Point3f set(Tup3fBase t) { this.x = t.get(0); this.y = t.get(1); this.z = t.get(2); return this; }
	public Point3f set(Tup3dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); this.z = (float)t.get(2); return this; }
	public Point3f set(Point3f p) { this.x = p.x; this.y = p.y; this.z = p.z; return this; }
	public Point3f set(float scalar) { this.x = scalar; this.y = scalar; this.z = scalar; return this; }
	public Point3f set(double scalar) { this.x = (float)scalar; this.y = (float)scalar; this.z = (float)scalar; return this; }
	public Point3f set(float x, float y, float z) { this.x = x; this.y = y; this.z = z; return this; }
	public Point3f set(double x, double y, double z) { this.x = (float)x; this.y = (float)y; this.z = (float)z; return this; }
	
	public Point3f set(int index, float value)
	{
		switch(index)
		{
			case 0: this.x = value; break;
			case 1: this.y = value; break;
			case 2: this.z = value; break;
		}
		
		return this;
	}
	
	public Point3f set(int index, double value)
	{
		switch(index)
		{
			case 0: this.x = (float)value; break;
			case 1: this.y = (float)value; break;
			case 2: this.z = (float)value; break;
		}
		
		return this;
	}
	
	public Vector3f asVector3f(Vector3f dst) { return dst.set(x, y, z); }
	public Vector3d asVector3d(Vector3d dst) { return dst.set(x, y, z); }
	public Vector3f asVector3f() { return new Vector3f(x, y, z); }
	public Vector3d asVector3d() { return new Vector3d(x, y, z); }
	

	
	public Vector3f vectorTof(Point3f p, Vector3f v) { return p.asVector3f(v).sub(asVector3f()); }
	public Vector3d vectorTod(Point3f p, Vector3d v) { return p.asVector3d(v).sub(asVector3d()); }
	public Vector3f vectorFromf(Point3f p, Vector3f v) { return asVector3f(v).sub(p.asVector3f()); }
	public Vector3d vectorFromd(Point3f p, Vector3d v) { return asVector3d(v).sub(p.asVector3d()); }
	
	public Vector3f vectorTof(Point3f p) { return p.asVector3f().sub(asVector3f()); }
	public Vector3d vectorTod(Point3f p) { return p.asVector3d().sub(asVector3d()); }
	public Vector3f vectorFromf(Point3f p) { return asVector3f().sub(p.asVector3f()); };
	public Vector3d vectorFromd(Point3f p) { return asVector3d().sub(p.asVector3d()); };
	
	public Vector3f directionTof(Point3f p, Vector3f v) { return vectorTof(p, v).normalize(); }
	public Vector3d directionTod(Point3f p, Vector3d v) { return vectorTod(p, v).normalize(); }
	public Vector3f directionFromf(Point3f p, Vector3f v) { return vectorFromf(p, v).normalize(); }
	public Vector3d directionFromd(Point3f p, Vector3d v) { return vectorFromd(p, v).normalize(); }
	
	public Vector3f directionTof(Point3f p) { return vectorTof(p).normalize(); }
	public Vector3d directionTod(Point3f p) { return vectorTod(p).normalize(); }
	public Vector3f directionFromf(Point3f p) { return vectorFromf(p).normalize(); }
	public Vector3d directionFromd(Point3f p) { return vectorFromd(p).normalize(); }
	
	public Point3f jump(Vec3fBase v) { return set(asVector3f().add(v)); }
	public Point3f jump(Vec3dBase v) { return set(asVector3d().add(v)); }
	public Point3f jumpN(Vec3fBase v) { return clone().jump(v); }
	public Point3f jumpN(Vec3dBase v) { return clone().jump(v); }
	
	public Point3f clone() { return new Point3f(this); }
	
	public String toString() { return String.format("point3f(%sf, %sf, %sf)", x, y, z); }
	


}
