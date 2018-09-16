package cmn.utilslib.math.vector;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec4f;
import cmn.utilslib.math.vector.api.Vec4fBase;

/**
 * A mathematical 4-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector4f implements Vec4f
{
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	public float a = 0.0f;
	
	public Vector4f() { setZero(); }
	
	public Vector4f(Vec4fBase v) { set(v); }	
	
	public Vector4f(float scalar) { set(scalar); }
	
	public Vector4f(float x, float y, float z, float a) { set(x, y, z, a); }
	

	@Override
	public float getX() { return this.x; }

	@Override
	public float getY() { return this.y; }

	@Override
	public float getZ() { return this.z; }

	@Override
	public float getA() { return this.a; }
	

	public Vector4f setZero() { return set(0.0f); }
	
	public Vector4f set(Vec4fBase v) { return set(v.getX(), v.getY(), v.getZ(), v.getA()); }
	
	public Vector4f set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	public Vector4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	public Vector4f set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	public Vector4f set(double x, double y, double z, double a) { return setX(x).setY(y).setZ(z).setA(a); }
	
	public Vector4f setX(float x) { this.x = x; return this; }

	public Vector4f setX(double x) { this.x = (float)x; return this; }

	public Vector4f setY(float y) { this.y = y; return this; }

	public Vector4f setY(double y) { this.y = (float)y; return this; }

	public Vector4f setZ(float z) { this.z = z; return this; }

	public Vector4f setZ(double z) { this.z = (float)z; return this; }

	public Vector4f setA(float a) { this.a = a; return this; }

	public Vector4f setA(double a) { this.a = (float)a; return this; }
	
	
	public Vector4f invertN() { return clone().invert(); }
	
	public Vector4f normalizeN() { return clone().normalize(); }
	
	
	public Vector4f add(Vec4fBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f add(double scalar) { return add(scalar, scalar, scalar, scalar); }
	public Vector4f add(float x, float y, float z, float a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }
	public Vector4f add(double x, double y, double z, double a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }

	public Vector4f sub(Vec4fBase v) { return sub(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f sub(double scalar) { return sub(scalar, scalar, scalar, scalar); }
	public Vector4f sub(float x, float y, float z, float a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	public Vector4f sub(double x, double y, double z, double a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	
	public Vector4f mul(Vec4fBase v) { return mul(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f mul(double scalar) { return mul(scalar, scalar, scalar, scalar); }
	public Vector4f mul(float x, float y, float z, float a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	public Vector4f mul(double x, double y, double z, double a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	
	public Vector4f div(Vec4fBase v) { return div(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f div(double scalar) { return div(scalar, scalar, scalar, scalar); }
	public Vector4f div(float x, float y, float z, float a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	public Vector4f div(double x, double y, double z, double a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }

	
	
	
	public Vector4f addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
	public Vector4f addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }
	public Vector4f addN(Vec4f v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	public Vector4f addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	public Vector4f subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	public Vector4f subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }
	public Vector4f subN(Vec4f v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	public Vector4f subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	
	public Vector4f mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	public Vector4f mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }
	public Vector4f mulN(Vec4f v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	public Vector4f mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	
	public Vector4f divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	public Vector4f divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }
	public Vector4f divN(Vec4f v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	public Vector4f divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	
	public Vector4f normalize() { return Check.notNull(this) ? div(length()) : this; }

	public Vector4f invert() { return mul(-1.0f); }
	
	public double dot(Vec4f v)
	{
		return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ() + this.a * v.getA();
	}
	
	public Vector4f reflect(Vec4f normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		setA(getA() - (angle) * normal.getA());
		
		return this;
	}

	public Vector4f project(Vec4f v)
	{
		Vector4f vn = (Vector4f) v.normalizeN();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	public Vector4f rotate(Vec4f axis, float angle)
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
		
		return rotate(rotation);
	}
	
	public Vector4f rotate(Vec4f axis, double angle)
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
		
		return rotate(rotation);
	}
	
	public Vector4f rotate(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector4f((float)w.getX(), (float)w.getY(), (float)w.getZ(), (float)w.getW());
	}

	
	public Vector4f reflectN(Vec4f normal)
	{
		Vector4f out = clone();
		
		out.reflect(normal);
		
		return out;
	}

	public Vector4f invertFrom(Vec4f v)
	{
		this.x = v.getX() - this.x;
		this.y = v.getY() - this.y;
		this.z = v.getZ() - this.z;
		this.a = v.getA() - this.a;
		return this;
	}

	public Vector4f invertFrom(float max)
	{
		this.x = max - this.x;
		this.y = max - this.y;
		this.z = max - this.z;
		this.a = max - this.a;
		return this;
	}
	
	public Vector4f invertFrom(double max)
	{
		this.x = (float)max - this.x;
		this.y = (float)max - this.y;
		this.z = (float)max - this.z;
		this.a = (float)max - this.a;
		return this;
	}
	
	public Vector4f invertFrom(float x, float y, float z, float a)
	{
		this.x = x - this.x;
		this.y = y - this.y;
		this.z = z - this.z;
		this.a = a - this.a;
		return this;
	}
	
	public Vector4f invertFrom(double x, double y, double z, double a)
	{
		this.x = (float)x - this.x;
		this.y = (float)y - this.y;
		this.z = (float)z - this.z;
		this.a = (float)a - this.a;
		return this;
	}
	
	public Vector4f negate()
	{
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
		this.a = -this.a;
		return this;
	}
	
	public Vector4f inverse()
	{
		this.x = 1.0f / this.x;
		this.y = 1.0f / this.y;
		this.z = 1.0f / this.z;
		this.a = 1.0f / this.a;
		return this;
	}
	
	
	public Vector4f invertFromN(Vec4f v)
	{
		return clone().invertFrom(v);
	}

	public Vector4f invertFromN(float max)
	{
		return clone().invertFrom(max);
	}

	public Vector4f invertFromN(double max)
	{
		return clone().invertFrom(max);
	}

	public Vector4f invertFromN(float x, float y, float z, float a)
	{
		return clone().invertFrom(x,y,z,a);
	}

	public Vector4f invertFromN(double x, double y, double z, double a)
	{
		return clone().invertFrom(x,y,z,a);
	}

	public Vector4f inverseN()
	{
		return clone().inverse();
	}

	public Vector4f negateN()
	{
		return clone().negate();
	}

	public Vector4f rotateN(Vec4f axis, float angle)
	{
		return clone().rotate(axis, angle);
	}

	public Vector4f rotateN(Vec4f axis, double angle)
	{
		return clone().rotate(axis, angle);
	}

	public Vector4f rotateN(Quaternion q)
	{
		return clone().rotate(q);
	}

	public double angleRad(Vec4f v) { return Math.acos((dot(v)) / (length() * v.length())); }

	public double angleDeg(Vec4f v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	public double length() { return Math.sqrt(squaredLength()); }

	public double squaredLength() { return this.x * this.x + this.y * this.y + this.z * this.z + this.a * this.a; }
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vector4f clone() { return new Vector4f(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector4f)) return false;
		Vector4f v = (Vector4f)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		if(v.a != this.a) return false;
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec4f(" + this.x + "f, " + this.y + "f, " + this.z + "f, " + this.a + "f)"; }
	
}
