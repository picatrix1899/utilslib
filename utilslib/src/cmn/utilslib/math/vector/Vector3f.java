package cmn.utilslib.math.vector;


import cmn.utilslib.Pool;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;


/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector3f implements Vec3f
{

	/*
	##################
	##              ##
	##  DIMENSIONS  ##
	##              ##
	##################
	 */
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Vector3f TEMP = new Vector3f();
	public static final Vector3f TEMP0 = new Vector3f();
	public static final Vector3f TEMP1 = new Vector3f();
	public static final Vector3f TEMP2 = new Vector3f();
	public static final Vector3f TEMP3 = new Vector3f();
	public static final Vector3f TEMP4 = new Vector3f();
	public static final Vector3f TEMP5 = new Vector3f();
	public static final Vector3f TEMP6 = new Vector3f();
	public static final Vector3f TEMP7 = new Vector3f();
	public static final Vector3f TEMP8 = new Vector3f();
	public static final Vector3f TEMP9 = new Vector3f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Pool<Vector3f> pool = new Pool<Vector3f>(Vector3f.class);
	
	public static Vector3f getInstance() { return pool.get().setZero(); }
	public static Vector3f getInstance(Vector3f v) { return pool.get().set(v); }
	public static Vector3f getInstance(Vector3d v) { return pool.get().set(v); }
	public static Vector3f getInstance(Vec3fBase v) { return pool.get().set(v); }
	public static Vector3f getInstance(Vec3dBase v) { return pool.get().set(v); }
	public static Vector3f getInstance(Tuple3f t) { return pool.get().set(t); }
	public static Vector3f getInstance(Tuple3d t) { return pool.get().set(t); }
	public static Vector3f getInstance(Tup3fBase t) { return pool.get().set(t); }
	public static Vector3f getInstance(Tup3dBase t) { return pool.get().set(t); }
	public static Vector3f getInstance(Point3f p) { return pool.get().set(p); }
	public static Vector3f getInstance(float scalar) { return pool.get().set(scalar); }
	public static Vector3f getInstance(double scalar) { return pool.get().set(scalar); }
	public static Vector3f getInstance(float x, float y, float z) { return pool.get().set(x, y, z); }
	public static Vector3f getInstance(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void storeInstance(Vector3f v) { pool.store(v); }

	/*
	####################
	##                ##
	##  CONSTRUCTORS  ##
	##                ##
	####################
	 */
	
	public Vector3f() { this.x = 0; this.y = 0; this.z = 0; }
	
	public Vector3f(Vector3f v) { this.x = v.x; this.y = v.y; this.z = v.z; }
	public Vector3f(Vector3d v) { this.x = (float)v.x; this.y = (float)v.y; this.z = (float)v.z; }
	public Vector3f(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); }
	public Vector3f(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); }
	public Vector3f(Tuple3f t) { this.x = t.v[0]; this.y = t.v[1]; this.z = t.v[2]; }
	public Vector3f(Tuple3d t) { this.x = (float)t.v[0]; this.y = (float)t.v[1]; this.z = (float)t.v[2]; }
	public Vector3f(Tup3fBase t) { this.x = t.get(0); this.y = t.get(1); this.z = t.get(2); }
	public Vector3f(Tup3dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); this.z = (float)t.get(2); }
	public Vector3f(Point3f p) { this.x = p.x; this.y = p.y; this.z = p.z; }
	
	public Vector3f(float scalar) { this.x = scalar; this.y = scalar; this.z = scalar; }
	public Vector3f(double scalar) { this.x = (float)scalar; this.y = (float)scalar; this.z = (float)scalar; }
	
	public Vector3f(float x, float y, float z) { this.x = x; this.y = y; this.z = z; }
	public Vector3f(double x, double y, double z) { this.x = (float)x; this.y = (float)y; this.z = (float)z; }
	

	
	/*
	###############
	##           ##
	##  GETTERS  ##
	##           ##
	###############
	 */
	
	/** {@inheritDoc} */
	public float getX() { return this.x; }
	
	/** {@inheritDoc} */
	public float getY() { return this.y; }
	
	/** {@inheritDoc} */
	public float getZ() { return this.z; }
	
	
	
	/** {@inheritDoc} */
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
	
	/*
	###############
	##           ##
	##  SETTERS  ##
	##           ##
	###############
	 */

	/** {@inheritDoc} */
	public Vector3f setZero() { this.x = 0; this.y = 0; this.z = 0; return this; }
	
	
	/** {@inheritDoc} */
	public Vector3f set(Vector3f v) { this.x = v.x; this.y = v.y; this.z = v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Vector3d v) { this.x = (float)v.x; this.y = (float)v.y; this.z = (float)v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Tuple3f t) { this.x = t.v[0]; this.y = t.v[1]; this.z = t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Tuple3d t) { this.x = (float)t.v[0]; this.y = (float)t.v[1]; this.z = (float)t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Tup3fBase t) { this.x = t.get(0); this.y = t.get(1); this.z = t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Tup3dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); this.z = (float)t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Point3f p) { this.x = p.x; this.y = p.y; this.z = p.z; return this; }
	
	
	/** {@inheritDoc} */
	public Vector3f set(float scalar) { this.x = scalar; this.y = scalar; this.z = scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(double scalar) { this.x = (float)scalar; this.y = (float)scalar; this.z = (float)scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(float x, float y, float z) { this.x = x; this.y = y; this.z = z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(double x, double y, double z) { this.x = (float)x; this.y = (float)y; this.z = (float)z; return this;  }
	
	
	
	/** {@inheritDoc} */
	public Vector3f setX(float x) { this.x = x; return this; }
	
	/** {@inheritDoc} */
	public Vector3f setX(double x) { this.x = (float)x; return this; }
	
	/** {@inheritDoc} */
	public Vector3f setY(float y) { this.y = y; return this; }
	
	/** {@inheritDoc} */
	public Vector3f setY(double y) { this.y = (float)y; return this; }
	
	/** {@inheritDoc} */
	public Vector3f setZ(float z) { this.z = z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f setZ(double z) { this.z = (float)z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f set(int index, float value)
	{
		switch(index)
		{
			case 0: this.x = value; break;
			case 1: this.y = value; break;
			case 2: this.z = value; break;
		}
		return this;
	}
	
	/** {@inheritDoc} */
	public Vector3f set(int index, double value)
	{
		switch(index)
		{
			case 0: this.x = (float)value; break;
			case 1: this.y = (float)value; break;
			case 2: this.z = (float)value; break;
		}
		return this;
	}
	
	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** {@inheritDoc} */
	public Vector3f add(Vector3f v) { this.x += v.x; this.y += v.y; this.z += v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Vector3d v) { this.x += v.x; this.y += v.y; this.z += v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Vec3fBase v) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Vec3dBase v) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Tuple3f t) { this.x += t.v[0]; this.y += t.v[1]; this.z += t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Tuple3d t) { this.x += t.v[0]; this.y += t.v[1]; this.z += t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Tup3fBase t) { this.x += t.get(0); this.y += t.get(1); this.z += t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Tup3dBase t) { this.x += t.get(0); this.y += t.get(1); this.z += t.get(2); return this; }

	/** {@inheritDoc} */
	public Vector3f add(Point3f p) { this.x += p.x; this.y += p.y; this.z += p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(float scalar) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(double scalar) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(float x, float y, float z) { this.x += x; this.y += y; this.z += z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(double x, double y, double z) { this.x += x; this.y += y; this.z += z; return this; }

	
	
	/** {@inheritDoc} */
	public Vector3f sub(Vector3f v) { this.x -= v.x; this.y -= v.y; this.z -= v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Vector3d v) { this.x -= v.x; this.y -= v.y; this.z -= v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Vec3fBase v) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Vec3dBase v) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f sub(Tuple3f t) { this.x -= t.v[0]; this.y -= t.v[1]; this.z -= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Tuple3d t) { this.x -= t.v[0]; this.y -= t.v[1]; this.z -= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Tup3fBase t) { this.x -= t.get(0); this.y -= t.get(1); this.z -= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Tup3dBase t) { this.x -= t.get(0); this.y -= t.get(1); this.z -= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Point3f p) { this.x -= p.x; this.y -= p.y; this.z -= p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(float scalar) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(double scalar) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(float x, float y, float z) { this.x -= x; this.y -= y; this.z -= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(double x, double y, double z) { this.x -= x; this.y -= y; this.z -= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f mul(Vector3f v) { this.x *= v.x; this.y *= v.y; this.z *= v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Vector3d v) { this.x *= v.x; this.y *= v.y; this.z *= v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Vec3fBase v) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Vec3dBase v) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Tuple3f t) { this.x *= t.v[0]; this.y *= t.v[1]; this.z *= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Tuple3d t) { this.x *= t.v[0]; this.y *= t.v[1]; this.z *= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Tup3fBase t) { this.x *= t.get(0); this.y *= t.get(1); this.z *= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Tup3dBase t) { this.x *= t.get(0); this.y *= t.get(1); this.z *= t.get(2); return this; }

	/** {@inheritDoc} */
	public Vector3f mul(Point3f p) { this.x *= p.x; this.y *= p.y; this.z *= p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(float scalar) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(double scalar) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(float x, float y, float z) { this.x *= x; this.y *= y; this.z *= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(double x, double y, double z) { this.x *= x; this.y *= y; this.z *= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f div(Vector3f v) { this.x /= v.x; this.y /= v.y; this.z /= v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Vector3d v) { this.x /= v.x; this.y /= v.y; this.z /= v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Vec3fBase v) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Vec3dBase v) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Tuple3f t) { this.x /= t.v[0]; this.y /= t.v[1]; this.z /= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Tuple3d t) { this.x /= t.v[0]; this.y /= t.v[1]; this.z /= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Tup3fBase t) { this.x /= t.get(0); this.y /= t.get(1); this.z /= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Tup3dBase t) { this.x /= t.get(0); this.y /= t.get(1); this.z /= t.get(2); return this; }

	/** {@inheritDoc} */
	public Vector3f div(Point3f p) { this.x /= p.x; this.y /= p.y; this.z /= p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(float scalar) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(double scalar) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(float x, float y, float z) { this.x /= x; this.y /= y; this.z /= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(double x, double y, double z) { this.x /= x; this.y /= y; this.z /= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Vector3f v) { this.x = v.x - this.x; this.y = v.y - this.y; this.z = v.z - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Vector3d v) { this.x = (float)v.x - this.x; this.y = (float)v.y - this.y; this.z = (float)v.z - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Vec3fBase v) { this.x = v.getX() - this.x; this.y = v.getY() - this.y; this.z = v.getZ() - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Vec3dBase v) { this.x = (float)v.getX() - this.x; this.y = (float)v.getY() - this.y; this.z = (float)v.getZ() - this.z; return this; }

	/** {@inheritDoc} */
	public Vector3f invertFrom(Tuple3f t) { this.x = t.v[0] - this.x; this.y = t.v[1] - this.y; this.z = t.v[2] - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Tuple3d t) { this.x = (float)t.v[0] - this.x; this.y = (float)t.v[1] - this.y; this.z = (float)t.v[2] - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Tup3fBase t) { this.x = t.get(0) - this.x; this.y = t.get(1) - this.y; this.z = t.get(2) - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Tup3dBase t) { this.x = (float)t.get(0) - this.x; this.y = (float)t.get(1) - this.y; this.z = (float)t.get(2) - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Point3f p) { this.x = p.x - this.x; this.y = p.y - this.y; this.z = p.z - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(float max) { this.x = max - this.x; this.y = max - this.y; this.z = max - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(double max) { this.x = (float)max - this.x; this.y = (float)max - this.y; this.z = (float)max - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(float x, float y, float z) { this.x = x - this.x; this.y = y - this.y; this.z = z - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(double x, double y, double z) { this.x = (float)x - this.x; this.y = (float)y - this.y; this.z = (float)z - this.z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f negate() {  this.x = -this.x; this.y = -this.y; this.z = -this.z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f inverse() { this.x = 1 / this.x; this.y = 1 / this.y; this.z = 1 / this.z; return this; }
	
	
	
	
	
	/** {@inheritDoc} */
 	public Vector3f addN(Vector3f v) { return clone().add(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(Vector3d v) { return clone().add(v); }
	
	/** {@inheritDoc} */
 	public Vector3f addN(Vec3fBase v) { return clone().add(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(Vec3dBase v) { return clone().add(v); }
 	
	/** {@inheritDoc} */
 	public Vector3f addN(Tuple3f v) { return clone().add(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(Tuple3d v) { return clone().add(v); }
	
	/** {@inheritDoc} */
 	public Vector3f addN(Tup3fBase v) { return clone().add(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(Tup3dBase v) { return clone().add(v); }
 	
	/** {@inheritDoc} */
 	public Vector3f addN(Point3f v) { return clone().add(v); }

 	/** {@inheritDoc} */
 	public Vector3f addN(float scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(double scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Vector3f v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Vector3d v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Vec3fBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Vec3dBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Tuple3f v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Tuple3d v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Tup3fBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Tup3dBase v) { return clone().sub(v); }

 	/** {@inheritDoc} */
 	public Vector3f subN(Point3f v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(float scalar) { return clone().sub(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(double scalar) { return clone().sub(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Vector3f v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Vector3d v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Vec3fBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Vec3dBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Tuple3f v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Tuple3d v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Tup3fBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Tup3dBase v) { return clone().mul(v); }

 	/** {@inheritDoc} */
 	public Vector3f mulN(Point3f v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(float scalar) { return clone().mul(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(double scalar) { return clone().mul(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Vector3f v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Vector3d v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Vec3fBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Vec3dBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Tuple3f v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Tuple3d v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Tup3fBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Tup3dBase v) { return clone().div(v); }

 	/** {@inheritDoc} */
 	public Vector3f divN(Point3f v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(float scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(double scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }
 	
 	
 	
 	/** {@inheritDoc} */
	public Vector3f invertFromN(Vector3f v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(Vector3d v) { return clone().invertFrom(v); }
 	
 	/** {@inheritDoc} */
	public Vector3f invertFromN(Vec3fBase v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(Vec3dBase v) { return clone().invertFrom(v); }

 	/** {@inheritDoc} */
	public Vector3f invertFromN(Tuple3f v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(Tuple3d v) { return clone().invertFrom(v); }
 	
 	/** {@inheritDoc} */
	public Vector3f invertFromN(Tup3fBase v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(Tup3dBase v) { return clone().invertFrom(v); }
	
 	/** {@inheritDoc} */
	public Vector3f invertFromN(Point3f v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(float max) { return clone().invertFrom(max); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(double max) { return clone().invertFrom(max); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(float x, float y, float z) { return clone().invertFrom(x, y, z); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(double x, double y, double z) { return clone().invertFrom(x, y, z); }

	
	
	/** {@inheritDoc} */
	public Vector3f negateN() { return clone().negate(); }
	
	
	
	/** {@inheritDoc} */
	public Vector3f inverseN() { return clone().inverse(); }
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */

	/** {@inheritDoc} */
	public Vector3f normalize() { return this.x != 0  && this.y != 0 && this.z != 0 ? div(length()) : this; }
	
	/** {@inheritDoc} */
 	public Vector3f reflect(Vec3fBase normal)
	{
		double angle = dot(normal) * 2;
		
		this.x += -angle * normal.getX();
		this.y += -angle * normal.getY();
		this.z += -angle * normal.getZ();
		
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector3f reflect(Vec3dBase normal)
 	{
		double angle = dot(normal) * 2;
		
		this.x += -angle * normal.getX();
		this.y += -angle * normal.getY();
		this.z += -angle * normal.getZ();
		
		return this;
 	}
 	
 	
 	
 	/** {@inheritDoc} */
	public double length() { return Math.sqrt(squaredLength()); }
	
	/** {@inheritDoc} */
	public double squaredLength() { return this.x * this.x + this.y * this.y + this.z * this.z; }
	
	
	
	/** {@inheritDoc} */
 	public Vector3f cross(Vec3fBase v) 
	{
 		this.x = this.y * v.getZ() - this.z * v.getY();
 		this.y = this.z * v.getX() - this.x * v.getZ();
 		this.z = this.x * v.getY() - this.y * v.getX();
 		
 		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector3f cross(Vec3dBase v)
 	{
 		this.x = this.y * (float)v.getZ() - this.z * (float)v.getY();
 		this.y = this.z * (float)v.getX() - this.x * (float)v.getZ();
 		this.z = this.x * (float)v.getY() - this.y * (float)v.getX();
 		
 		return this;
 	}
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f project(Vec3fBase v)
	{	
		Vec3f vn = Vector3f.getInstance();
		vn.set(v).normalize();

		set(vn.mul(dot(vn)));
		
		Vector3f.storeInstance((Vector3f) vn);
		
		return this;
	}
	
 	/** {@inheritDoc} */
	public Vector3f project(Vec3dBase v)
	{
		Vec3f vn = Vector3f.getInstance();
		vn.set(v).normalize();

		set(vn.mul(dot(vn)));
		
		Vector3f.storeInstance((Vector3f) vn);
		
		return this;
	}

	
	
	/** {@inheritDoc} */
	public Vector3f rotate(Vec3dBase axis, float angle)
	{
 		Quaternion rotation = Quaternion.getInstance();
 		Quaternion w = Quaternion.getInstance();
 		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.getX() * sinHalfAngle;
		double rY = axis.getY() * sinHalfAngle;
		double rZ = axis.getZ() * sinHalfAngle;
		double rW = cosHalfAngle;
		
		rotation.set(rW, rX, rY, rZ);
		
		w.set(rotation);
		
		w.mul(this).mul(rotation.conjugate());
		
		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		Quaternion.storeInstance(rotation);
		Quaternion.storeInstance(w);
		
		return this;
	}

	/** {@inheritDoc} */
	public Vector3f rotate(Vec3fBase axis, double angle)
	{
 		Quaternion rotation = Quaternion.getInstance();
 		Quaternion w = Quaternion.getInstance();
 		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.getX() * sinHalfAngle;
		double rY = axis.getY() * sinHalfAngle;
		double rZ = axis.getZ() * sinHalfAngle;
		double rW = cosHalfAngle;
		
		rotation.set(rW, rX, rY, rZ);
		
		w.set(rotation);
		
		w.mul(this).mul(rotation.conjugate());
		
		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		Quaternion.storeInstance(rotation);
		Quaternion.storeInstance(w);
		
		return this;
	}

	/** {@inheritDoc} */
	public Vector3f rotate(Vec3dBase axis, double angle)
	{
 		Quaternion rotation = Quaternion.getInstance();
 		Quaternion w = Quaternion.getInstance();
 		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.getX() * sinHalfAngle;
		double rY = axis.getY() * sinHalfAngle;
		double rZ = axis.getZ() * sinHalfAngle;
		double rW = cosHalfAngle;
		
		rotation.set(rW, rX, rY, rZ);
		
		w.set(rotation);
		
		w.mul(this).mul(rotation.conjugate());
		
		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		Quaternion.storeInstance(rotation);
		Quaternion.storeInstance(w);
		
		return this;
	}
 	
	/** {@inheritDoc} */
 	public Vector3f rotate(Vec3fBase axis, float angle)
	{
 		Quaternion rotation = Quaternion.getInstance();
 		Quaternion w = Quaternion.getInstance();
 		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.getX() * sinHalfAngle;
		double rY = axis.getY() * sinHalfAngle;
		double rZ = axis.getZ() * sinHalfAngle;
		double rW = cosHalfAngle;
		
		rotation.set(rW, rX, rY, rZ);
		
		w.set(rotation);
		
		w.mul(this).mul(rotation.conjugate());
		
		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		Quaternion.storeInstance(rotation);
		Quaternion.storeInstance(w);
		
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector3f rotate(Quaternion q)
	{
 		Quaternion w = Quaternion.getInstance();
 		Quaternion _q = Quaternion.getInstance();
 		
 		_q.set(q);
 		
		w.set(q);
		
		w.mul(this).mul(_q.conjugate());
		
		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		Quaternion.storeInstance(w);
		Quaternion.storeInstance(_q);
		
		return this;
	}
 	
 	
 	
 	/** {@inheritDoc} */
	public double dot(Vec3fBase v) { return (double) this.x * v.getX() + this.y * v.getY() + this.z * v.getZ(); }
	
	/** {@inheritDoc} */
	public double dot(Vec3dBase v) { return (double) this.x * v.getX() + this.y * v.getY() + this.z * v.getZ(); }
	
	
	
	/** {@inheritDoc} */
	public double angleRad(Vec3fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	
	/** {@inheritDoc} */
	public double angleRad(Vec3dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	
	
	
	/** {@inheritDoc} */
	public double angleDeg(Vec3fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
	/** {@inheritDoc} */
	public double angleDeg(Vec3dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
 	
	
	/** {@inheritDoc} */
	public Vector3f normalizeN() { return clone().normalize(); }

	
 	
 	/** {@inheritDoc} */
 	public Vector3f crossN(Vec3fBase v) { return clone().cross(v); }
	
	/** {@inheritDoc} */
	public Vector3f crossN(Vec3dBase v) { return clone().cross(v); }

	
	
	/** {@inheritDoc} */
	public Vector3f projectN(Vec3fBase v) { return clone().project(v); }
	
	/** {@inheritDoc} */
	public Vector3f projectN(Vec3dBase v) { return clone().project(v); }
	
	
	
	/** {@inheritDoc} */
	public Vector3f reflectN(Vec3fBase normal) { return clone().reflect(normal); }
	
	/** {@inheritDoc} */
	public Vector3f reflectN(Vec3dBase normal) { return clone().reflect(normal); }

	
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Vec3fBase axis, float angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Vec3dBase axis, float angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Vec3fBase axis, double angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Vec3dBase axis, double angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Quaternion q) { return clone().rotate(q); }
 	
	/*
	############################
	##                        ##
	##  VECTOR INTERPOLATION  ##
	##                        ##
	############################
	 */

	/** {@inheritDoc} */
 	public Vector3f lerp(Vec3fBase v, float f)
	{
		this.x = this.x + (v.getX() - this.x) * f;
		this.y = this.y + (v.getY() - this.y) * f;
		this.z = this.z + (v.getZ() - this.z) * f;

		return this;
	}
 	
 	/** {@inheritDoc} */
	public Vector3f lerp(Vec3dBase v, float f)
	{
		this.x = this.x + ((float)v.getX() - this.x) * f;
		this.y = this.y + ((float)v.getY() - this.y) * f;
		this.z = this.z + ((float)v.getZ() - this.z) * f;

		return this;
	}
 	
	/** {@inheritDoc} */
	public Vector3f lerp(Vec3fBase v, double f)
	{
		this.x = this.x + (v.getX() - this.x) * (float)f;
		this.y = this.y + (v.getY() - this.y) * (float)f;
		this.z = this.z + (v.getZ() - this.z) * (float)f;

		return this;
	}

	/** {@inheritDoc} */
	public Vector3f lerp(Vec3dBase v, double f)
	{
		this.x = this.x + ((float)v.getX() - this.x) * (float)f;
		this.y = this.y + ((float)v.getY() - this.y) * (float)f;
		this.z = this.z + ((float)v.getZ() - this.z) * (float)f;

		return this;
	}
	
	
	
	/** {@inheritDoc} */
 	public Vector3f slerp(Vec3fBase v, double f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
		float z = (float) (z_1 + z_2);
		
		this.x = x;
		this.y = y; 
		this.z = z;
		
		return this;
	}
	
 	/** {@inheritDoc} */
	public Vector3f slerp(Vec3dBase v, double f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
		float z = (float) (z_1 + z_2);
		
		this.x = x;
		this.y = y; 
		this.z = z;
		
		return this;
	}
	
	/** {@inheritDoc} */
	public Vector3f slerp(Vec3fBase v, float f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
		float z = (float) (z_1 + z_2);
		
		this.x = x;
		this.y = y; 
		this.z = z;
		
		return this;
	}

	/** {@inheritDoc} */
	public Vector3f slerp(Vec3dBase v, float f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
		float z = (float) (z_1 + z_2);
		
		this.x = x;
		this.y = y; 
		this.z = z;
		
		return this;
	}
	
	
	
	/** {@inheritDoc} */
	public Vector3f lerpN(Vec3fBase v, float f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector3f lerpN(Vec3dBase v, float f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector3f lerpN(Vec3fBase v, double f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector3f lerpN(Vec3dBase v, double f) { return clone().lerp(v, f); }

	
	
	/** {@inheritDoc} */
	public Vector3f slerpN(Vec3fBase v, float f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector3f slerpN(Vec3dBase v, float f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector3f slerpN(Vec3fBase v, double f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector3f slerpN(Vec3dBase v, double f) { return clone().slerp(v, f); }
	
	/*
	#######################
	##                   ##
	##  OBJECT OVERRIDE  ##
	##                   ##
	#######################
	 */
	
	/** {@inheritDoc} */
	@Override
	public Vector3f clone() { return new Vector3f(this); }
	
	
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector3f)) return false;
		Vector3f v = (Vector3f)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		
		return true;
	}
	
	
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec3f(" + this.x + "f, " + this.y + "f, " + this.z + "f)"; }

}