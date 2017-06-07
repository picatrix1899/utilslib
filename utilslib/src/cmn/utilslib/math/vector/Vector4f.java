package cmn.utilslib.math.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.Streamable;
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
public class Vector4f implements Vec4f, Streamable.Readable, Streamable.Writeable, Serializable
{
	private static final long serialVersionUID = 1L;

	public static transient final int DIMENSIONS = 4;
	
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
	
	@Override
	public Vector4f setX(float x) { this.x = x; return this; }

	@Override
	public Vector4f setX(double x) { this.x = (float)x; return this; }

	@Override
	public Vector4f setY(float y) { this.y = y; return this; }

	@Override
	public Vector4f setY(double y) { this.y = (float)y; return this; }

	@Override
	public Vector4f setZ(float z) { this.z = z; return this; }

	@Override
	public Vector4f setZ(double z) { this.z = (float)z; return this; }

	@Override
	public Vector4f setA(float a) { this.a = a; return this; }

	@Override
	public Vector4f setA(double a) { this.a = (float)a; return this; }
	
	
	public Vector4f inverted() { return clone().invert(); }
	
	public Vector4f normalized() { return clone().normalize(); }
	
	
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
	public Vector4f addN(Vec4fBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	public Vector4f addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	public Vector4f subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	public Vector4f subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }
	public Vector4f subN(Vec4fBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	public Vector4f subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	
	public Vector4f mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	public Vector4f mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }
	public Vector4f mulN(Vec4fBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	public Vector4f mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	
	public Vector4f divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	public Vector4f divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }
	public Vector4f divN(Vec4fBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	public Vector4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	public Vector4f divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	
	public Vector4f normalize() { return Check.notNull(this) ? div(length()) : this; }

	public Vector4f invert() { return mul(-1.0f); }
	
	public Vector4f reflect(Vec4fBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		setA(getA() - (angle) * normal.getA());
		
		return this;
	}
	
	public Vector4f lerp(Vec4fBase v, double f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		setA(getA() + (v.getA() - getA()) * f);
		
		return this;
	}
	
	public Vector4f slerp(Vec4fBase v, double f)
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
		
		double a_1 = (1 - f)	* sinAngle / sinAngle * getA();
		double a_2 = f			* sinAngle / sinAngle * v.getA();
		float a = (float) (a_1 + a_2);
		
		return new Vector4f(x, y, z, a);
	}
	
	public Vector4f project(Vec4fBase v)
	{
		Vector4f vn = (Vector4f) v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	public Vector4f rot(Vec4fBase axis, float angle)
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
	
	public Vector4f rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector4f((float)w.getX(), (float)w.getY(), (float)w.getZ(), (float)w.getW());
	}

	
	public Vector4f reflected(Vec4fBase normal)
	{
		Vector4f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	public Vector4f lerped(Vec4fBase v, double f)
	{
		Vector4f out = clone();
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
	
	
	
	/*
	 * ===========================
	 * Streamable SERIALIZATION
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.x = dis.readFloat();
		this.y = dis.readFloat();
		this.z = dis.readFloat();
		this.a = dis.readFloat();
	}

	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
		dos.writeFloat(this.z);
		dos.writeFloat(this.a);
	}


	
}
