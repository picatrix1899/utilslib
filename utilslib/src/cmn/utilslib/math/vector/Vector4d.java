package cmn.utilslib.math.vector;

import java.io.Serializable;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec4d;
import cmn.utilslib.math.vector.api.Vec4dBase;

/**
 * A mathematical 4-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector4d implements Vec4d, Serializable
{
	private static final long serialVersionUID = 1L;

	public static transient final int DIMENSIONS = 4;
	
	public double x = 0.0d;
	public double y = 0.0d;
	public double z = 0.0d;
	public double a = 0.0d;
	
	public Vector4d() { setZero(); }
	
	public Vector4d(Vec4dBase v) { set(v); }	
	
	public Vector4d(double scalar) { set(scalar); }
	
	public Vector4d(double x, double y, double z, double a) { set(x, y, z, a); }
	

	@Override
	public double getX() { return this.x; }

	@Override
	public double getY() { return this.y; }

	@Override
	public double getZ() { return this.z; }

	@Override
	public double getA() { return this.a; }
	

	public Vector4d setZero() { return set(0.0f); }
	
	public Vector4d set(Vec4dBase v) { return set(v.getX(), v.getY(), v.getZ(), v.getA()); }
	
	public Vector4d set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	public Vector4d set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	public Vector4d set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	public Vector4d set(double x, double y, double z, double a) { return setX(x).setY(y).setZ(z).setA(a); }
	
	@Override
	public Vector4d setX(float x) { this.x = x; return this; }

	@Override
	public Vector4d setX(double x) { this.x = x; return this; }

	@Override
	public Vector4d setY(float y) { this.y = y; return this; }

	@Override
	public Vector4d setY(double y) { this.y = y; return this; }

	@Override
	public Vector4d setZ(float z) { this.z = z; return this; }

	@Override
	public Vector4d setZ(double z) { this.z = z; return this; }

	@Override
	public Vector4d setA(float a) { this.a = a; return this; }

	@Override
	public Vector4d setA(double a) { this.a = a; return this; }
	
	
	public Vector4d inverted() { return clone().invert(); }
	
	public Vector4d normalized() { return clone().normalize(); }
	
	
	public Vector4d add(Vec4dBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d add(double scalar) { return add(scalar, scalar, scalar, scalar); }
	public Vector4d add(float x, float y, float z, float a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }
	public Vector4d add(double x, double y, double z, double a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }

	public Vector4d sub(Vec4dBase v) { return sub(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d sub(double scalar) { return sub(scalar, scalar, scalar, scalar); }
	public Vector4d sub(float x, float y, float z, float a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	public Vector4d sub(double x, double y, double z, double a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	
	public Vector4d mul(Vec4dBase v) { return mul(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d mul(double scalar) { return mul(scalar, scalar, scalar, scalar); }
	public Vector4d mul(float x, float y, float z, float a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	public Vector4d mul(double x, double y, double z, double a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	
	public Vector4d div(Vec4dBase v) { return div(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d div(double scalar) { return div(scalar, scalar, scalar, scalar); }
	public Vector4d div(float x, float y, float z, float a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	public Vector4d div(double x, double y, double z, double a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }

	
	
	
	public Vector4d addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
	public Vector4d addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }
	public Vector4d addN(Vec4dBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	public Vector4d addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	public Vector4d subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	public Vector4d subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }
	public Vector4d subN(Vec4dBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	public Vector4d subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	
	public Vector4d mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	public Vector4d mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }
	public Vector4d mulN(Vec4dBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	public Vector4d mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	
	public Vector4d divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	public Vector4d divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }
	public Vector4d divN(Vec4dBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4d divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	public Vector4d divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	
	public Vector4d normalize() { return Check.notNull(this) ? div(length()) : this; }

	public Vector4d invert() { return mul(-1.0f); }
	
	public Vector4d reflect(Vec4dBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		setA(getA() - (angle) * normal.getA());
		
		return this;
	}
	
	public Vector4d lerp(Vec4dBase v, double f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		setA(getA() + (v.getA() - getA()) * f);
		
		return this;
	}
	
	public Vector4d slerp(Vec4dBase v, double f)
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
		
		double a_1 = (1 - f)	* sinAngle / sinAngle * getA();
		double a_2 = f			* sinAngle / sinAngle * v.getA();
		double a = a_1 + a_2;
		
		return new Vector4d(x, y, z, a);
	}
	
	public Vector4d project(Vec4dBase v)
	{
		Vector4d vn = (Vector4d) v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	public Vector4d rot(Vec4dBase axis, float angle)
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
	
	public Vector4d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector4d(w.getX(), w.getY(), w.getZ(), w.getW());
	}

	
	public Vector4d reflected(Vec4dBase normal)
	{
		Vector4d out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	public Vector4d lerped(Vec4dBase v, double f)
	{
		Vector4d out = clone();
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
	public Vector4d clone() { return new Vector4d(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector4d)) return false;
		Vector4d v = (Vector4d)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		if(v.a != this.a) return false;
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec4d(" + this.x + "f, " + this.y + "f, " + this.z + "f, " + this.a + "f)"; }

}
