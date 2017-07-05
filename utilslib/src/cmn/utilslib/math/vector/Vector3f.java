package cmn.utilslib.math.vector;


import cmn.utilslib.Allocator;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
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

	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	

	private static Allocator<Vector3f> allocator = new Allocator<Vector3f>(Vector3f.class);
	
	public static Vector3f alloc() { return allocator.alloc(); }
	
	public static void dealloc(Vector3f v) { allocator.dealloc(v); }

	
	
	public Vector3f() { this.x = 0; this.y = 0; this.z = 0; }
	
	public Vector3f(float scalar) { this.x = scalar; this.y = scalar; this.z = scalar; }
	public Vector3f(double scalar) { this.x = (float)scalar; this.y = (float)scalar; this.z = (float)scalar; }
	
	public Vector3f(float x, float y, float z) { this.x = x; this.y = y; this.z = z; }
	public Vector3f(double x, double y, double z) { this.x = (float)x; this.y = (float)y; this.z = (float)z; }
	
	public Vector3f(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); }
	public Vector3f(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); }
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */

	public Vector3f setZero() { this.x = 0; this.y = 0; this.z = 0; return this; }
	
	public Vector3f set(Vec3fBase v) { this.x = v.getX(); this.y = v.getY(); this.z = v.getZ(); return this; }
	public Vector3f set(Vec3dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); this.z = (float)v.getZ(); return this; }
	
	public Vector3f set(float scalar) { this.x = scalar; this.y = scalar; this.z = scalar; return this; }
	public Vector3f set(double scalar) { this.x = (float)scalar; this.y = (float)scalar; this.z = (float)scalar; return this; }
	public Vector3f set(float x, float y, float z) { this.x = x; this.y = y; this.z = z; return this; }
	public Vector3f set(double x, double y, double z) { this.x = (float)x; this.y = (float)y; this.z = (float)z; return this;  }
	
	public Vector3f setX(float x) { this.x = x; return this; }
	public Vector3f setX(double x) { this.x = (float)x; return this; }
	public Vector3f setY(float y) { this.y = y; return this; }
	public Vector3f setY(double y) { this.y = (float)y; return this; }
	public Vector3f setZ(float z) { this.z = z; return this; }
	public Vector3f setZ(double z) { this.z = (float)z; return this; }
	
	public Vector3f normalize() { return this.x != 0  && this.y != 0 && this.z != 0 ? div(length()) : this; }
	
	public Vector3f invert() { this.x = -this.x; this.y = -this.y; this.z = -this.z; return this; }
	
	public Vector3f add(Vec3fBase v) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }
	public Vector3f add(Vec3dBase v) { this.x += v.getX(); this.y += v.getY(); this.z += v.getZ(); return this; }
	public Vector3f add(float scalar) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	public Vector3f add(double scalar) { this.x += scalar; this.y += scalar; this.z += scalar; return this; }
	public Vector3f add(float x, float y, float z) { this.x += x; this.y += y; this.z += z; return this; }
	public Vector3f add(double x, double y, double z) { this.x += x; this.y += y; this.z += z; return this; }

	public Vector3f sub(Vec3fBase v) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }
	public Vector3f sub(Vec3dBase v) { this.x -= v.getX(); this.y -= v.getY(); this.z -= v.getZ(); return this; }
	public Vector3f sub(float scalar) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	public Vector3f sub(double scalar) { this.x -= scalar; this.y -= scalar; this.z -= scalar; return this; }
	public Vector3f sub(float x, float y, float z) { this.x -= x; this.y -= y; this.z -= z; return this; }
	public Vector3f sub(double x, double y, double z) { this.x -= x; this.y -= y; this.z -= z; return this; }
	
	public Vector3f mul(Vec3fBase v) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }
	public Vector3f mul(Vec3dBase v) { this.x *= v.getX(); this.y *= v.getY(); this.z *= v.getZ(); return this; }
	public Vector3f mul(float scalar) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	public Vector3f mul(double scalar) { this.x *= scalar; this.y *= scalar; this.z *= scalar; return this; }
	public Vector3f mul(float x, float y, float z) { this.x *= x; this.y *= y; this.z *= z; return this; }
	public Vector3f mul(double x, double y, double z) { this.x *= x; this.y *= y; this.z *= z; return this; }
	
	public Vector3f div(Vec3fBase v) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }
	public Vector3f div(Vec3dBase v) { this.x /= v.getX(); this.y /= v.getY(); this.z /= v.getZ(); return this; }
	public Vector3f div(float scalar) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	public Vector3f div(double scalar) { this.x /= scalar; this.y /= scalar; this.z /= scalar; return this; }
	public Vector3f div(float x, float y, float z) { this.x /= x; this.y /= y; this.z /= z; return this; }
	public Vector3f div(double x, double y, double z) { this.x /= x; this.y /= y; this.z /= z; return this; }
	
	
 	public Vector3f inverted() { return clone().invert(); }
	
 	public Vector3f normalized() { return clone().normalize(); }
	
 	public Vector3f addN(Vec3fBase v) { return clone().add(v); }
 	public Vector3f addN(Vec3dBase v) { return clone().add(v); }
 	public Vector3f addN(float scalar) { return clone().add(scalar); }
 	public Vector3f addN(double scalar) { return clone().add(scalar); }
 	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
 	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	
 	public Vector3f subN(Vec3fBase v) { return clone().sub(v); }
 	public Vector3f subN(Vec3dBase v) { return clone().sub(v); }
 	public Vector3f subN(float scalar) { return clone().sub(scalar); }
 	public Vector3f subN(double scalar) { return clone().sub(scalar); }	
 	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
 	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
 	public Vector3f mulN(Vec3fBase v) { return clone().mul(v); }
 	public Vector3f mulN(Vec3dBase v) { return clone().mul(v); }
 	public Vector3f mulN(float scalar) { return clone().mul(scalar); }
 	public Vector3f mulN(double scalar) { return clone().mul(scalar); }	
 	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
 	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
 	public Vector3f divN(Vec3fBase v) { return clone().div(v); }
 	public Vector3f divN(Vec3dBase v) { return clone().div(v); }
 	public Vector3f divN(float scalar) { return clone().div(scalar); }
 	public Vector3f divN(double scalar) { return clone().div(scalar); }
 	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
 	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }
 	
 	
 	
 	public Vector3f reflect(Vec3fBase normal)
	{
		double angle = dot(normal) * 2;
		
		this.x += -angle * normal.getX();
		this.y += -angle * normal.getY();
		this.z += -angle * normal.getZ();
		
		return this;
	}
	
 	public Vector3f lerp(Vec3fBase v, float f)
	{
 		Vector3f out = new Vector3f();
 		
		out.setX(getX() + (v.getX() - getX()) * f);
		out.setY(getY() + (v.getY() - getY()) * f);
		out.setZ(getZ() + (v.getZ() - getZ()) * f);
		
		return out;
	}
	
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
		
		return new Vector3f(x, y, z);
	}
	
	public double dot(Vec3fBase v) { return (double) this.x * v.getX() + this.y * v.getY() + this.z * v.getZ(); }
	
	public double angleRad(Vec3fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	public double angleDeg(Vec3fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	public double length() { return Math.sqrt(squaredLength()); }
	public double squaredLength() { return this.x * this.x + this.y * this.y + this.z * this.z; }
	
 	public Vector3f cross(Vec3fBase v) 
	{
		return new Vector3f(this.y * v.getZ() - this.z * v.getY(), this.z * v.getX() - this.x * v.getZ(), this.x * v.getY() - this.y * v.getX());
	}
	
 	public Vector3f project(Vec3fBase v)
	{	
		Vector3f vn = (Vector3f) v.normalized();

		 return vn.mul(dot(vn));
	}
	
	
 	public Vector3f rot(Vec3fBase axis, float angle)
	{
		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.getX() * sinHalfAngle;
		double rY = axis.getY() * sinHalfAngle;
		double rZ = axis.getZ() * sinHalfAngle;
		double rW = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(rW, rX, rY, rZ);
		
		return rot(rotation);
	}
 	
 	public Vector3f rot(Quaternion q)
	{
		Quaternion w = q.mulN(this).mulN(q.conjugated());

		return new Vector3f((float)w.getX(), (float)w.getY(), (float)w.getZ());
	}
 	
 	public Vector3f rotate(Quaternion q)
	{
		Quaternion w = q.mulN(this).mulN(q.conjugated());

		this.x = (float)w.getX();
		this.y = (float)w.getY();
		this.z = (float)w.getZ();
		
		return this;
	}

	
 	public Vector3f reflected(Vec3fBase normal)
	{	
		return clone().reflect(normal);
	}
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
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