package cmn.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.api.Vector4f;

/**
 * A mathematical 4-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vec4f implements Vector4f, Streamable.Readable, Streamable.Writeable, Serializable
{
	private static final long serialVersionUID = 1L;

	public static transient final int DIMENSIONS = 4;
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	public float a = 0.0f;
	
	public Vec4f() { setZero(); }
	
	private Vec4f(Vec4f v) { set(v); }	
	
	public Vec4f(float scalar) { set(scalar); }
	
	public Vec4f(float x, float y, float z, float a) { set(x, y, z, a); }
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */
	public Vec4f setZero() { return set(0.0f); }

	public Vec4f set(Vec4f v) { return set(v.x, v.y, v.z, v.a); }
	
	public Vec4f set(float scalar) { return set(scalar, scalar, scalar, scalar); }	
	public Vec4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }	
	public Vec4f set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	public Vec4f set(double x, double y, double z, double a) { return setX(x).setY(y).setZ(z).setA(a); }	
	
	public Vec4f setX(float x) { this.x = x; return this; }
	public Vec4f setX(double x) { this.x = (float)x; return this; }	
	public Vec4f setY(float y) { this.y = y; return this; }
	public Vec4f setY(double y) { this.y = (float)y; return this; }	
	public Vec4f setZ(float z) { this.z = z; return this; }
	public Vec4f setZ(double z) { this.z = (float)z; return this; }	
	public Vec4f setA(float a) { this.a = a; return this; }
	public Vec4f setA(double a) { this.a = (float)a; return this; }	
	

	/*
	 * ====================
	 * BASIC-OPERATIONS
	 * ====================
	 */
	public Vec4f add(Vec4f v) { return add(v.x, v.y, v.z, v.a); }
	public Vec4f add(float scalar) { return add(scalar, scalar, scalar, scalar); }
	public Vec4f add(double scalar) { return add(scalar, scalar, scalar, scalar); }
	public Vec4f add(float x, float y, float z, float a) { return set(this.x + x, this.y + y, this.z + z, this.a + a); }
	public Vec4f add(double x, double y, double z, double a) { return set(this.x + x, this.y + y, this.z + z, this.a + a); }

	public Vec4f sub(Vec4f v) { return sub(v.x, v.y, v.z, v.a); }
	public Vec4f sub(float scalar) { return sub(scalar, scalar, scalar, scalar); }
	public Vec4f sub(double scalar) { return sub(scalar, scalar, scalar, scalar); }	
	public Vec4f sub(float x, float y, float z, float a) { return set(this.x - x, this.y - y, this.z - z, this.a - a); }
	public Vec4f sub(double x, double y, double z, double a) { return set(this.x - x, this.y - y, this.z - z, this.a - a); }
	
	public Vec4f mul(Vec4f v) { return mul(v.x, v.y, v.z, v.a); }
	public Vec4f mul(float scalar) { return mul(scalar, scalar, scalar, scalar); }
	public Vec4f mul(double scalar) { return mul(scalar, scalar, scalar, scalar); }	
	public Vec4f mul(float x, float y, float z, float a) { return set(this.x * x, this.y * y, this.z * z, this.a * a); }
	public Vec4f mul(double x, double y, double z, double a) { return set(this.x * x, this.y * y, this.z * z, this.a * a); }
	
	public Vec4f div(Vec4f v) { return div(v.x, v.y, v.z, v.a); }
	public Vec4f div(float scalar) { return div(scalar, scalar, scalar, scalar); }
	public Vec4f div(double scalar) { return div(scalar, scalar, scalar, scalar); }	
	public Vec4f div(float x, float y, float z, float a) { return set(this.x / x, this.y / y, this.z / z, this.a / a); }
	public Vec4f div(double x, double y, double z, double a) { return set(this.x / x, this.y / y, this.z / z, this.a / a); }
	
	
	
	
	public Vec4f addN(Vec4f v) { return addN(v.x, v.y, v.z, v.a); }
	public Vec4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	public Vec4f addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }	
	public Vec4f addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
	public Vec4f addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }
	
	public Vec4f subN(Vec4f v) { return subN(v.x, v.y, v.z, v.a); }
	public Vec4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	public Vec4f subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	public Vec4f subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	public Vec4f subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }
	
	public Vec4f mulN(Vec4f v) { return mulN(v.x, v.y, v.z, v.a); }
	public Vec4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	public Vec4f mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	public Vec4f mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	public Vec4f mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }
	
	public Vec4f divN(Vec4f v) { return divN(v.x, v.y, v.z, v.a); }
	public Vec4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	public Vec4f divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }	
	public Vec4f divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	public Vec4f divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }
	
	
	/*
	 * =====================
	 * VECTOR-OPERATIONS
	 * =====================
	 */
	public float dot(Vec4f v) { return this.x  * v.x + this.y * v.y + this.z + v.z + this.a + v.a; }
	
	public float squaredLength() { return x * x + y * y + z * z + a * a; }
	
	public float length() { return (float)Math.sqrt(squaredLength()); }
	
	public Vec4f normalize() { return div(length()); }
	
	public Vec4f normalized() { return clone().normalize(); }
	
	public Vec4f invert() { return mul(-1.0f); }
	
	public Vec4f inverted() { return clone().invert(); }
	
	
	public float max() { return Math.max(this.x, Math.max(this.y, Math.max(this.z, this.a))); }
	
	public float min() { return Math.min(this.x, Math.min(this.y, Math.min(this.z, this.a))); }
	
	

	
	public Vec4f abs()
	{
		setX((float) Math.abs(this.x));
		setY((float) Math.abs(this.y));
		setZ((float) Math.abs(this.z));
		setA((float) Math.abs(this.a));
		
		return this;
	}


	/*
	 * =========================
	 * ROUNDING
	 * =========================
	 */
	public Vec4f floor()
	{
		setX((float) Math.floor(this.x));
		setY((float) Math.floor(this.y));
		setZ((float) Math.floor(this.z));
		setA((float) Math.floor(this.a));
		
		return this;
	}
	
	public Vec4f ceil()
	{
		setX((float) Math.ceil(this.x));
		setY((float) Math.ceil(this.y));
		setZ((float) Math.ceil(this.z));
		setA((float) Math.ceil(this.a));
		
		return this;
	}

	
	public Vec4f round()
	{
		setX((float) Math.round(this.x));
		setY((float) Math.round(this.y));
		setZ((float) Math.round(this.z));
		setA((float) Math.round(this.a));
		
		return this;
	}

	
	
	public Vec4f absN() { return clone().round(); }
	
	public Vec4f floorN() { return clone().round(); }
	
	public Vec4f ceilN() { return clone().ceil(); }

	public Vec4f roundN() { return clone().round(); }
	
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vec4f clone() { return new Vec4f(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vec4f)) return false;
		Vec4f v = (Vec4f)obj;
		
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
