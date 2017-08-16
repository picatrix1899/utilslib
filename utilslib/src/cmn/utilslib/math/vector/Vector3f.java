package cmn.utilslib.math.vector;


import cmn.utilslib.Allocator;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
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
	
	private static Allocator<Vector3f> allocator = new Allocator<Vector3f>(Vector3f.class);
	
	public static Vector3f alloc() { return allocator.alloc().setZero(); }
	public static Vector3f alloc(Vec3fBase v) { return allocator.alloc().set(v); }
	public static Vector3f alloc(Vec3dBase v) { return allocator.alloc().set(v); }
	public static Vector3f alloc(Tup3fBase t) { return allocator.alloc().set(t); }
	public static Vector3f alloc(Tup3dBase t) { return allocator.alloc().set(t); }
	public static Vector3f alloc(float scalar) { return allocator.alloc().set(scalar); }
	public static Vector3f alloc(double scalar) { return allocator.alloc().set(scalar); }
	public static Vector3f alloc(float x, float y, float z) { return allocator.alloc().set(x, y, z); }
	public static Vector3f alloc(double x, double y, double z) { return allocator.alloc().set(x, y, z); }
	
	public static void dealloc(Vector3f v) { allocator.dealloc(v); }

	/*
	####################
	##                ##
	##  CONSTRUCTORS  ##
	##                ##
	####################
	 */
	
	public Vector3f() { this.x = 0; this.y = 0; this.z = 0; }
	
	public Vector3f(float scalar) { this.x = scalar; this.y = scalar; this.z = scalar; }
	public Vector3f(double scalar) { this.x = (float)scalar; this.y = (float)scalar; this.z = (float)scalar; }
	
	public Vector3f(float x, float y, float z) { this.x = x; this.y = y; this.z = z; }
	public Vector3f(double x, double y, double z) { this.x = (float)x; this.y = (float)y; this.z = (float)z; }
	
	public Vector3f(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); }
	public Vector3f(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); }
	public Vector3f(Tup3fBase t) { this.x = t.get(0); this.y = t.get(1); this.z = t.get(2); }
	public Vector3f(Tup3dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); this.z = (float)t.get(2); }
	
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
	public Vector3f set(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Tup3fBase t) { this.x = t.get(0); this.y = t.get(1); this.z = t.get(2); return this; }
	
	/** {@inheritDoc} */
	public Vector3f set(Tup3dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); this.z = (float)t.get(2); return this; }
	
	
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
	public Vector3f add(Vec3fBase v) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(Vec3dBase v) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f add(float scalar) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(double scalar) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(float x, float y, float z) { this.x += x; this.y += y; this.z += z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f add(double x, double y, double z) { this.x += x; this.y += y; this.z += z; return this; }

	
	
	/** {@inheritDoc} */
	public Vector3f sub(Vec3fBase v) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(Vec3dBase v) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f sub(float scalar) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(double scalar) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(float x, float y, float z) { this.x -= x; this.y -= y; this.z -= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f sub(double x, double y, double z) { this.x -= x; this.y -= y; this.z -= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f mul(Vec3fBase v) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(Vec3dBase v) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f mul(float scalar) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(double scalar) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(float x, float y, float z) { this.x *= x; this.y *= y; this.z *= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f mul(double x, double y, double z) { this.x *= x; this.y *= y; this.z *= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f div(Vec3fBase v) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(Vec3dBase v) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }

	/** {@inheritDoc} */
	public Vector3f div(float scalar) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(double scalar) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(float x, float y, float z) { this.x /= x; this.y /= y; this.z /= z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f div(double x, double y, double z) { this.x /= x; this.y /= y; this.z /= z; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Vec3fBase v) { this.x = v.getX() - this.x; this.y = v.getY() - this.y; this.z = v.getZ() - this.z; return this; }
	
	/** {@inheritDoc} */
	public Vector3f invertFrom(Vec3dBase v) { this.x = (float)v.getX() - this.x; this.y = (float)v.getY() - this.y; this.z = (float)v.getZ() - this.z; return this; }

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
 	public Vector3f addN(Vec3fBase v) { return clone().add(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(Vec3dBase v) { return clone().add(v); }

 	/** {@inheritDoc} */
 	public Vector3f addN(float scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(double scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Vec3fBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(Vec3dBase v) { return clone().sub(v); }

 	/** {@inheritDoc} */
 	public Vector3f subN(float scalar) { return clone().sub(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(double scalar) { return clone().sub(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Vec3fBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(Vec3dBase v) { return clone().mul(v); }

 	/** {@inheritDoc} */
 	public Vector3f mulN(float scalar) { return clone().mul(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(double scalar) { return clone().mul(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Vec3fBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(Vec3dBase v) { return clone().div(v); }

 	/** {@inheritDoc} */
 	public Vector3f divN(float scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(double scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
 	
 	/** {@inheritDoc} */
 	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }
 	
 	
 	
 	/** {@inheritDoc} */
	public Vector3f invertFromN(Vec3fBase v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector3f invertFromN(Vec3dBase v) { return clone().invertFrom(v); }

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
		Vec3f vn = Vector3f.alloc();
		vn.set(v).normalize();

		set(vn.mul(dot(vn)));
		
		Vector3f.dealloc((Vector3f) vn);
		
		return this;
	}
	
 	/** {@inheritDoc} */
	public Vector3f project(Vec3dBase v)
	{
		Vec3f vn = Vector3f.alloc();
		vn.set(v).normalize();

		set(vn.mul(dot(vn)));
		
		Vector3f.dealloc((Vector3f) vn);
		
		return this;
	}

	
	
	/** {@inheritDoc} */
	public Vector3f rotate(Vec3dBase axis, float angle)
	{
 		Quaternion rotation = Quaternion.alloc();
 		Quaternion w = Quaternion.alloc();
 		
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
		
		Quaternion.dealloc(rotation);
		Quaternion.dealloc(w);
		
		return this;
	}

	/** {@inheritDoc} */
	public Vector3f rotate(Vec3fBase axis, double angle)
	{
 		Quaternion rotation = Quaternion.alloc();
 		Quaternion w = Quaternion.alloc();
 		
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
		
		Quaternion.dealloc(rotation);
		Quaternion.dealloc(w);
		
		return this;
	}

	/** {@inheritDoc} */
	public Vector3f rotate(Vec3dBase axis, double angle)
	{
 		Quaternion rotation = Quaternion.alloc();
 		Quaternion w = Quaternion.alloc();
 		
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
		
		Quaternion.dealloc(rotation);
		Quaternion.dealloc(w);
		
		return this;
	}
 	
	/** {@inheritDoc} */
 	public Vector3f rotate(Vec3fBase axis, float angle)
	{
 		Quaternion rotation = Quaternion.alloc();
 		Quaternion w = Quaternion.alloc();
 		
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
		
		Quaternion.dealloc(rotation);
		Quaternion.dealloc(w);
		
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector3f rotate(Quaternion q)
	{
 		Quaternion w = Quaternion.alloc();
 		Quaternion _q = Quaternion.alloc();
 		
 		_q.set(q);
 		
		w.set(q);
		
		w.mul(this).mul(_q.conjugate());
		
		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		Quaternion.dealloc(w);
		Quaternion.dealloc(_q);
		
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