package cmn.utilslib.math.vector;


import cmn.utilslib.essentials.Check;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec3d;
import cmn.utilslib.math.vector.api.Vec3dBase;



/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector3d implements Vec3d
{

	public double x = 0.0f;
	public double y = 0.0f;
	public double z = 0.0f;
	
	

	public Vector3d() { setZero(); }
	
	public Vector3d(double scalar) { set(scalar); }
	
	public Vector3d(double x, double y, double z) { set(x, y, z); }
	public Vector3d(Vec3dBase v) { set(v); }
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public double getZ() { return this.z; }
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */

	public Vector3d setZero() { return set(0.0f); }
	
	public Vector3d set(Vec3dBase v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d set(float scalar) { return set(scalar, scalar, scalar); }
	public Vector3d set(double scalar) { return set(scalar, scalar, scalar); }
	public Vector3d set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	public Vector3d set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }
	
	public Vector3d setX(float x) { this.x = x; return this; }
	public Vector3d setX(double x) { this.x = (float)x; return this; }
	public Vector3d setY(float y) { this.y = y; return this; }
	public Vector3d setY(double y) { this.y = (float)y; return this; }
	public Vector3d setZ(float z) { this.z = z; return this; }
	public Vector3d setZ(double z) { this.z = (float)z; return this; }
	
	
	
	
	
	public Vector3d normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector3d invert() { return mul(-1.0f); }
	
	public Vector3d add(Vec3dBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	public Vector3d add(double scalar) { return add(scalar, scalar, scalar); }
	public Vector3d add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }
	public Vector3d add(double x, double y, double z) { return set(getX() + x, getY() + y, getZ() + z); }

	public Vector3d sub(Vec3dBase v) { return sub(v.getX(), v.getY(), v.getZ()); }
	public Vector3d sub(double scalar) { return sub(scalar, scalar, scalar); }
	public Vector3d sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	public Vector3d sub(double x, double y, double z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	public Vector3d mul(Vec3dBase v) { return mul(v.getX(), v.getY(), v.getZ()); }
	public Vector3d mul(double scalar) { return mul(scalar, scalar, scalar); }
	public Vector3d mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	public Vector3d mul(double x, double y, double z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	public Vector3d div(Vec3dBase v) { return div(v.getX(), v.getY(), v.getZ()); }
	public Vector3d div(double scalar) { return div(scalar, scalar, scalar); }
	public Vector3d div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
	public Vector3d div(double x, double y, double z) { return set(getX() / x, getY() / y, getZ() / z); }
	
	
 	public Vector3d inverted() { return clone().invert(); }
	
 	public Vector3d normalized() { return clone().normalize(); }
	
 	public Vector3d addN(Vec3dBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3d addN(float scalar) { return addN(scalar, scalar, scalar); }
 	public Vector3d addN(double scalar) { return addN(scalar, scalar, scalar); }
 	public Vector3d addN(float x, float y, float z) { return clone().add(x, y, z); }
 	public Vector3d addN(double x, double y, double z) { return clone().add(x, y, z); }
	
 	public Vector3d subN(Vec3dBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3d subN(float scalar) { return subN(scalar, scalar, scalar); }
 	public Vector3d subN(double scalar) { return subN(scalar, scalar, scalar); }	
 	public Vector3d subN(float x, float y, float z) { return clone().sub(x, y, z); }
 	public Vector3d subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
 	public Vector3d mulN(Vec3dBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3d mulN(float scalar) { return mulN(scalar, scalar, scalar); }
 	public Vector3d mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
 	public Vector3d mulN(float x, float y, float z) { return clone().mul(x, y, z); }
 	public Vector3d mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
 	public Vector3d divN(Vec3dBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
 	public Vector3d divN(float scalar) { return divN(scalar, scalar, scalar); }
 	public Vector3d divN(double scalar) { return divN(scalar, scalar, scalar); }
 	public Vector3d divN(float x, float y, float z) { return clone().div(x, y, z); }
 	public Vector3d divN(double x, double y, double z) { return clone().div(x, y, z); }
	
	
 	
 	public Vector3d reflect(Vec3dBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		
		return this;
	}
	
 	public Vector3d lerp(Vec3dBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		
		return this;
	}
	
 	public Vector3d slerp(Vec3dBase v, double f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = (1 - f)	* sinAngle / sinAngle * getX();
		double x_2 = f			* sinAngle / sinAngle * v.getX();
		double x = x_1 + x_2;
		
		double y_1 = (1 - f)	* sinAngle / sinAngle * getY();
		double y_2 = f			* sinAngle / sinAngle * v.getY();
		double y = y_1 + y_2;
		
		double z_1 = (1 - f)	* sinAngle / sinAngle * getZ();
		double z_2 = f			* sinAngle / sinAngle * v.getZ();
		double z = z_1 + z_2;
		
		return new Vector3d(x, y, z);
	}
	
	
	
 	public Vector3d cross(Vec3dBase v) 
	{
		return new Vector3d(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
 	public Vector3d project(Vec3dBase v)
	{	
		Vector3d vn = (Vector3d) v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
 	public Vector3d rot(Vec3dBase axis, float angle)
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
	
 	public Vector3d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector3d(w.getX(), w.getY(), w.getZ());
	}

	
 	public Vector3d reflected(Vec3dBase normal)
	{
		Vector3d out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
 	public Vector3d lerped(Vec3dBase v, float f)
	{
		Vector3d out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vector3d clone() { return new Vector3d(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector3d)) return false;
		Vector3d v = (Vector3d)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		
		
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec3d(" + this.x + "d, " + this.y + "d, " + this.z + "d)"; }
	


}