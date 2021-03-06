package cmn.utilslib.math.vector;


import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;
import cmn.utilslib.math.vector.api.Vec3fConstants;


/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector3f implements Vec3f, Vec3fConstants
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
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	


	/*
	####################
	##                ##
	##  CONSTRUCTORS  ##
	##                ##
	####################
	 */
	
	public Vector3f() { this.x = 0; this.y = 0; this.z = 0; }
	
	public Vector3f(Vector3f v) { this.x = v.x; this.y = v.y; this.z = v.z; }
	public Vector3f(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); }
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
	public Vector3f set(Vec3f v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); return this; }

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
	public Vector3f add(Vec3f v) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }

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
	public Vector3f sub(Vec3f v) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }

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
	public Vector3f mul(Vec3f v) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }

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
	public Vector3f div(Vec3f v) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }

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
	public Vector3f invertFrom(Vec3f v) { this.x = v.getX() - this.x; this.y = v.getY() - this.y; this.z = v.getZ() - this.z; return this; }

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
	
	
	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** {@inheritDoc} */
	public Vector3f add(Vector3f v, Vector3f dst) { this.x += v.x; this.y += v.y; this.z += v.z; return this; }

	/** {@inheritDoc} */
	public Vector3f add(Vec3f v, Vector3f dst) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f add(Tuple3f t, Vector3f dst) { this.x += t.v[0]; this.y += t.v[1]; this.z += t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Tuple3d t, Vector3f dst) { this.x += t.v[0]; this.y += t.v[1]; this.z += t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Tup3fBase t, Vector3f dst) { this.x += t.get(0); this.y += t.get(1); this.z += t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Tup3dBase t, Vector3f dst) { this.x += t.get(0); this.y += t.get(1); this.z += t.get(2); return this; }

	/** {@inheritDoc} */
	public Vector3f add(Point3f p, Vector3f dst) { this.x += p.x; this.y += p.y; this.z += p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(float scalar, Vector3f dst) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(double scalar, Vector3f dst) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(float x, float y, float z, Vector3f dst) { this.x += x; this.y += y; this.z += z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(double x, double y, double z, Vector3f dst) { this.x += x; this.y += y; this.z += z; return this; }

	
	
	/** {@inheritDoc} */
	public Vector3f sub(Vector3f v, Vector3f dst) { this.x -= v.x; this.y -= v.y; this.z -= v.z; return this; }

	/** {@inheritDoc} */
	public Vector3f sub(Vec3f v, Vector3f dst) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f sub(Tuple3f t, Vector3f dst) { this.x -= t.v[0]; this.y -= t.v[1]; this.z -= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Tuple3d t, Vector3f dst) { this.x -= t.v[0]; this.y -= t.v[1]; this.z -= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Tup3fBase t, Vector3f dst) { this.x -= t.get(0); this.y -= t.get(1); this.z -= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Tup3dBase t, Vector3f dst) { this.x -= t.get(0); this.y -= t.get(1); this.z -= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Point3f p, Vector3f dst) { this.x -= p.x; this.y -= p.y; this.z -= p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(float scalar, Vector3f dst) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(double scalar, Vector3f dst) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(float x, float y, float z, Vector3f dst) { this.x -= x; this.y -= y; this.z -= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(double x, double y, double z, Vector3f dst) { this.x -= x; this.y -= y; this.z -= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f mul(Vector3f v, Vector3f r) { this.x *= v.x; this.y *= v.y; this.z *= v.z; return this; }

	/** {@inheritDoc} */
	public Vector3f mul(Vec3f v, Vector3f r) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f mul(Tuple3f t, Vector3f dst) { this.x *= t.v[0]; this.y *= t.v[1]; this.z *= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Tuple3d t, Vector3f dst) { this.x *= t.v[0]; this.y *= t.v[1]; this.z *= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Tup3fBase t, Vector3f dst) { this.x *= t.get(0); this.y *= t.get(1); this.z *= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Tup3dBase t, Vector3f dst) { this.x *= t.get(0); this.y *= t.get(1); this.z *= t.get(2); return this; }

	/** {@inheritDoc} */
	public Vector3f mul(Point3f p, Vector3f dst) { this.x *= p.x; this.y *= p.y; this.z *= p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(float scalar, Vector3f dst) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(double scalar, Vector3f dst) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(float x, float y, float z, Vector3f dst) { this.x *= x; this.y *= y; this.z *= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(double x, double y, double z, Vector3f dst) { this.x *= x; this.y *= y; this.z *= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f div(Vector3f v, Vector3f dst) { this.x /= v.x; this.y /= v.y; this.z /= v.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Vec3f v, Vector3f dst) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f div(Tuple3f t, Vector3f dst) { this.x /= t.v[0]; this.y /= t.v[1]; this.z /= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Tuple3d t, Vector3f dst) { this.x /= t.v[0]; this.y /= t.v[1]; this.z /= t.v[2]; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Tup3fBase t, Vector3f dst) { this.x /= t.get(0); this.y /= t.get(1); this.z /= t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Tup3dBase t, Vector3f dst) { this.x /= t.get(0); this.y /= t.get(1); this.z /= t.get(2); return this; }

	/** {@inheritDoc} */
	public Vector3f div(Point3f p, Vector3f dst) { this.x /= p.x; this.y /= p.y; this.z /= p.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(float scalar, Vector3f dst) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(double scalar, Vector3f dst) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(float x, float y, float z, Vector3f dst) { this.x /= x; this.y /= y; this.z /= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(double x, double y, double z, Vector3f dst) { this.x /= x; this.y /= y; this.z /= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Vector3f v, Vector3f dst) { this.x = v.x - this.x; this.y = v.y - this.y; this.z = v.z - this.z; return this; }

	/** {@inheritDoc} */
	public Vector3f invertFrom(Vec3f v, Vector3f dst) { this.x = v.getX() - this.x; this.y = v.getY() - this.y; this.z = v.getZ() - this.z; return this; }

	/** {@inheritDoc} */
	public Vector3f invertFrom(Tuple3f t, Vector3f dst) { this.x = t.v[0] - this.x; this.y = t.v[1] - this.y; this.z = t.v[2] - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Tuple3d t, Vector3f dst) { this.x = (float)t.v[0] - this.x; this.y = (float)t.v[1] - this.y; this.z = (float)t.v[2] - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Tup3fBase t, Vector3f dst) { this.x = t.get(0) - this.x; this.y = t.get(1) - this.y; this.z = t.get(2) - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Tup3dBase t, Vector3f dst) { this.x = (float)t.get(0) - this.x; this.y = (float)t.get(1) - this.y; this.z = (float)t.get(2) - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Point3f p, Vector3f dst) { this.x = p.x - this.x; this.y = p.y - this.y; this.z = p.z - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(float max, Vector3f dst) { this.x = max - this.x; this.y = max - this.y; this.z = max - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(double max, Vector3f dst) { this.x = (float)max - this.x; this.y = (float)max - this.y; this.z = (float)max - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(float x, float y, float z, Vector3f dst) { this.x = x - this.x; this.y = y - this.y; this.z = z - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(double x, double y, double z, Vector3f dst) { this.x = (float)x - this.x; this.y = (float)y - this.y; this.z = (float)z - this.z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f negate(Vector3f dst) {  this.x = -this.x; this.y = -this.y; this.z = -this.z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f inverse(Vector3f dst) { this.x = 1 / this.x; this.y = 1 / this.y; this.z = 1 / this.z; return this; }
	
	
	
	
	
	/** {@inheritDoc} */
 	public Vector3f addN(Vector3f v) { return clone().add(v); }

	/** {@inheritDoc} */
 	public Vector3f addN(Vec3f v) { return clone().add(v); }
 	
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
 	public Vector3f subN(Vec3f v) { return clone().sub(v); }
 	
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
 	public Vector3f mulN(Vec3f v) { return clone().mul(v); }
 	
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
 	public Vector3f divN(Vec3f v) { return clone().div(v); }
 	
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
	public Vector3f invertFromN(Vec3f v) { return clone().invertFrom(v); }

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
	public Vector3f normalize() { return this.x + this.y + this.z != 0 ? div(length()) : this; }
	
	/** {@inheritDoc} */
 	public Vector3f reflect(Vec3f normal)
	{
		double angle = dot(normal) * 2;
		
		this.x -= angle * normal.getX();
		this.y -= angle * normal.getY();
		this.z -= angle * normal.getZ();
		
		return this;
	}

 	
 	
 	
 	/** {@inheritDoc} */
	public double length() { return Math.sqrt(squaredLength()); }
	
	/** {@inheritDoc} */
	public double squaredLength() { return this.x * this.x + this.y * this.y + this.z * this.z; }
	
	
	
	/** {@inheritDoc} */
 	public Vector3f cross(Vec3f v) 
	{
 		float x_ = this.y * v.getZ() - this.z * v.getY();
 		float y_= this.z * v.getX() - this.x * v.getZ();
 		float z_ = this.x * v.getY() - this.y * v.getX();
 		
 		this.x = x_;
 		this.y = y_;
 		this.z = z_;
 		
 		return this;
	}

	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f project(Vec3f v)
	{	
		Vector3f vn = new Vector3f(v);
		vn.normalize();

		set(vn.mul(dot(vn)));
		
		return this;
	}


	
	

	/** {@inheritDoc} */
	public Vector3f rotate(Vec3f axis, double angle)
	{
 		Quaternion rotation = new Quaternion();
 		Quaternion w = new Quaternion();
 		
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
		
		return this;
	}
 	
	/** {@inheritDoc} */
 	public Vector3f rotate(Vec3f axis, float angle)
	{
 		Quaternion rotation = new Quaternion();
 		Quaternion w = new Quaternion();
 		
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
		
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector3f rotate(Quaternion q)
	{
 		Quaternion w = new Quaternion();
 		Quaternion _q = new Quaternion();
 		
 		_q.set(q);
 		
		w.set(q);
		
		w.mul(this).mul(_q.conjugate());
		
		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		return this;
	}
 	
 	
 	
 	/** {@inheritDoc} */
	public double dot(Vec3f v) { return (double) this.x * v.getX() + this.y * v.getY() + this.z * v.getZ(); }
	
	
	
	/** {@inheritDoc} */
	public double angleRad(Vec3f v) { return Math.acos((dot(v)) / (length() * v.length())); }
	
	
	
	/** {@inheritDoc} */
	public double angleDeg(Vec3f v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
 	
	
	/** {@inheritDoc} */
	public Vector3f normalizeN() { return clone().normalize(); }

	
 	
 	/** {@inheritDoc} */
 	public Vector3f crossN(Vec3f v) { return clone().cross(v); }

	
	
	/** {@inheritDoc} */
	public Vector3f projectN(Vec3f v) { return clone().project(v); }
	
	
	
	/** {@inheritDoc} */
	public Vector3f reflectN(Vec3f normal) { return clone().reflect(normal); }

	
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Vec3f axis, float angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Vec3f axis, double angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector3f rotateN(Quaternion q) { return clone().rotate(q); }
 	

	
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