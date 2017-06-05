package cmn.utilslib.vector;


import cmn.utilslib.essentials.Check;
import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.api.Vec3f;
import cmn.utilslib.vector.api.Vec3fBase;


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
	
	

	public Vector3f() { setZero(); }
	
	public Vector3f(float scalar) { set(scalar); }
	
	public Vector3f(float x, float y, float z) { set(x, y, z); }
	public Vector3f(Vec3fBase v) { set(v); }
	
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

	public Vector3f setZero() { return set(0.0f); }
	
	public Vector3f set(Vec3fBase v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3f set(float scalar) { return set(scalar, scalar, scalar); }
	public Vector3f set(double scalar) { return set(scalar, scalar, scalar); }
	public Vector3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	public Vector3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }
	
	public Vector3f setX(float x) { this.x = x; return this; }
	public Vector3f setX(double x) { this.x = (float)x; return this; }
	public Vector3f setY(float y) { this.y = y; return this; }
	public Vector3f setY(double y) { this.y = (float)y; return this; }
	public Vector3f setZ(float z) { this.z = z; return this; }
	public Vector3f setZ(double z) { this.z = (float)z; return this; }
	
	public Vector3f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector3f invert() { return mul(-1.0f); }
	
	public Vector3f add(Vec3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	public Vector3f add(double scalar) { return add(scalar, scalar, scalar); }
	public Vector3f add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }
	public Vector3f add(double x, double y, double z) { return set(getX() + x, getY() + y, getZ() + z); }

	public Vector3f sub(Vec3fBase v) { return sub(v.getX(), v.getY(), v.getZ()); }
	public Vector3f sub(double scalar) { return sub(scalar, scalar, scalar); }
	public Vector3f sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	public Vector3f sub(double x, double y, double z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	public Vector3f mul(Vec3fBase v) { return mul(v.getX(), v.getY(), v.getZ()); }
	public Vector3f mul(double scalar) { return mul(scalar, scalar, scalar); }
	public Vector3f mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	public Vector3f mul(double x, double y, double z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	public Vector3f div(Vec3fBase v) { return div(v.getX(), v.getY(), v.getZ()); }
	public Vector3f div(double scalar) { return div(scalar, scalar, scalar); }
	public Vector3f div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
	public Vector3f div(double x, double y, double z) { return set(getX() / x, getY() / y, getZ() / z); }
	
	
 	public Vector3f inverted() { return clone().invert(); }
	
 	public Vector3f normalized() { return clone().normalize(); }
	
 	public Vector3f addN(Vec3fBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3f addN(float scalar) { return addN(scalar, scalar, scalar); }
 	public Vector3f addN(double scalar) { return addN(scalar, scalar, scalar); }
 	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
 	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	
 	public Vector3f subN(Vec3fBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3f subN(float scalar) { return subN(scalar, scalar, scalar); }
 	public Vector3f subN(double scalar) { return subN(scalar, scalar, scalar); }	
 	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
 	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
 	public Vector3f mulN(Vec3fBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3f mulN(float scalar) { return mulN(scalar, scalar, scalar); }
 	public Vector3f mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
 	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
 	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
 	public Vector3f divN(Vec3fBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3f divN(float scalar) { return divN(scalar, scalar, scalar); }
 	public Vector3f divN(double scalar) { return divN(scalar, scalar, scalar); }
 	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
 	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }
	
	
 	
 	public Vector3f reflect(Vec3fBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		
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

		double x_1 = (1 - f)	* sinAngle / sinAngle * getX();
		double x_2 = f			* sinAngle / sinAngle * v.getX();
		float x = (float) (x_1 + x_2);
		
		double y_1 = (1 - f)	* sinAngle / sinAngle * getY();
		double y_2 = f			* sinAngle / sinAngle * v.getY();
		float y = (float) (y_1 + y_2);
		
		double z_1 = (1 - f)	* sinAngle / sinAngle * getZ();
		double z_2 = f			* sinAngle / sinAngle * v.getZ();
		float z = (float) (z_1 + z_2);
		
		return new Vector3f(x, y, z);
	}
	
	
	
 	public Vector3f cross(Vec3fBase v) 
	{
		return new Vector3f(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
 	public Vector3f project(Vec3fBase v)
	{	
		Vector3f vn = (Vector3f) v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
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
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector3f((float)w.getX(), (float)w.getY(), (float)w.getZ());
	}

	
 	public Vector3f reflected(Vec3fBase normal)
	{
		Vector3f out = clone();
		
		out.reflect(normal);
		
		return out;
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